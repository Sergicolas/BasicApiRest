package com.scz.BasicApiRest.repository;

import com.scz.BasicApiRest.models.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegisterRepository extends JpaRepository<UserRegister, Long> {

    UserRegister findUserById(long id);
}
