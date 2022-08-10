package org.example;
import org.example.model.UserDetails;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserOperations userOperations = new InMemoryUserOperations();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("*******MENU*******");
            System.out.println("1. Display Users");
            System.out.println("2. Add User");
            System.out.println("3. Delete User");
            System.out.println("4. Search User");
            System.out.println("5. Update User");
            System.out.println("6. Exit");
            System.out.print("Select your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    List<UserDetails> users = userOperations.getUsers();
                    for (UserDetails user : users) {
                        System.out.println("UserID:" + user.getId() + "\tUserName:" + user.getName() + "\tAddress:" + user.getAddress());
                    }
                    break;
                case 2:
                    System.out.print("Enter User ID:");
                    int id = sc.nextInt();
                    System.out.print("Enter User Name:");
                    String name = sc.next();
                    System.out.print("Enter User Address:");
                    String address = sc.next();
                    userOperations.addUser(new UserDetails(id, name, address));
                    break;
                case 3:
                    System.out.println("Enter user_ID to remove:");
                    int userid = sc.nextInt();
                    userOperations.deleteUser(userid);
                    break;
                case 4:
                    System.out.println("Enter User Name to search:");
                    String username = sc.next();
                    List<UserDetails> list = userOperations.searchUser(username);
                    for (UserDetails user : list) {
                        System.out.println("UserID:" + user.getId() + "\tUserName:" + user.getName() + "\tAddress:" + user.getAddress());
                    }
                    break;
                case 5:
                    System.out.println("Enter userID to be update:");
                    int uid = sc.nextInt();
                    System.out.println("Enter Username to be update:");
                    String uname = sc.next();
                    System.out.println("Enter User Address to be update:");
                    String uaddress = sc.next();
                    userOperations.updateUser(new UserDetails(uid, uname, uaddress));
                    break;
                case 6:
                    System.out.println("ThankYou!!");
                    System.exit(1);
                default:
                    System.out.println("Enter valid choice");
            }
        }
    }
}