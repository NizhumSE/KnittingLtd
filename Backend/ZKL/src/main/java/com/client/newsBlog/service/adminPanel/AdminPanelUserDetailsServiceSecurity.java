package com.client.newsBlog.service.adminPanel;

import com.client.newsBlog.model.User;
import com.client.newsBlog.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminPanelUserDetailsServiceSecurity implements UserDetailsService {

    private final UserRepository userRepository;

    public AdminPanelUserDetailsServiceSecurity(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Searching user..." + email);
        User user = userRepository.findByEmail(email);

        if(user == null){
            System.out.println("No user Found");
            throw new UsernameNotFoundException("No user found with this email : " + email);
        }
        System.out.println(user.getEmail());
        user.setOnlineStatus(true);
        userRepository.save(user);
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .roles(user.getRoleName())
                        .accountLocked(!(user.isAccessStatus()))
                        .build();
        System.out.println("login Hoisa");
        return userDetails;
    }
}
