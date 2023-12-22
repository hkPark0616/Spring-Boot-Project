package com.project.portfolio.service;


import com.project.portfolio.domain.entity.UserEntity;
import com.project.portfolio.domain.repository.UserRepository;
import com.project.portfolio.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    // 회원가입 성공 시 유저 정보 저장
    @Transactional
    public String saveUser(UserDto userDto) {
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        userRepository.save(userDto.toEntity());
//        return userDto.getId();

        String pwd = userDto.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPwd = encoder.encode(pwd);
        userDto.setPassword(encodedPwd);

        return userRepository.save(userDto.toEntity()).getId();
    }

    // 아이디 중복확인
    @Transactional
    public boolean isExistId(UserDto userDto) {
        return !userRepository.findUserEntityById(userDto.toEntity().getId()).isEmpty();
    }

    // 이름 중복 확인
    @Transactional
    public boolean isExistName(UserDto userDto) {
        return !userRepository.findUserEntityByName(userDto.toEntity().getName()).isEmpty();
    }


    @Transactional
    public Map<String, String> validateLogin(UserDto userDto) {
        Map<String, String> resultMap = new HashMap<>();

        Optional<UserEntity> userOptional = userRepository.findById(userDto.getId());

        if (userOptional.isEmpty()) {
            resultMap.put("success", "false");
        } else {
            UserEntity user = userOptional.get();
            if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
                resultMap.put("success", "true");
            } else {
                resultMap.put("success", "false");
            }
        }

        return resultMap;
    }
}
