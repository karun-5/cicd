package com.example.springsec.Services;

import com.example.springsec.Records.RegisterRequest;
import com.example.springsec.Repository.UserRepo;
import com.example.springsec.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepo repo;


    private final PasswordEncoder encoder;

    public UserService(UserRepo repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public AppUser register(RegisterRequest request) {
        if (repo.existsByUsername(request.username())) {
            throw new IllegalArgumentException("Username already exists");
        }
        AppUser user = new AppUser();
        user.setUsername(request.username());
        user.setPassword(encoder.encode(request.password()));
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        return repo.save(user);
    }
}
