package com.waltoncrm.authenticationproject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.waltoncrm.authenticationproject.Model.User;
import com.waltoncrm.authenticationproject.Service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/"; 
        }

        return "auth/login";
    }
    @GetMapping("/")
    public String home() {
        return "auth/home";
    }

    @PostMapping("/req/login")
    public String save(String name, String password, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        Optional<User> user =  loginService.findByNameAndPassword(name, password);
       
        if (user.isPresent()) {
            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

            Authentication authentication = new UsernamePasswordAuthenticationToken(user.get(), null, authorities);

            // Set authentication in context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
           
            HttpSession session = request.getSession(true);
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

            redirectAttributes.addFlashAttribute("message", "Login successful!");
            // return "redirect:/req/user/show/" + user.get().getId();
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid name or password");
            return "redirect:/req/user/error/" + "User not Created";// or wherever your login page is
        }
    }


}
