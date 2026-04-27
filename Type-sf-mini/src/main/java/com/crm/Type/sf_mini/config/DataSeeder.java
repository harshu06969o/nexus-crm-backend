package com.crm.Type.sf_mini.config;

import com.crm.Type.sf_mini.model.Role;
import com.crm.Type.sf_mini.model.User;
import com.crm.Type.sf_mini.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public DataSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void run(String... args) {
    seedUsersIfEmpty();
  }

  private void seedUsersIfEmpty() {
    if (userRepository.count() > 0) {
      System.out.println("User table is not empty. Skipping default user seeding.");
      return;
    }

    User adminUser =
        User.builder()
            .username("admin")
            .password(passwordEncoder.encode("admin123"))
            .role(Role.ADMIN)
            .build();
    userRepository.save(adminUser);
    System.out.println("Created default user: admin with role ROLE_ADMIN");

    User salesUser =
        User.builder()
            .username("sales")
            .password(passwordEncoder.encode("sales123"))
            .role(Role.SALES_REP)
            .build();
    userRepository.save(salesUser);
    System.out.println("Created default user: sales with role ROLE_SALES_REP");
  }
}
