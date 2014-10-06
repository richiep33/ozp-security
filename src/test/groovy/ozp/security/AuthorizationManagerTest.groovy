package ozp.security

import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by richiep on 10/2/14.
 */
@ContextConfiguration(classes = Bootie.class)
@EnableAspectJAutoProxy
@RunWith(SpringJUnit4ClassRunner.class)
class AuthorizationManagerTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AuthorizationManager authorizationManager

    @Test
    public void getCredentialsForUserTest() {
        SecurityCredentials credentials
        credentials = authorizationManager.getCredentialsForUser("ejfudd")
        credentials = authorizationManager.getCredentialsForUser("ejfudd")
        credentials = authorizationManager.getCredentialsForUser("ejfudd")
        credentials = authorizationManager.getCredentialsForUser("ejfudd")
        logger.info("credentials for user = '${credentials.userId}:  credentials")

        credentials = authorizationManager.getCredentialsForUser("bbunny")

        logger.info("credentials for user = '${credentials.userId}:  credentials")
    }
}
