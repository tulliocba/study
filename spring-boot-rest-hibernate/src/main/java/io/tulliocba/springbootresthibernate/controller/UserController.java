package io.tulliocba.springbootresthibernate.controller;

import io.tulliocba.springbootresthibernate.model.User;
import io.tulliocba.springbootresthibernate.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.isPresent() ? ResponseEntity.of(userOptional) : ResponseEntity.noContent().build();
    }


    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));

    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @Valid @RequestBody User userDetails) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(!optionalUser.isPresent()) return ResponseEntity.noContent().build();

        User user = optionalUser.get();

        BeanUtils.copyProperties(userDetails, user, "id");

        return ResponseEntity.ok(userRepository.save(user));
    }

    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }


}
