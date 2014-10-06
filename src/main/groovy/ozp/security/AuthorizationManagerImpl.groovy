package ozp.security

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Service

/**
 * Created by richiep on 9/3/14.
 */
@Service
class AuthorizationManagerImpl implements AuthorizationManager {
    private static final String CACHE_NAME="credential-cache"

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SecurityProvider securityProvider

    @Override
    public User getAuthenticatedUser() {
        User user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return user;
    }

    @Override
    public Set<String> getAuthenticatedUserRoles() throws ServiceException {
        User authenticatedUser = getAuthenticatedUser();
        def roles = [] as Set<String>

        if (authenticatedUser != null && authenticatedUser.getAuthorities() != null) {
            for (GrantedAuthority authority : authenticatedUser.getAuthorities()) {
                logger.debug("Adding authority ${authority.getAuthority()}")
                roles.add(authority.getAuthority())
            }
        }

        return roles;
    }

    @Override
    @Cacheable(value = AuthorizationManagerImpl.CACHE_NAME, unless="#result == null")
    public SecurityCredentials getCredentialsForUser(String userId) throws ServiceException {
        logger.info("retrieving credentials for  ${userId}")

        return securityProvider.getCredentialsForUser(userId);
    }
}
