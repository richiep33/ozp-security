package ozp.security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by richiep on 8/4/14.
 */
@ToString(includeNames=true)
@EqualsAndHashCode(includeFields=true)
class PkiBasedSecurityCredentials extends SecurityCredentials {
    String dn
}
