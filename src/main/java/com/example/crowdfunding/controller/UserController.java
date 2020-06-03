package com.example.crowdfunding.controller;

import com.example.crowdfunding.domain.Role;
import com.example.crowdfunding.domain.User;
import com.example.crowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(@RequestParam String username, @RequestParam Map<String, String> form, @RequestParam("userId") User user, @RequestParam Long balance) {
       userService.saveUser(user, username, form, balance);
        return "redirect:/user";
    }
    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        User u1 = userService.findById(user.getId());
        model.addAttribute("username", u1.getUsername());
        model.addAttribute("balance", u1.getBalance());

        return "profile";
    }
    @PostMapping("profile")
    public String updateProfile(@AuthenticationPrincipal User user, @RequestParam String password, @RequestParam Long balance){
        userService.updateProfile(user, password, balance);
        return "redirect:/user/profile";
    }


}
