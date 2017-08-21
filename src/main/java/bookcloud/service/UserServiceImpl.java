package bookcloud.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookcloud.dto.User;
import bookcloud.mapper.AccountMapper;

  
@Service
@Component
public class UserServiceImpl implements UserService {
      
     @Autowired
     AccountMapper mapper;
     
     private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  
     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          User user = mapper.readUser(username);
          user.setAuthorities(getAuthorities(username));
           
          return user;
     }
      
     public Collection<GrantedAuthority> getAuthorities(String username) {
         Collection<GrantedAuthority> authorities = mapper.readAuthority(username);
         return authorities;
     }

     @Override
     public User readUser(String username) {
          User user = mapper.readUser(username);
          user.setAuthorities(mapper.readAuthority(username));
          return user;
     }
 
     @Transactional(rollbackFor=Exception.class)
     @Override
     public void createUser(User user) {
          String rawPassword = user.getPassword();
          String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
          user.setPassword(encodedPassword);
          user.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
          mapper.createUser(user);
          mapper.createAuthority(user);
     }
 
     @Override
     public void deleteUser(String username) {
    	 mapper.deleteUser(username);
    	 mapper.deleteAuthority(username);
     }
 
 
     @Override
     public PasswordEncoder passwordEncoder() {
          return this.passwordEncoder;
     }


}

