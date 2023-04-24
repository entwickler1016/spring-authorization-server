package com.kimblue.auth.api.repository;

import com.kimblue.auth.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
