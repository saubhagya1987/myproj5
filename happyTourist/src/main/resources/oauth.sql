--insert  into user_oauth_details
--(id,account_non_expired,account_non_locked,
--authorities,credentials_non_expired,enabled,username)
-- values (1,1,1,'ROLE_USER',1,1,'ab');


 CREATE TABLE oauth_access_token (
  token_id varchar(256) DEFAULT NULL,
  token VARBINARY(MAX),
  authentication_id varchar(256) DEFAULT NULL,
  user_name varchar(256) DEFAULT NULL,
  client_id varchar(256) DEFAULT NULL,
  authentication VARBINARY(MAX),
  refresh_token varchar(256) DEFAULT NULL
) 

--CREATE TABLE oauth_refresh_token (
--  token_id varchar(256) DEFAULT NULL,
--  token VARBINARY(MAX),
--  authentication VARBINARY(MAX)
--) 
