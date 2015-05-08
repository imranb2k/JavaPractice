package com.ibapp.springmvc.controllers;

import com.ibapp.domain.Product;
import com.ibapp.domain.Products;
import com.ibapp.domain.ProductsImpl;
import com.ibapp.domain.Register;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by imran on 10/04/15.
 */

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private RestTemplate restTemplate = new RestTemplate();

    private String allRegsiterUrl = "http://localhost:8082/register";

    @ModelAttribute
    public void commonObject(Model model) {

        model.addAttribute("msg", "Registration");

    }

    @RequestMapping(value = "/registerForm2", method = RequestMethod.GET)
    public ModelAndView getRegister () {

        logger.info("Welcome home to the register method!");

        ModelAndView model = new ModelAndView("register");

        return model;

    }

    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    public String submitRegister (@ModelAttribute("register") Register register) throws Exception {

        logger.info("Welcome home to the add register method!");

        restTemplate.postForEntity(allRegsiterUrl, register, Register[].class);

        return "registrationComplete";

    }

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String getRegister (Model model) {

        Product iaProduct = new Product();
        iaProduct.setState(true);
        iaProduct.setSectionA(true);
        iaProduct.setSectionB(false);

        Product section94product = new Product();
        iaProduct.setState(false);
        section94product.setSectionA(true);
        section94product.setSectionB(true);


        logger.info("Welcome home to the registered users method!");

        ResponseEntity<Register[]> responseEntity = null;
        Register[] register = null;

        responseEntity = restTemplate.getForEntity(allRegsiterUrl, Register[].class);
        register = responseEntity.getBody();

        model.addAttribute("register", register);
        model.addAttribute("ia", iaProduct);
        model.addAttribute("section94", section94product);

        return "homepage";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login () {

        logger.info("Welcome home to the login method!");

        ModelAndView model = new ModelAndView("login");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginValidate (@ModelAttribute("register") Register register) throws Exception {

        logger.info("Welcome home to the login validate method!");

        Register[] register1 = null;

        ResponseEntity<Register[]> responseEntity = null;

        responseEntity = restTemplate.getForEntity(allRegsiterUrl, Register[].class);
        register1 = responseEntity.getBody();

        for (int i=0; i < register1.length; i++)  {

            if (register.getUserName().equals(register1[i].getUserName()) && register.getPassword().equals(register1[i].getPassword())) {
                return "logedin";
                }
            }
        return "loginError";
    }

    /*    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    public String submitRegister (Model model, Register register) throws Exception {

        logger.info("Welcome home to the add register method!");

        restTemplate.postForObject("http://localhost:8082/register", register, Register.class);

        model.addAttribute("register", register);

        return "registrationComplete";

    }*/

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

    /*  @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String getRegister () {


        logger.info("Welcome home to the register method!");

        return "register";

    }*/

    // String regStr = restTemplate.getForObject("http://localhost:8082/register", String .class);

    // register = restTemplate.getForObject("http://localhost:8082/register/1", Register.class);


}