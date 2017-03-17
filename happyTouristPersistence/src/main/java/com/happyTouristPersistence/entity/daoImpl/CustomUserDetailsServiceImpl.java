package com.happyTouristPersistence.entity.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.happyTouristPersistence.dao.AccountDao;
import com.happyTouristPersistence.dao.UserOauthDetailsDao;
import com.happyTouristPersistence.entity.Account;
import com.happyTouristPersistence.entity.UserOauthDetails;

@Component(value = "customUserDetailsServiceImpl")
@Transactional
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	// @Autowired
	// private UserOauthDetailsRepository oauthRepository;

	@Autowired
	private UserOauthDetailsDao oauthRepository;

	// @Autowired
	// private UserCrudRepository userCrudRepository;

	@Autowired
	private AccountDao accountDao;

	@Override
	public UserDetails loadUserByUsername(String requestUsername)
			throws UsernameNotFoundException {

		// String username = requestUsername.toLowerCase();
		Account accountDetails = accountDao.getAccountDetails(requestUsername);

		// com.reef.domain.User user = userCrudRepository.findOne(username);
		if (accountDetails == null) {
			throw new UsernameNotFoundException("Account not found exception");
		}

		UserOauthDetails oauthdetail = oauthRepository.getUserOauthDetails(requestUsername);
		try {
			if (oauthdetail == null) {
				oauthdetail = new UserOauthDetails(requestUsername, null,
						"ROLE_USER");
				oauthdetail.setAccountNonExpired(true);
				oauthdetail.setAccountNonLocked(true);
				oauthdetail.setCredentialsNonExpired(true);
				oauthdetail.setEnabled(true);
				oauthRepository.save(oauthdetail);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String authoritiesString = oauthdetail.getAuthorities();
		String authorities[] = authoritiesString.split(",");
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (String authority : authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority));
		}

		return new User(requestUsername, accountDetails.getPassword(),
				oauthdetail.isEnabled(), oauthdetail.isAccountNonExpired(),
				oauthdetail.isCredentialsNonExpired(),
				oauthdetail.isAccountNonLocked(), grantedAuthorities);

	}

	/*public void setOauthRepository(UserOauthDetailsDao oauthRepository) {
		this.oauthRepository = oauthRepository;
	}*/

}
