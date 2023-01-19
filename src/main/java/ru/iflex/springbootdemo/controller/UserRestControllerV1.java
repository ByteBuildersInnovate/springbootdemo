package ru.iflex.springbootdemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.iflex.springbootdemo.dto.UserDto;
import ru.iflex.springbootdemo.model.User;
import ru.iflex.springbootdemo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class UserRestControllerV1 {

    private UserService userService;
    @Autowired
    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody UserDto userDto){
        User user = userService.saveUser(userDto.getFirstName(), userDto.getLastName());
        if (user == null || user.getFirstName()==null || user.getLastName()==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @RequestMapping(value = "updateUser",method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User userDto){
        if (userDto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.userService.updateUser(userDto.getId(), userDto.getFirstName(), userDto.getLastName());
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }


    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUserById (@PathVariable("id") Long id){
        User user = this.userService.getUserById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "getAllUsers",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        if (users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}
