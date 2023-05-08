package Controller;

import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/listar")
    public ResponseEntity<List<UserModel>> findAll (){
        List<UserModel> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/salvar")
    public ResponseEntity<UserModel> insert(@RequestBody UserModel obj){
        obj = repository.save(obj);
        return ResponseEntity.ok().body(obj);
    }

}
