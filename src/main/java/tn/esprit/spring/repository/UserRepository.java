package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.RoleUser;
import tn.esprit.spring.entity.User;

import java.util.List;

@Repository 

public interface UserRepository extends JpaRepository <User,Long> {
    User findByUsername(String username);
    User findUserByCin(long cin);
    List<User> findByRoleUser(RoleUser role);

}
 