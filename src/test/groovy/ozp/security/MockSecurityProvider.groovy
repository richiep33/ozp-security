package ozp.security

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * Created by richiep on 8/4/14.
 */
@Component
class MockSecurityProvider implements SecurityProvider {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    SecurityCredentials getCredentialsForUser(String userId) throws ServiceException {
        logger.info("** Retrieving credentials for user ${userId} **")

        SecurityCredentials securityCredentials = new SecurityCredentials();

        securityCredentials.userId = userId
        securityCredentials.roles = ['ROLE_USER', 'ROLE_ADMIN']
        securityCredentials.enabled = true
        securityCredentials.expired = false
        securityCredentials.locked = false

        //securityCredentials.roles = ['ROLE_LOSER', 'ROLE_ADMIN']
        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1 roles: ${securityCredentials.roles}")

        return securityCredentials
    }
}
