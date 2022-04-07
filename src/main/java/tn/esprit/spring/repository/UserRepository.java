package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.RoleUser;
import tn.esprit.spring.entity.User;

import java.util.List;

@Repository 

public interface UserRepository extends JpaRepository <User,Long> {
    User findByUsername(String username);
    User findByCin(long cin);
    List<User> findByRoleUser(RoleUser role);
	@Query("SELECT u FROM User u WHERE u.email= ?1")
	User getcode(String email);
	

}
 