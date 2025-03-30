package app;

import models.User;
import repository.UserRepository;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        int searchId = 2;
        Optional<User> userById = userRepository.findUserById(searchId);
        userById.ifPresentOrElse(
                user -> System.out.println("Found user by ID: " + user),
                () -> System.out.println("User with ID " + searchId + " not found.")
        );

        String searchEmail = "charlie@example.com";
        Optional<User> userByEmail = userRepository.findUserByEmail(searchEmail);
        userByEmail.ifPresentOrElse(
                user -> System.out.println("Found user by Email: " + user),
                () -> System.out.println("User with email " + searchEmail + " not found.")
        );

        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> System.out.println("Total users found: " + users.size()),
                () -> System.out.println("No users found.")
        );
    }
}
