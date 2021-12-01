package com.example_security.demoTwo.dao;

import com.example_security.demoTwo.model.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserDAO {

    private List<User> userList;

    {
        if(userList == null){
            userList = Arrays.asList(
                    new User(1,"John","USA"),
                    new User(2,"Jimm","Canada")
            );
        }
    }

    public List<User> getUserList(){
        return userList;
    }

    public User getUserById(int userId) {
        return userList.stream()
                .filter(user -> user.getId()==userId)
                .findAny()
                .orElseThrow(()-> new IllegalStateException("User with " + userId + " not exists"));
    }

    public void deleteUserById(int userId){

    }
}
