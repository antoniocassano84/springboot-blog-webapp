package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.RegistrationDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.RoleRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void saveUser(RegistrationDto registrationDto) {
    User user = new User();
    user.setName(registrationDto.getFirstName() + " " + registrationDto.getLastName());
    user.setEmail(registrationDto.getEmail());
    user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
    user.setRoles(List.of(roleRepository.findByName("ROLE_GUEST")));
    userRepository.save(user);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }
}
