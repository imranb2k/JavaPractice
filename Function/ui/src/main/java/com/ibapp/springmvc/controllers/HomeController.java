package com.ibapp.springmvc.controllers;

import com.ibapp.domain.Register;
import com.ibapp.service.RegisterService;
import com.ibapp.service.impl.RegisterServiceImpl;
import com.sun.javafx.sg.prism.NGShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by imran on 10/04/15.
 */

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private RestTemplate restTemplate = new RestTemplate();

    private String regsiterByIdUrl = "http://localhost:8082/register/1";
    private String allRegsiterUrl = "http://localhost:8082/register";

    @ModelAttribute
    public void commonObject(Model model) {

        model.addAttribute("msg", "Registration");

    }

   /* @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String getRegister (Model model) {

        logger.info("Welcome home to the register method!");

        ResponseEntity<Register> responseEntity = null;
        Register register = null;
        try {

            responseEntity = restTemplate.getForEntity(regsiterByIdUrl, Register.class);
            register = responseEntity.getBody();

        } catch (HttpClientErrorException e){
            if (e.getStatusCode() != HttpStatus.NOT_FOUND) {
                throw e;
            }

            if (register == null) {

                register = new Register();
            } else {

                register = responseEntity.getBody();
            }
        }*/

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String getRegister (Model model) {

        logger.info("Welcome home to the register method!");

        ResponseEntity<Register[]> responseEntity = null;
        Register[] register = null;

            responseEntity = restTemplate.getForEntity(allRegsiterUrl, Register[].class);
            register = responseEntity.getBody();

        model.addAttribute("register", register);

        return "homepage";

    }


    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    public String submitRegister (Model model, Register register) throws Exception {

        logger.info("Welcome home to the add register method!");

        restTemplate.postForObject("http://localhost:8082/register", register, Register.class);

        model.addAttribute("register", register);

        return "registrationComplete";

    }

    /*  @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String getRegister () {


        logger.info("Welcome home to the register method!");

        return "register";

    }*/

    // String regStr = restTemplate.getForObject("http://localhost:8082/register", String .class);

    // register = restTemplate.getForObject("http://localhost:8082/register/1", Register.class);


/*    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public ModelAndView getRegister () {

        logger.info("Welcome home to the register method!");

        ModelAndView model = new ModelAndView("register");


        return model;

    }*/

/*    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    public ModelAndView submitRegister (@ModelAttribute("register") Register register) throws Exception {


        logger.info("Welcome home to the add register method!");

        ModelAndView model = new ModelAndView("registrationComplete");


        return model;

    }*/

}