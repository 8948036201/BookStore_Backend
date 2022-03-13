package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.entity.User;

import java.util.List;

public interface IUserService {
    UserDTO addUser(UserDTO userDTO);

    List<UserDTO> getUserDetails();

    UserDTO updateUser(long id, UserDTO userDTO);

    void deleteUser(long id);

    User getUserContact(String email, String password);
}
