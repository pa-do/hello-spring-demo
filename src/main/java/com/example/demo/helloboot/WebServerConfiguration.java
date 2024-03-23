package com.example.demo.helloboot;

import com.example.demo.config.autoconfig.ServerProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {

    @Bean ServletWebServerFactory customerWebServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

        serverFactory.setContextPath(properties.getContextPath());
        serverFactory.setPort(properties.getPort());
        return serverFactory;
    }

    @Bean
    public ServerProperties serverProperties(Environment env) {
        ServerProperties properties = new ServerProperties();

        properties.setContextPath(env.getProperty("contextPath"));
        properties.setPort(Integer.parseInt(env.getProperty("port")));

        return properties;
    }
}
