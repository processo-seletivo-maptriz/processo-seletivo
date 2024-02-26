package com.backendagenda.AgendaApplication.repositories;

import com.backendagenda.AgendaApplication.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query(" SELECT obj FROM com.backendagenda.AgendaApplication.entities.User obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<User> searchByName(String name, Pageable pageable);
}
