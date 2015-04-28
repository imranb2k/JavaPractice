package com.ibapp.springmvc;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by imran on 11/04/15.
 */
public class StartApplication {

    private static final Logger logger= LoggerFactory.getLogger(StartApplication.class);

    public static void main(String[] args) throws Exception {

        String webAppDirLocation = "Function/ui/src/main";

        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {

            webPort = "8089";

        }

        tomcat.setPort(Integer.valueOf(webPort));

        tomcat.addWebapp("/springmvc", new File(webAppDirLocation).getAbsolutePath());

        logger.debug("Configuring app with basedir" + new File("./" + webAppDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();

    }

}
