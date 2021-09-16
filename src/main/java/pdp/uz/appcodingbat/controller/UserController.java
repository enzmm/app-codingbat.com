package pdp.uz.appcodingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Category;
import pdp.uz.appcodingbat.entity.User;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public HttpEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    //Delete
    @DeleteMapping(value = "/api/user/{userId}")
    public HttpEntity<Result> deleteUser(@PathVariable Integer userId) {
        Result result = userService.deleteUser(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public HttpEntity<Result> addUser(@RequestBody User user){
        Result result = userService.addUser(user);
        return ResponseEntity.ok(result);
    }

    //Update
    @PutMapping (value = "/api/user/{userId}")
    public HttpEntity<Result> editUser(@PathVariable Integer userId, @RequestBody User user) {
        Result result = userService.editUser(userId,user);
        return ResponseEntity.ok(result);
    }


}
