package net.app.usermanager.controller;

import net.app.usermanager.model.User;
import net.app.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private UserService userService;



    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String allUsers(Model model){
            model.addAttribute("user", new User());
            model.addAttribute("allUsers", this.userService.allUser());
            return "users";
    }

    @RequestMapping (value = "/users/{pageid}", method = RequestMethod.GET)
    public String listUsers(@PathVariable int pageid, Model model) {

        int total = 3;
        if(pageid!=1) {
            pageid = (pageid - 1) * total + 1;
        }
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.findUsersByPage(pageid, total));
        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId() == 0){
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }

        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);

        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUser", this.userService.allUser());

        return "edituser";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));

        return "userdata";
    }

    @RequestMapping (value = "users/create", method = RequestMethod.GET)
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("users");
        return modelAndView;
    }

}
