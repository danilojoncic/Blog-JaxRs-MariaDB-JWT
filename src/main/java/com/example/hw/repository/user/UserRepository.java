package com.example.hw.repository.user;

import com.example.hw.domain.User;
import com.example.hw.repository.MDBAbstractRepository;

public class UserRepository extends MDBAbstractRepository implements UserRepositoryInterface {
    @Override
    public User findUser(String username) {
        return null;
    }
}
