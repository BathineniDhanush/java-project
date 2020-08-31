package com.java.Project.controller;
import com.java.Project.UserEntity;
import com.java.Project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
@Autowired
    private UserService userService;
@RequestMapping(value={"/","/login"},method = RequestMethod.GET)
    public ModelAndView login() {
    ModelAndView model = new ModelAndView();
    model.setViewName("user/login");
    return model;
}
@RequestMapping(value = {"/signup"},method = RequestMethod.GET)
public ModelAndView signup(){
    ModelAndView model=new ModelAndView();
    UserEntity user=new UserEntity();
    model.addObject("username",user);
    model.setViewName("user/signup");
    return model;
}
@RequestMapping(value = {"/signup"},method = RequestMethod.POST)
    public ModelAndView createUser(@Validated UserEntity userEntity, BindingResult bindingResult){
    ModelAndView model =new ModelAndView();
    UserEntity userExists=userService.findUserbyEmail(userEntity.getEmail());
    if(userExists!=null){
        bindingResult.rejectValue("email","error.username","This email already exists!!");
    }
    if(bindingResult.hasErrors()){
        model.setViewName("user/signup");
    }
    return model;
}

@RequestMapping(value = {"/home/home"},method = RequestMethod.GET)
    public  ModelAndView home(){
    ModelAndView model=new ModelAndView();
    Authentication auth= SecurityContextHolder.getContext().getAuthentication();
    UserEntity userEntity=userService.findUserbyEmail(auth.getName());
    model.addObject("username",userEntity.getUsername());
    model.setViewName("home/home");
    return model;
}
@RequestMapping(value = {"/access_denied"},method = RequestMethod.GET)
    public ModelAndView accessDenied(){
        ModelAndView model=new ModelAndView();
        model.setViewName("errors/access_denied");
    return model;
}
}
