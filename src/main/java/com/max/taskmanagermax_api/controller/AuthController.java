package com.max.taskmanagermax_api.controller;

import com.max.taskmanagermax_api.DTO.SignInDTO;
import com.max.taskmanagermax_api.DTO.SignUpDTO;
import com.max.taskmanagermax_api.entity.Role;
import com.max.taskmanagermax_api.entity.User;
import com.max.taskmanagermax_api.repository.RoleRepository;
import com.max.taskmanagermax_api.repository.UserRepository;
import com.max.taskmanagermax_api.security.DTO.JwtAuthResponseDTO;
import com.max.taskmanagermax_api.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping ("/api/auth")
public class AuthController {
    
    private final AuthenticationManager authenticationManager;
    private final UserRepository        userRepo;
    private final RoleRepository  roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider      jwtTokenProvider;
    
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder passwordEncoder,
                          JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    
    @PostMapping ("/signIn")
    public ResponseEntity<JwtAuthResponseDTO> authenticateUser(@RequestBody SignInDTO signInDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInDTO.getUsernameOrEmail(), signInDTO.getPassword()));
        
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        
        String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthResponseDTO(token));
    }
    
    @PostMapping ("/signUp")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpDTO signUpDTO) {
        if (userRepo.existsByUsername(signUpDTO.getUsername())) {
            return new ResponseEntity<>("Ese nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        if (userRepo.existsByEmail(signUpDTO.getEmail())) {
            return new ResponseEntity<>("Ese email de usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        
        User user = new User();
        user.setEstado(1);
        user.setNombre(signUpDTO.getNombre());
        user.setApellido(signUpDTO.getApellido());
        user.setUsername(signUpDTO.getUsername());
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        
        
//        Set<Role> role = new HashSet<>();
//        role.add(roleService.getByRolName(RoleName.ROLE_USER).get());
//
//        if (user.getRole().contains("admin")) {
//            role.add(roleService.getByRolName(RoleName.ROLE_ADMIN).get());
//        }
//        user.setRole(role);
    
//        Role role = new Role();
//
//        if (role.equals("ROLE_ADMIN")) {role = roleRepo.findByName("ROLE_ADMIN").get();}
//        else if (role.equals("ROLE_USER"))
//            role = roleRepo.findByName("ROLE_USER").get();
//        user.setRole(Collections.singleton(role));
    
    
        /**
         * registrar a un usuario con "ROLE_USER" " sin crear nueva instancia.
         */
        for (Role role : roleRepo.findAll()) {
            if (role.getName().equals("ROLE_USER")) {
                user.setRole(Collections.singleton(role));
            } else if (role.getName().equals("ROLE_ADMIN")) {
                user.setRole(Collections.singleton(role));
            }
            userRepo.save(user);
        }
//        Role role = roleRepo.findByName("ROLE_USER").get();
//        user.setRole(Collections.singleton(role));
//
        /**
         * registrar a un usuario con "ROLE_ADMIN" " sin crear nueva instancia.
         */
//        Role role2 = roleRepo.findByName("ROLE_ADMIN").get();
//        user.setRole(Collections.singleton(role2));
        


//        Role role = roleRepo.findByName("ROLE_USER").get();
//        user.setRole(Collections.singleton(role));
        
        
        
//        Role role = roleRepo.findByName("ROLE_ADMIN").get();
//        Role role2 = roleRepo.findByName("ROLE_USER").get();
        //role = roleRepo.findByNameAdmin("ROLE_ADMIN").filter(r -> r.getName().equals("ROLE_ADMIN")).orElse(null);
                //.stream().map(r -> r.getName().equals("ROLE_ADMIN") ? roleRepo.findByNameAdmin("ROLE_ADMIN"): null);
                //.equals("ROLE_ADMIN") ? roleRepo.findByName("ROLE_ADMIN").get() : roleRepo.findByName("ROLE_USER").get();
        //role = roleRepo.findByNameUser("ROLE_USER").filter(r -> r.getName().equals("ROLE_USER")).orElse(null);
        //role = roleRepo.findByNameAdmin("ROLE_USER").filter(r -> r.getName().equals("ROLE_USER")).get();
//                .orElse(roleRepo.findByNameAdmin("ROLE_ADMIN").get());

//        if (role.equals("ROLE_ADMIN")) {
//            role = roleRepo.findByNameAdmin("ROLE_ADMIN").get();
//        } else if (role.equals("ROLE_USER")) {
//            role = roleRepo.findByNameUser("ROLE_USER").get();
//        }
    
//        Map<String, String> map = new HashMap<>();
//
//        map.put(String.valueOf(role.equals("ROLE_ADMIN") ? roleRepo.findByName("ROLE_ADMIN").get() :
//                roleRepo.findByName("ROLE_USER".compareTo(role2)).get()), "ROLE_ADMIN");
        
//        user.setRole(Collections.singleton(role).stream()
//                .filter(r -> r.getName().equals("ROLE_ADMIN")).collect(Collectors.toSet()).stream()
//                .filter(r -> r.getName().equals("ROLE_USER")).collect(Collectors.toSet()));
        
        //user.setRole(role.equals("ROLE_ADMIN") ? roleRepo.findByNameAdmin("ROLE_ADMIN").get() : roleRepo.findByNameUser("ROLE_USER").get());
        
//        user.setRole(Collections.singleton(role));
        
        //userRepo.save(user);
        
        return new ResponseEntity<>("Usuario registrado existosamente", HttpStatus.CREATED);
        
    }
}
