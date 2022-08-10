package org.example;

import org.example.model.UserDetails;

import java.util.List;

public interface UserOperations {
     void addUser(UserDetails userDetails);
     void deleteUser(int id);
     List<UserDetails> searchUser(String name);
     List<UserDetails> getUsers();
     void updateUser(UserDetails userDetails);
}
