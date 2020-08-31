package com.java.Project.Service;
import com.java.Project.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface UserService {
    public UserEntity findUserbyEmail(String email);
    public void saveUser(UserEntity userEntity);


}
