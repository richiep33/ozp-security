package ozp.security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by richiep on 8/4/14.
 */
@ToString(includeNames=true)
@EqualsAndHashCode(includeFields=true)
class SecurityCredentials {
    String userId
    boolean enabled
    boolean expired
    boolean locked

    Set<String> roles
}
