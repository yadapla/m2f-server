package com.basis.cadastro.controller;

import com.basis.cadastro.model.User;
import com.basis.cadastro.model.UserGender;
import com.basis.cadastro.model.WeightStats;
import com.basis.cadastro.service.UserService;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Component
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    public UserService userService;

        @GetMapping("/send-email-recover-pass/{email}")
    public boolean sendEmailRecoverPass(@PathVariable String email) {
        return true;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping("/alterar-senha")
    public boolean alterarSenha(@RequestBody AlterarSenha data) {
        User dbUser = userService.findByEmailAndPassword(
                data.getEmail(), data.getSenhaAtual());
        if (dbUser == null) {
            return false;
        }

        dbUser.setPassword(data.getNovaSenha());
        userService.save(dbUser);
        return true;
    }

    @Getter
    private static class AlterarSenha {
        String email;
        String senhaAtual;
        String novaSenha;
    }

    @PutMapping("/update")
    public User update(@RequestBody User incomeUser)
            throws Exception {

        User dbUser = userService.findById(incomeUser.getId());
        if (dbUser == null) {
            throw new Exception("Usuário não encontrado.");
        }

        System.out.println(">> INCOME USER >>");
        System.out.println(incomeUser);
        User savedUser = userService.save(incomeUser);
        return savedUser;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) throws Exception {

        User u = userService.findByEmail(user.getEmail());
        if (user.getId() != null || u != null) {
            throw new Exception("Usuário já existe.");
        }

        user.setIsActive("1");
        user.setAccessCount(1);
        user.setGender("N");
        user.setLastVisitDate(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User newUser = userService.save(user);
        return newUser;
    }

    @PostMapping("/authenticate")
    public User authenticate(@RequestBody User user) {
        User dbUser = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (dbUser == null) {
            return null;
        }

        dbUser.setAccessCount(dbUser.getAccessCount() + 1);
        return userService.save(dbUser);
    }
}
