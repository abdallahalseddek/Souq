package com.souq.shop.repository;

import com.souq.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
