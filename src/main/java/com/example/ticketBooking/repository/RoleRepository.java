package com.example.ticketBooking.repository;

import com.example.ticketBooking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String user);
}

