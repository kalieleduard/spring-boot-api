package kaliel.books.rest.api.controller;

import kaliel.books.rest.api.model.UserModel;
import kaliel.books.rest.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(path = "/api/user/{code}")
    public ResponseEntity search(@PathVariable("code") Integer code) {
        return repository.findById(code)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/user/save")
    public UserModel save(@RequestBody UserModel user) {
        return repository.save(user);
    }

}
