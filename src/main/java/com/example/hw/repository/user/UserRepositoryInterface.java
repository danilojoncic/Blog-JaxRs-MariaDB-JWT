package com.example.hw.repository.user;


import com.example.hw.domain.User;
import com.example.hw.dto.UserDto;

import java.util.List;

public interface UserRepositoryInterface {
    public User findUser(String username);
    public UserDto findById(Integer id);

}
