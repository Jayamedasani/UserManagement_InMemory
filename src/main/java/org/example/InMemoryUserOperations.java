package org.example;
import org.example.model.UserDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class InMemoryUserOperations implements UserOperations {
    private List<UserDetails> userList = new ArrayList<>();
    public List<UserDetails> userList() {
        return userList;
    }
    @Override
    public void addUser(UserDetails newUserDetails) {
        UserDetails existingUser = getUserDetails(newUserDetails.getId());
        if (existingUser != null) {
            System.out.println("User with given ID is already available enter new ID");
            return;
        } else {
            userList.add(newUserDetails);
            System.out.println("User Added to list!");
        }
    }
    @Override
    public void deleteUser(int id) {
        if (userList.isEmpty()) {
            System.out.println("Users List is empty can't delete from list");
        } else {
            UserDetails existingUser = getUserDetails(id);
            if (existingUser == null) {
                System.out.println("User with given ID is not available can't delete");
            } else {
                userList.remove(existingUser);
                System.out.println("User removed from list!");
            }
        }
    }
    @Override
    public List<UserDetails> searchUser(String userName) {
        List<UserDetails> searchList=new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        for (UserDetails user : userList) {
            nameList.add(user.getName());
        }
        if (nameList.contains(userName)) {
            for (UserDetails user : userList()) {
                if (user.getName() .equals(userName) ){
                    searchList.add(user);
                }
            }
            return searchList;
        } else {
            System.out.println("User with given name is Not available");
        }
        return searchList;
    }
    @Override
    public  List<UserDetails> getUsers() {
        if (userList.isEmpty()) {
            System.out.println("No Users are available");
        }
        return userList;
    }
    @Override
    public  void updateUser(UserDetails userDetails) {
        UserDetails existingUser = getUserDetails(userDetails.getId());
        if (existingUser == null) {
            System.out.println("User with given details is not available can't Update");
        } else {
            existingUser.setName(userDetails.getName());
            existingUser.setAddress(userDetails.getAddress());
            System.out.println("User Details are updated!");
        }
    }

    private UserDetails getUserDetails(int id) {
        for (UserDetails user :userList) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }
}
