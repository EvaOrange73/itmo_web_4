package web_4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import web_4.security.MyUser;
import web_4.security.UserRepository;

@Controller
public class StartPageController {

    @Autowired
    private UserRepository repository;
    @GetMapping("/sign-in")
    public ModelAndView startPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start_page");
        return modelAndView;
    }

    @PostMapping("/sign-up")
    public RedirectView signUp(@RequestBody MyUser user){
        if (repository.findByUsername(user.getUsername()) == null) {
            user.setPassword(
                    new BCryptPasswordEncoder().encode(
                            user.getPassword()
                    )
            );
            repository.save(user);
            return new RedirectView("/sign-in?success");

        }
        return new RedirectView("/sign-in?fail");
    }
}
