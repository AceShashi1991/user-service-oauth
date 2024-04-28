package com.scaler.userserviceoauth.security.service;

import com.scaler.userserviceoauth.model.User;
import com.scaler.userserviceoauth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import com.scaler.userserviceoauth.security.model.CustomUserDetails;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsManager {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return CustomUserDetails.builder()
                .id(user.get().getId())
                .username(user.get().getEmail())
                .password(user.get().getHashedPassword())
                .enable(user.get().isEnabled())
                .role(user.get().getRole()).build();
    }

    @Override
    public void createUser(UserDetails user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateUser(UserDetails user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteUser(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean userExists(String username) {

        return this.userRepository.findByEmail(username).isPresent();
    }
}
