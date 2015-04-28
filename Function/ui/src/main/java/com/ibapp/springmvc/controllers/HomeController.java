package com.ibapp.springmvc.controllers;


import com.ibapp.domain.Register;
import com.ibapp.service.RegisterService;
import com.ibapp.service.impl.RegisterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by imran on 10/04/15.
 */


@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("%rest.service.register.url")
    private String registerServiceUrl;

    public void setRegisterServiceUrl(String registerServiceUrl) {
        this.registerServiceUrl = registerServiceUrl;
    }

    @ModelAttribute
    public void commonObject(Model model) {

        model.addAttribute("msg", "Registration");

    }

  @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public ModelAndView getRegister () {

        logger.info("Welcome home to the register method!");

        ModelAndView model = new ModelAndView("register");

        return model;

    }

    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    public ModelAndView submitRegister (@ModelAttribute("register") Register register) throws Exception {


        logger.info("Welcome home to the add register method!");

        ModelAndView model = new ModelAndView("registrationComplete");


        return model;

    }

/*    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    public ModelAndView submitRegister (@RequestParam("userName") String userName, @RequestParam("password") String password) throws Exception {

        Register register = new Register();
        register.setUserName(userName);
        register.setPassword(password);

        logger.info("Welcome home to the add register method!");

        ModelAndView model = new ModelAndView("registrationComplete");

        registerService.insertRegister(register);

        return model;

    }*/


     /*
  @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm (Model model) {

        logger.info("Welcome home to the register form method!");

       model.addAttribute("register",register);

       return "register";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerSubmit (Model model) {

        logger.info("Welcome home to the register submit method!");

        model.addAttribute("register", register);

        return "register";

    }


    @RequestMapping(value = "/registrationComplete.jsp", method = RequestMethod.GET)
    public String registrationComplete (Register register, Model model) {

        logger.info("Welcome home to the registration complete method!");

        model.addAttribute("register", register);

        return "registrationComplete";
    }*/
}