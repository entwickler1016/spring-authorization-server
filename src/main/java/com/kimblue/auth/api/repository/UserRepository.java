package com.kimblue.auth.api.repository;

import com.kimblue.auth.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
