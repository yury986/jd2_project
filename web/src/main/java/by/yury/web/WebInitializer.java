package by.yury.web;

import by.yury.data.DataConfiguration;
import by.yury.security.WebSecurityConfig;
import by.yury.service.ServiceConfiguration;
import jakarta.servlet.*;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Set;

public class WebInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) {
        // Init Spring context
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);
        context.register(ServiceConfiguration.class);
        context.register(DataConfiguration.class);
        context.register(WebSecurityConfig.class);

        // Init servlet for Spring MVC
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // Register servlet in Tomcat context
        final ServletRegistration.Dynamic servletRegistration =
                ctx.addServlet("dispatcherServlet", dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");

        long maxSize = 16L * 1024 * 1024;
        servletRegistration.setMultipartConfig(
                new MultipartConfigElement(null, maxSize, maxSize, 0));
    }
}