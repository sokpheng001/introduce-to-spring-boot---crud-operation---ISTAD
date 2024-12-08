package com.example.demo.api.v1.user.repository;

import com.example.demo.api.v1.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    public List<User> userList = new ArrayList<>(List.of(
            new User(1, UUID.randomUUID().toString(),"koko","koko123@gmail.com","21#@$%","google.com","I like music",false,true),
            new User(2,UUID.randomUUID().toString(),"kaka","kaka23@gmail.com","34#@$%","facebook.com","I like music",false,true)
    ));
}
