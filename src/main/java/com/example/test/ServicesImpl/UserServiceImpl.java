package com.example.test.ServicesImpl;

import com.example.test.Entities.Role;
import com.example.test.Entities.User;
import com.example.test.Repositories.RoleRepository;
import com.example.test.Repositories.UserRepository;
import com.example.test.Services.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public User findByName(String name) {
        return userRepository.findByUsername(name).get();
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public boolean save(User user){
        User tempUser = userRepository.findByUsername(user.getUsername()).get();
        if(tempUser!=null){
            return false;
        }
        userRepository.save(user);
        return true;
    }
    @Override
    public boolean delete(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public User findById(Long id){
        return userRepository.findById(id).get();
    }
    @Override
    public List<User> findAll(){
        return userRepository.findAll().stream().toList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).get();

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
//    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges){
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for(String privilege : privileges){
//            authorities.add(new SimpleGrantedAuthority(privilege));
//        }
//        return authorities;
//    }
//
//    private Collection<? extends GrantedAuthority> getAuthorities(
//            Collection<Role> roles
//    ){
//
//    }
}
