package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.repository.UserRepository;
import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User addDetails = modelMapper.map(userDTO, User.class);
        userRepository.save(addDetails);
        return userDTO;
    }

    @Override
    public List<UserDTO> getUserDetails() {
        return userRepository.findAll().stream().map(user -> {
            return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getKyc(), user.getDob(),
                                 user.getRegisteredDate(), user.getPurchaseDate(), user.getUpdatedDate(), user.getExpiryDate(),
                                        user.getEmail(),user.getPassword(), user.getVerify(), user.getOtp());
        }).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) {
        UserDTO userResponse = null;
        if (id > 0) {
            User userDetails = findBookById(id);
            String[] ignoreFields = {"id"};
            BeanUtils.copyProperties(userDTO, userDetails, ignoreFields);
            userRepository.save(userDetails);
            userResponse = modelMapper.map(userDetails, UserDTO.class);
        }
        return userResponse;
    }

    public User findBookById(long id) {
        return userRepository.findById((int) id)
                .orElseThrow(() -> new BookStoreException("Unable to find any Person contact detail!"));
    }


    @Override
    public void deleteUser(long id) {
        if (id > 0) {
            User contact = findBookById(id);
            userRepository.delete(contact);
        }
    }

    @Override
    public User getUserContact(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
