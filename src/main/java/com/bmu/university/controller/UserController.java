package com.bmu.university.controller;

import com.bmu.university.dto.UserDto;
import com.bmu.university.manager.UserManager;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<UserDto> userDto = userManager.getAll();
        model.addAttribute("users", userDto);
        return "users-index";

    }

    @GetMapping("/user/new")
    public String createUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "user-new";

    }

    @PostMapping("/users")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto,
                           BindingResult bindingResult,
                            Model model
                           ) {
        if (bindingResult.hasErrors()){
            model.addAttribute("user",userDto);
            return "user-new";

        }
        userManager.createUser(userDto);
        return "redirect:/users";

    }

    @GetMapping("/users/{userId}/edit")
    public String editUser(@PathVariable("userId") Long userId,
                           Model model){
        UserDto userDto = userManager.getUserId(userId);
        model.addAttribute("user",userDto);
        return "edit_user";

    }
    @PostMapping("/users/{userId}")
    public String updateUser(@PathVariable("userId") Long id , @ModelAttribute("user") UserDto userDto,Model model,
                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute("user",userDto);
            return "edit_user";
        }
        userDto.setId(id);
        userManager.updateUser(userDto);

        return "redirect:/users";
    }
    @GetMapping("/users/{userId}/delete")
    public String deleteUser(@PathVariable("userId") Long id,Model model){
        userManager.deleteById(id);
        return "redirect:/users";

    }
    @GetMapping("/users/{userId}/view")
    public String viewUser(@PathVariable("userId") Long id,Model model){
        UserDto userDto = userManager.getUserId(id);
        model.addAttribute("user",userDto);
        return "view-user";

    }
    @GetMapping("/user/home")
    public String userHome(Model model){
        List<UserDto> userDto = userManager.getAll();
        model.addAttribute("user",userDto);
        return "redirect:/users";
    }


}
