package xyz.aymen.example.util;

import org.springframework.beans.BeanUtils;
import xyz.aymen.example.model.NewUser;
import xyz.aymen.example.model.User;
import xyz.aymen.example.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private Mapper() {
    }

    public static User newUserToModel(NewUser newUser) {
        User model = new User();
        BeanUtils.copyProperties(newUser, model);
        return model;
    }

    public static UserDTO modelToDTO(User user) {
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public static List<UserDTO> modelToDTO(List<User> users) {
        List<UserDTO> dtoList = new ArrayList<>();
        users.forEach(user -> {
            UserDTO dto = new UserDTO();
            BeanUtils.copyProperties(user, dto);
            dtoList.add(dto);
        });
        return dtoList;
    }

}
