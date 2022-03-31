package tn.esprit.spring.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
@Autowired
private UserRepository userRep;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRep.findByUsername(username);
	if(user==null) new UsernameNotFoundException("User not found");
	return user;
	}
	
	
	@Transactional
public User loadUserById(Long id) {
		System.out.println("hello");
		User user = userRep.findById(id).orElse(null);
		if(user==null) new UsernameNotFoundException("User not found");
		return user;
	}
}
