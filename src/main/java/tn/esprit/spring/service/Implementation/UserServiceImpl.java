package tn.esprit.spring.service.Implementation;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Classification;
import tn.esprit.spring.entity.RoleUser;
import tn.esprit.spring.entity.User;
//import tn.esprit.spring.exceptions.UsernameAlreadyExistsException;
import tn.esprit.spring.exceptions.CinAlreadyExisteException;
import tn.esprit.spring.exceptions.UsernameAlreadyExistsException;
import tn.esprit.spring.exceptions.UsernameAlreadyExistsResponse;
import tn.esprit.spring.repository.ContractRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.Interface.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	ContractRepository contractrepo ;
	
	


	@Override
	public User addAdmin(User user) {
		
		
		System.out.println("userrrrr"+userRepository.findByCin(user.getCin()));
		

		 if  (userRepository.findByUsername(user.getUsername())!= null){
			throw new UsernameAlreadyExistsException("Email '" + user.getUsername() + "'is already exists");
		}
		 if  (userRepository.findByCin(user.getCin())!= null){
			throw new UsernameAlreadyExistsException("Cin '" + user.getCin() + "'is already exists");
		}
		else {
			
			
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setRoleUser(RoleUser.Administrator);
			System.out.print("hello"+user);
			return userRepository.save(user);
		}
	}

	@Override
	public List<User> getAllUserRole(RoleUser role) {
		List<User> user=(List<User>)userRepository.findByRoleUser(role);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void verifyAccount(String token) {

	}

	@Override
	public User updateUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User findById(Long id) {
		return this.userRepository.findById(id).orElse(null);
	}

	@Override
	public String getUserId(User user) {
		return null;
	}

	@Override
	public String DeleteAccount(String id) {
		return null;
	}

	@Override
	public User UpdateUser(User user) {
		return userRepository.save(user);

	}




	@Override
	public User addUser(User user) {
		
		 if  (userRepository.findByUsername(user.getUsername())!= null){
			throw new UsernameAlreadyExistsException("Email '" + user.getUsername() + "'is already exists");
		}
		 
		 if  (userRepository.findByCin(user.getCin())!= null){
			throw new UsernameAlreadyExistsException("Cin '" + user.getCin() + "'is already exists");
		}

		else {
			
			
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
		}
		
	}

	@Override
	@Scheduled(fixedRate = 10000)


	public User getcode(String email) {
		User u=userRepository.getcode(email);
        return u;}

	@Scheduled(fixedRate = 1000)


	public void UserClassification() {
		List<User> ls = getAllUser();
		int i = 0;
		
		for (User user : ls) {
			i = contractrepo.findByUser(user).size();
			System.out.println("yy"+i);
			
			if (i<5 && user.getRoleUser().name().equals("LowinComeWomen")) {
				user.setClassification(Classification.Bronz);
				UpdateUser(user);
			}
			
			else if (i>5 && i<=10 && user.getRoleUser().name().equals("LowinComeWomen")) {
				user.setClassification(Classification.Silver);
				UpdateUser(user);
			}
			else if  (i>10 && user.getRoleUser().name().equals("LowinComeWomen")){
				user.setClassification(Classification.Gold);
				UpdateUser(user);
			}
			
			i=0;
		}

		
	}
	
	
	@Override
	public void changeUserPassword(User user, String password) {
	    user.setPassword(new BCryptPasswordEncoder().encode(password));
	    userRepository.save(user);
	}

}