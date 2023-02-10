package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.GroupModule;
import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupModuleRepository extends JpaRepository<GroupModule, Long> {
    Optional<GroupModule> findByName(String name);

    Boolean existsByName(String username);
}
