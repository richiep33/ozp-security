package ozp.security

import org.springframework.security.core.userdetails.User

/**
 * Created by richiep on 9/3/14.
 */
public interface AuthorizationManager {
    User getAuthenticatedUser()
    Set<String> getAuthenticatedUserRoles() throws ServiceException
//    SecurityCredentials getAuthenticatedUserCredentials() throws ServiceException
    SecurityCredentials getCredentialsForUser(String userId) throws ServiceException
}