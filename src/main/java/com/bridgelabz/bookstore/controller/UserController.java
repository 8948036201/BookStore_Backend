package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.entity.User;
import com.bridgelabz.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookStore/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/addUserDetails")
    public ResponseEntity<ResponseDTO> addUserDetails(@RequestBody UserDTO userDTO) {
        UserDTO addData = userService.addUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added newUser Details", addData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    /**
     * Purpose : Ability to check user details from BookStore database While Login process
     */

    @PostMapping(value = "/getUserDetails")
    public ResponseEntity<ResponseDTO> getUserDetails(@RequestBody UserDTO userData) throws Exception {
        String email = userData.getEmail();
        String password = userData.getPassword();
        User contactList = null;
        if (email != null && password != null) {
            contactList = userService.getUserContact(email, password);
        }
        if(contactList == null) {
            throw new Exception("Error Occured");
        }
        ResponseDTO responseDTO = new ResponseDTO("Fetched user Details",contactList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }



    @PutMapping(value = "/updateUserDetails")
    public ResponseEntity<ResponseDTO> updateUserDetails(@RequestParam(name = "id") long id,
                                                         @RequestBody UserDTO userDTO) {
        UserDTO updatedUserData = userService.updateUser(id , userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated by ID : User Details", updatedUserData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteUserDetails")
    public ResponseEntity<ResponseDTO> deleteUserDetails(@RequestParam(name = "id") long id) {
        userService.deleteUser(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted by ID : User Details", null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
}
