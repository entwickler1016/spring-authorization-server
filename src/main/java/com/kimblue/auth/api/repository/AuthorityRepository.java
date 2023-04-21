package com.kimblue.auth.api.repository;

import com.kimblue.auth.api.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
