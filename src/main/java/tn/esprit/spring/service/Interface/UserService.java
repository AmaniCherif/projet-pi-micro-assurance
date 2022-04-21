package tn.esprit.spring.service.Interface;

import java.util.List;


import tn.esprit.spring.entity.RoleUser;
import tn.esprit.spring.entity.User;





public interface UserService {
    public User addAdmin(User user);
    public List<User> getAllUserRole(RoleUser role);

    public List<User> getAllUser();

    public void verifyAccount(String token);


    User updateUser(User u);
    public User findById(Long id) ;

    public String getUserId(User user);

    public String DeleteAccount(String id) ;

    public User UpdateUser(User user);

    public void changeUserPassword(User user, String password);


//    public List<User> findByFirstNameLikeOrLastNameLikeOrEmailLike(String keyword);


    public User addUser(User user);

    User getcode(String email);

    
    public void UserClassification();

		
	}
