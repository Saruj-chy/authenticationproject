package com.waltoncrm.authenticationproject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.waltoncrm.authenticationproject.Model.User;
import com.waltoncrm.authenticationproject.Service.UserService;





@Controller
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/req/user/index")
    public String index(Model model ) {
        List<User> userList = userService.readUsersAll();
        System.out.println(userList);
        model.addAttribute("userList", userList);
        return "user/index";
    }

    @GetMapping("/req/user/create")
    public String getUserCreate() {
        return "user/create";
    }

    @GetMapping("/req/user/show")
    public String getMethodName(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "User saved successfully!");
        return "redirect:/req/user/show/3";
    }

     @GetMapping("/req/user/show/{id}")
    public String showUser(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<User> userData = userService.readUsersByIdl(id);
        // System.out.println("\n-----------------------------------------------------\n");
        // System.out.println(userData.isPresent());
        if (userData.isPresent()) {
            model.addAttribute("user", userData.get());
            return "user/show";
        } else {
            
            // step 1
            // return "redirect:/req/user/error/"+"User Not Found";

            // step 2
            model.addAttribute("error", "User not found");
            return "error/user_error";
        }
    }



    @PostMapping("/req/user/save")
    public String save(User user, String email, RedirectAttributes redirectAttributes) {
        System.out.println(email);
        System.out.println(user);
        Long id = userService.CreateUser(user);
        Optional<User> userData =  userService.readUsersByIdl(id);
        if(userData != null){
            redirectAttributes.addFlashAttribute("message", "User saved successfully!");
            return "redirect:/req/user/show/" + id; 
        }else{
            return "redirect:/req/user/error/" + "User not Created";
        }
    }

    @GetMapping("/req/user/edit/{id}")
    public String editUser(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<User> userData = userService.readUsersByIdl(id);
        if (userData.isPresent()) {
            model.addAttribute("user", userData.get());
            return "user/edit";
        } else {
            model.addAttribute("error", "User not found");
            return "error/user_error";
        }
    }

    @PostMapping("/req/user/updateUser")
    public String updateUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        User updateUser = userService.updateUser(user);
        if(updateUser != null ){
            redirectAttributes.addFlashAttribute("message", "User updated successfully!");
            return "redirect:/req/user/show/" + user.getId();
        }else{
            return "redirect:/req/user/error/" + "User not Updated";
            
        }
        
    }
   


    @GetMapping("/req/user/error/{msg}")
    public String getError(@PathVariable String msg, Model model) {
        model.addAttribute("error", msg);
        return "error/user_error";
    }
    

    
    
}
