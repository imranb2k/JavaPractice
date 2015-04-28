package com.ibapp.springmvc.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by imran on 10/04/15.
 */
public class CheckingWebAppInitialiser implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationConfiguration.class);

        registerServrlets(servletContext, rootContext);

    }

    private void registerServrlets(ServletContext servletContext, AnnotationConfigWebApplicationContext rootContext) {

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher" , new DispatcherServlet(rootContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/dispatcher/*");

    }

}
