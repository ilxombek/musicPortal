package com.uzs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

@Configuration
public class WebConfig implements WebApplicationInitializer {
        public void onStartup(ServletContext servletContext) throws ServletException {
            AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
            dispatcherServletContext.register(WebConfig.class);
            DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherServletContext);
            ServletRegistration.Dynamic dispatcher = servletContext.addServlet("fileUpload", dispatcherServlet);
            MultipartConfigElement multipartConfig = new MultipartConfigElement("/files");
            dispatcher.setMultipartConfig(multipartConfig);
            dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("*.html");
            FilterRegistration.Dynamic multipartFilter = servletContext.addFilter("multipartFilter", MultipartFilter.class);
            multipartFilter.addMappingForUrlPatterns(null, true, "/*");
        }
    }
