package org.example;


import org.example.model.UserDetails;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserOperationsTest {

    @Test
    public void addUser() {
        UserOperations operations = new InMemoryUserOperations();
        operations.addUser(new UserDetails(1,"jaya","hyd"));
        assertEquals(1, ((InMemoryUserOperations) operations).userList().size());
        UserOperations operations2 = new InMemoryUserOperations();
        assertEquals(0, operations2.getUsers().size());
    }
    @Test
    public void deleteUser() {
        UserOperations operations = new InMemoryUserOperations();
        operations.addUser(new UserDetails(1,"jaya","hyd"));
        operations.addUser(new UserDetails(2,"jaya","hyd"));
        operations.deleteUser(1);
        assertEquals(1, ((InMemoryUserOperations) operations).userList().size());
    }
    @Test
    public void searchUser() {
        UserOperations operations = new InMemoryUserOperations();
        operations.addUser(new UserDetails(1,"jaya","hyd"));
        System.out.println(operations.searchUser("jaya"));
    }
    @Test
    public void display() {
        UserOperations operations = new InMemoryUserOperations();
        operations.addUser(new UserDetails(1,"jaya","hyd"));
        System.out.println(operations.getUsers());
        operations.addUser(new UserDetails(2,"jaya","hyd"));
        System.out.println(operations.getUsers());
        operations.deleteUser(1);
        System.out.println(operations.getUsers());
    }
    @Test
    public void updateUser() {
        UserOperations operations = new InMemoryUserOperations();
        operations.addUser(new UserDetails(1,"jaya","hyd"));
        operations.updateUser(new UserDetails(1,"anu","khm"));
        System.out.println(operations.getUsers());
    }
}