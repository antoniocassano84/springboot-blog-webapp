package net.javaguides.springboot.service;

import java.util.Optional;
import net.javaguides.springboot.dto.RegistrationDto;
import net.javaguides.springboot.entity.User;

public interface UserService {

  void saveUser(RegistrationDto registrationDto);

  Optional<User> findByEmail(String email);
}
