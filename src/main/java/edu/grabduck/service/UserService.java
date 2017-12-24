package edu.grabduck.service;

import com.google.common.collect.ImmutableList;
import edu.grabduck.domain.Role;
import edu.grabduck.domain.User;
import edu.grabduck.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    // Hack !!!
    @PostConstruct
    public void init() {
        if(!userDao.findByUsername("nmyza").isPresent()) {
           userDao.save(User.builder()
                   .username("nmyza")
                   .password("1")
                   .authorities(ImmutableList.of(Role.USER))
                   .accountNonExpired(true)
                   .accountNonLocked(true)
                   .credentialsNonExpired(true)
                   .enabled(true)
                   .build()
           );
        }

        userDao.findByUsername("nmyza").ifPresent(user -> {
           user.setPassword(new BCryptPasswordEncoder().encode("1"));
           userDao.save(user);
        });
    }

    @Override
    public UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
        return userDao
                .findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("The user name " + username + " was not found"));
    }
}
