package com.ibapp.service.rest;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

import static com.ibapp.service.rest.resources.Exceptions.uncheck;

public class TomcatApplicationServer {

    public static void main(String[] args) throws Exception {

        String webAppDirLocation = "Function/service/src/main/webapp";
        String webXmlLocation = webAppDirLocation + "/WEB-INF/web.xml";

        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {

            webPort = "8082";

        }

        tomcat.setPort(Integer.valueOf(webPort));

        // tomcat.addWebapp("/app", new File(webAppDirLocation).getAbsolutePath());

        String webAppAbsolutePath = new File(webAppDirLocation).getAbsolutePath();
        Context context = uncheck(() -> tomcat.addWebapp("/", webAppAbsolutePath));
        File configFile = new File(webXmlLocation);
        context.setConfigFile(uncheck(() -> configFile.toURI().toURL()));


        System.out.println("Configuring app with basedir" + new File("./" + webAppDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();

    }

}
