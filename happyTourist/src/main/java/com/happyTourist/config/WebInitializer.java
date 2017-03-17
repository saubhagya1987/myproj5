package com.happyTourist.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

  static Logger logger = Logger.getLogger(WebInitializer.class.getName());

  @Override
  public void onStartup(ServletContext container) throws ServletException {
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(SpringRootConfig.class);
    //for Async Task
    rootContext.register(AppConfig.class);
   // rootContext.refresh();
    
    container.addListener(new ContextLoaderListener(rootContext));
    AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();    
    
    dispatcherServlet.register(SpringWebConfig.class);   
    
    ServletRegistration.Dynamic dispatcher =
        container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/*");
    
    
    
    
    
  }
}
