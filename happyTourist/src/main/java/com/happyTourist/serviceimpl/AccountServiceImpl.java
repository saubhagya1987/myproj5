package com.happyTourist.serviceimpl;

import java.util.Date;
import java.util.Locale;

import org.ireslab.notification.bean.MailUser;
import org.ireslab.notification.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.happyTourist.enumdata.HappyTouristUserCode;
import com.happyTourist.enumdata.Role;
import com.happyTourist.exception.HappyTouristException;
import com.happyTourist.service.AccountService;
import com.happyTourist.utils.MaskUtils;
import com.happyTouristDTO.AccountDto;
import com.happyTouristDTO.AccountResponseDto;
import com.happyTouristPersistence.dao.AccountDao;
import com.happyTouristPersistence.dao.UserOauthDetailsDao;
import com.happyTouristPersistence.entity.Account;
import com.happyTouristPersistence.entity.UserOauthDetails;
@Component
//@Transactional
public class AccountServiceImpl implements AccountService{
	private static final String MAIL_SUBJECT="mail.subject";
	@Autowired
	private MessageSource messageSource;	
	@Autowired
	AccountDao accountDao;
	@Autowired
	UserOauthDetailsDao userOauthDetailsDao;
	
	@Autowired
	MailService mailService;
	

	/**
	 * Creates the user.
	 *
	 * @param accountDto the account dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public AccountResponseDto createUser(AccountDto accountDto) throws HappyTouristException {
		AccountResponseDto accountResponseDto=new AccountResponseDto();
		//Checking whether Account Exist Or Not
		Account accountDetails=accountDao.getAccountDetails(accountDto.getUserName());
		if(accountDetails!=null)
		{
			accountResponseDto.setAccountId(accountDetails.getAccountId());
			accountResponseDto.setMobileNumber(accountDetails.getMobileNumber());
			accountResponseDto.setEmailId(accountDetails.getEmailId());
			accountResponseDto.setUserName(accountDetails.getUserName());
			accountResponseDto.setIsActive(accountDetails.getIsActive());
		}
		else{
			String activationCode=MaskUtils.generateSecurityCode();
			Account account =new Account();
			account.setEmailId(accountDto.getEmailId());
			account.setUserName(accountDto.getUserName());
			account.setIsActive(false);			
			account.setMobileNumber(accountDto.getMobileNumber());
			account.setPassword(DigestUtils.md5DigestAsHex(accountDto.getPassword().getBytes()));
			account.setCreationTime(new Date());
			account.setActivationCode(activationCode);
			accountDao.save(account);
			
			//Parallel entry in User_oauth_details table for User_Role
			UserOauthDetails userOauthDetails=new UserOauthDetails();
			userOauthDetails.setAccountNonExpired(true);
			userOauthDetails.setAccountNonLocked(true);
			userOauthDetails.setAuthorities(Role.ROLE_USER.getKey());
			userOauthDetails.setCredentialsNonExpired(true);
			userOauthDetails.setEnabled(true);
			userOauthDetails.setUserName(accountDto.getUserName());
			userOauthDetailsDao.save(userOauthDetails);
			
			//For Sending OTP Through Mail
			MailUser mailUser =new MailUser();
			mailUser.setEmailAddress(accountDto.getEmailId());
			mailUser.setSubject(messageSource.getMessage(MAIL_SUBJECT, null, Locale.getDefault()));
			mailUser.setTemplateName("CreateUserMailTemplate.html");
			mailUser.setUserActivationCode(activationCode);
			mailUser.setUserName(accountDto.getUserName());			
			mailService.sendEmail(mailUser);
			
			accountResponseDto.setAccountId(account.getAccountId());
			accountResponseDto.setMobileNumber(account.getMobileNumber());
			accountResponseDto.setEmailId(account.getEmailId());
			accountResponseDto.setUserName(account.getUserName());
			accountResponseDto.setIsActive(account.getIsActive());
		}
		return accountResponseDto;
	}
	/**
	 * Signin.
	 *
	 * @param accountDto the account dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */

	@Override
	public AccountResponseDto signin(AccountDto accountDto)	throws HappyTouristException {
        AccountResponseDto accountResponseDto=new AccountResponseDto();
        Account account=accountDao.getAccountDetails(accountDto.getUserName());        
        
		//Account account=accountDao.getProfileInfo(accountDto.getUserName(),DigestUtils.md5DigestAsHex(accountDto.getPassword().getBytes()));
		if(account==null){
			throw new HappyTouristException(HappyTouristUserCode.USER_NOT_FOUND);
		}
		else
		{
			if(!account.getIsActive())
				throw new HappyTouristException(HappyTouristUserCode.USER_NOT_ACTIVATED);
			else if(!account.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(accountDto.getPassword().getBytes()))){
				throw new HappyTouristException(HappyTouristUserCode.USER_NOT_AUTHENTICATED);
			}
			else{
				accountResponseDto.setAccountId(account.getAccountId());
				accountResponseDto.setMobileNumber(account.getMobileNumber());
				accountResponseDto.setEmailId(account.getEmailId());
				accountResponseDto.setUserName(account.getUserName());
				accountResponseDto.setIsActive(account.getIsActive());
			}
		}
		
		return accountResponseDto;
	}

	/**
	 * Activate user.
	 *
	 * @param accountDto the account dto
	 * @return the happy tourist response
	 * @throws HappyTouristException the happy tourist exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public AccountResponseDto activateUser(AccountDto accountDto)throws HappyTouristException {
		AccountResponseDto accountResponseDto=new AccountResponseDto();
        Account account=accountDao.getAccountDetails(accountDto.getUserName());        
        if(account.getActivationCode().equalsIgnoreCase(accountDto.getActivationCode())){
          account.setIsActive(true);
          accountDao.merge(account);
        }
        accountResponseDto.setAccountId(account.getAccountId());
		accountResponseDto.setMobileNumber(account.getMobileNumber());
		accountResponseDto.setEmailId(account.getEmailId());
		accountResponseDto.setUserName(account.getUserName());
		accountResponseDto.setIsActive(account.getIsActive());
        
		return accountResponseDto;
	}
	
	
}
