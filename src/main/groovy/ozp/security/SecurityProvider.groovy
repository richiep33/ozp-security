package ozp.security

/**
 * Created by richiep on 8/4/14.
 */
public interface SecurityProvider {
    public SecurityCredentials getCredentialsForUser(String userId) throws Exception;
}