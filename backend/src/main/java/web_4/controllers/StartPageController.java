package web_4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import web_4.MyUser;
import web_4.UserRepository;

@RestController
public class StartPageController {

    @Autowired
    private UserRepository repository;
    @GetMapping("/")
    public ModelAndView startPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start_page");
        return modelAndView;
    }

    @PostMapping("/sign-up")
    public RedirectView signUp(@RequestBody MyUser user){
        repository.save(user);
        return new RedirectView("/task");
    }

    @PostMapping("/sign-in")
    public RedirectView signIn(@RequestBody MyUser user){
        MyUser userFromDb = repository.findByUsername(user.getUsername());
        if (userFromDb != null && userFromDb.getPassword().equals(user.getPassword()))
            return new RedirectView("/task");
        return new RedirectView("/");
    }
}
