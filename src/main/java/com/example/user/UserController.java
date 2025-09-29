package com.example.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<UserItem> getAll() {
        return userService.getAll();
    }

    @GetMapping("/getById/{idParam}")
    public ResponseEntity<UserItem> getById(@PathVariable Integer idParam) {
        return userService.getById(idParam)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public UserItem create(@RequestBody UserItem userBody) {
        System.out.println("userBody " + userBody);

        return userService.create(userBody);
    }

    @PutMapping("/update/{idParam}")
    public ResponseEntity<UserItem> update(@PathVariable Integer idParam, @RequestBody UserItem newUserBody) {
        return userService.update(idParam, newUserBody)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{idParam}")
    public ResponseEntity<Void> delete(@PathVariable Integer idParam) {
        if (userService.delete(idParam)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
