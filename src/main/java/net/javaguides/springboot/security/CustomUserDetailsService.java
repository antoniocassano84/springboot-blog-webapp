package net.javaguides.springboot.security;

import java.util.Optional;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optUser = userRepository.findByEmail(username);
    if(optUser.isPresent()) {
      User user = optUser.get();
      return
          new org.springframework.security.core.userdetails.User(
              user.getEmail(),
              user.getPassword(),
              user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                  .toList()
          );
    } else {
      throw new UsernameNotFoundException("Invalid username and password");
    }
  }
}
