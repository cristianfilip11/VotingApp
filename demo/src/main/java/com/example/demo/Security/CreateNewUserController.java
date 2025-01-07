package com.example.demo.Security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class CreateNewUserController {

    private final PasswordEncoder passwordEncoder;

    private final CustomUserRepository customUserRepository;

    public CreateNewUserController(PasswordEncoder passwordEncoder, CustomUserRepository customUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.customUserRepository = customUserRepository;
    }


    @PostMapping("/createnewuser")
    public ResponseEntity<String> createNewUser(@RequestParam("username") String username,
                                                @RequestParam("password") String password) {
       /* // Validate required fields
        if (!userData.containsKey("username") || !userData.containsKey("password")) {
            return ResponseEntity.badRequest().body("Missing required fields: username and/or password");
        }*/
        //System.out.println(userData);
        //String username = userData.get("username").toString();
        //String password = userData.get("password").toString();

        // Check if user already exists
        Optional<CustomUser> optionalUser = customUserRepository.findById(username);
        if (optionalUser.isPresent()) {
            return ResponseEntity.badRequest().body("User with the provided username already exists");
        }

        // Create and save the user
        CustomUser user = new CustomUser(username, passwordEncoder.encode(password));
        customUserRepository.save(user);

        return ResponseEntity.ok("User created successfully");
    }


   /* @PostMapping("/createnewuser")
    public ResponseEntity<String> createNewUser(@RequestBody CustomUser user){
        //this should go in a service class

        //need better error handling with custom exceptions

        Optional<CustomUser> optionalUser = customUserRepository.findById(user.getUsername());
        if(!optionalUser.isPresent()){
            customUserRepository.save(new CustomUser(user.getUsername(), passwordEncoder.encode(user.getPassword())));
            return ResponseEntity.ok("User created successfully");
        }
        return ResponseEntity.badRequest().body("User was not created");
    }

    */


}
