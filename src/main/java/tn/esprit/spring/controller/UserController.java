 package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Validator.UserValidator;
import tn.esprit.spring.entity.RoleUser;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.payload.JWTLoginSucessResponse;
import tn.esprit.spring.payload.LoginRequest;
import tn.esprit.spring.security.JwtTokenProvider;
import tn.esprit.spring.security.SecurityConstants;
import tn.esprit.spring.service.Implementation.MapValidationErrorServiceImpl;
import tn.esprit.spring.service.Interface.UserService;

import javax.validation.Valid;
import java.util.List;


 @RestController
 @RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService ;
    @Autowired
    public JwtTokenProvider jwtTokenProvider;
    @Autowired
    public AuthenticationManager authenticationManager ;
    @Autowired
    public UserValidator userValidatore ;

    @Autowired
    public MapValidationErrorServiceImpl mapValidationErrorService ;


    @PostMapping("/login")

    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = SecurityConstants.TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);
        return  ResponseEntity.ok(new JWTLoginSucessResponse(true,jwt));
    }


     @PostMapping("/registerAdmin")
     public ResponseEntity<?> registerAdmin(@Valid @RequestBody User user , BindingResult result){

         userValidatore.validate(user,result);
         ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
         if(erroMap != null)return erroMap;
         user.setRoleUser(RoleUser.Administrator);
         User newUser = userService.addAdmin(user);
         return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
     }

     @GetMapping("/allUser")
     public List<User> AllUser(){

        return userService.getAllUser();
     }
     
     

     @PostMapping("/registre")
     public ResponseEntity<?> registe(@Valid @RequestBody User user , BindingResult result){

         userValidatore.validate(user,result);
         ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
         if(erroMap != null)return erroMap;
         User newUser = userService.addUser(user);
         return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
     }

}
