package xyz.aymen.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.aymen.example.model.NewUser;
import xyz.aymen.example.model.User;
import xyz.aymen.example.model.UserDTO;
import xyz.aymen.example.repository.UserRepository;
import xyz.aymen.example.util.Mapper;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    public UserDTO addNewUser(NewUser newUser) {
        log.info("insert new user {}", newUser);
        User user = Mapper.newUserToModel(newUser);
        User userWithId = repository.insert(user);
        UserDTO dto = Mapper.modelToDTO(userWithId);
        log.info("userId {}", userWithId.getId());
        return dto;
    }

    public void deleteUserById(Long userId) {
        log.info("delete user by id {}", userId);
        repository.deleteById(userId);
    }

    public List<UserDTO> getAllUsers() {
        log.info("find all users");
        List<User> users = repository.findAll();
        List<UserDTO> dtoList = Mapper.modelToDTO(users);
        log.info("N. of users:  {}", dtoList.size());
        return dtoList;
    }

    public UserDTO findUserById(Long id) {
        log.info("find user by id: {}", id);
        Optional<User> user = repository.findById(id);
        UserDTO dto = null;
        if (user.isPresent()) {
            dto = Mapper.modelToDTO(user.get());
            log.info("retrived user {}", user);
        } else{
            log.info("the user with id {} could not be found", id);
        }
        return dto;
    }
}
