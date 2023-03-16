package com.rest.servicedb.repository;

import com.rest.dto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
