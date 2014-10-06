package ozp.security

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Created by richiep on 8/4/14.
 */
@Service("userDetailsService")
class OzpUserDetailsService implements UserDetailsService {
    Log log = LogFactory.getLog(this.getClass());

    @Autowired
    AuthorizationManager authorizationManager

    @Override
    UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = null
        SecurityCredentials credentials

        credentials = authorizationManager.getCredentialsForUser(userId)

        List<GrantedAuthority> authorities = toAuthorities(credentials.roles);

        user = new User(credentials.userId,
                credentials instanceof PasswordBasedSecurityCredentials ?
                    ((PasswordBasedSecurityCredentials)credentials).password.toLowerCase() : "",
                credentials.enabled,
                !credentials.expired,
                !credentials.expired,
                !credentials.locked,
                authorities);

        return user
    }

    public Collection<? extends GrantedAuthority> toAuthorities(Set<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities
    }
}
