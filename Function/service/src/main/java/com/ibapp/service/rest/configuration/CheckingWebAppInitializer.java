/*
package com.ibapp.service.rest.configuration;

import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


*/
/**
 * Created by imran on 23/04/15.
 *//*

public class CheckingWebAppInitializer implements WebApplicationInitializer{

    private static final String REST_API_PREFIX = "/rest";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        rootContext.register(RestConfiguration.class);

        registerServlets(servletContext, rootContext);
        registerListeners(servletContext,rootContext);
        registerParams(servletContext);

    }

    private void registerServlets(ServletContext servletContext, AnnotationConfigWebApplicationContext rootContext) {

        ServletRegistration.Dynamic restEasyDispatcher = servletContext.addServlet("RestEasyHttpServletDispatcher", new HttpServletDispatcher());

        restEasyDispatcher.setLoadOnStartup(1);
        restEasyDispatcher.addMapping(REST_API_PREFIX + "*/
/*");

    }

    private void registerListeners(ServletContext servletContext, AnnotationConfigWebApplicationContext rootContext) {

        servletContext.addListener(new ResteasyBootstrap());
        servletContext.addListener(new RestEasyAnnotatedContextLoader(rootContext));

    }

    private void registerParams(ServletContext servletContext) {
        servletContext.setInitParameter("resteasy.media.type.mappings",
                "json : application/json, xml : application/xml");
        servletContext.setInitParameter("resteasy.servlet.mapping.prefix",
                REST_API_PREFIX);
    }

}
*/
