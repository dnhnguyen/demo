package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.RolesUserModule;
import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public interface RolesUserModuleRepository extends JpaRepository<RolesUserModule, Long> {

    List<RolesUserModule> findAllByUser(User user);
}
