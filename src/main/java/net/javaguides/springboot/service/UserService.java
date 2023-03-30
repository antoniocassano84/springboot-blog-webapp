package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.RegistrationDto;

public interface UserService {

  void saveUser(RegistrationDto registrationDto);

}
