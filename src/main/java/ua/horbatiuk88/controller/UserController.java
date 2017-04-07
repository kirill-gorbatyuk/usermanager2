package ua.horbatiuk88.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.horbatiuk88.entity.User;
import ua.horbatiuk88.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/", "/users"}, method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("users", this.userService.getAll());
        return "users";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String add(@RequestBody User user) {
        Long userId = this.userService.update(user);

        return String.valueOf(userId);
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.userService.delete(id);

        return "redirect:/users";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userService.getById(id));
        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user) {
        this.userService.update(user);

        return "redirect:/users";
    }

}
