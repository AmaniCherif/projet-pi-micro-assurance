package tn.esprit.spring.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.Interface.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRep;

	@Override
	public List<User> retrieveAllUsers() {
		List<User> users=(List<User>) (userRep.findAll());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User u) {
		userRep.save(u);
		// TODO Auto-generated method stub
		return (u);
	}

	@Override
	public void deleteUser(int id) {
		userRep.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User u , int id ) {
		User userModif = userRep.findById(id).get(); 
		userModif.setAddress(u.getAddress());
		userModif.setBirthdate(u.getBirthdate());
		userModif.setCin(u.getCin());
		userModif.setConfirmPassword(u.getConfirmPassword());
		userModif.setDepartement(u.getDepartement());
		userModif.setEmail(u.getEmail());
		userModif.setFirstname(u.getFirstname());
		userModif.setJob(u.getJob());
		userModif.setLastname(u.getLastname());
		userModif.setPhoneNumber(u.getPhoneNumber());
		userModif.setPassword(u.getPassword());
		userModif.setPostalCode(u.getPostalCode());
		userModif.setSex(u.getSex());
		userRep.save(userModif); 
		
		return userModif;
	}

	@Override
	public User retrieveUser(int id) {
		// TODO Auto-generated method stub
		return userRep.findById(id).get();
	}

}
