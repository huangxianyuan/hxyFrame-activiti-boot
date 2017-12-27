package com.hxy.component.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextWebListener implements ServletContextListener {
	
	private static final Logger logger = LoggerFactory.getLogger(ContextWebListener.class);

    @Override  
    public void contextDestroyed(ServletContextEvent arg0) {
        
    }  
  
    @Override  
    public void contextInitialized(ServletContextEvent sce) {
    	sce.getServletContext().setAttribute("lang", "zh");
    	
    	String webRoot = sce.getServletContext().getContextPath();
    	logger.info("加载 servlet...");
        sce.getServletContext().setAttribute("webRoot", webRoot);//Web根目录
        logger.info("Web根目录:"+sce.getServletContext().getAttribute("webRoot"));
        sce.getServletContext().setAttribute("resRoot", webRoot+"/statics");//资态资源根目录
        logger.info("资态资源根目录:"+sce.getServletContext().getAttribute("resRoot"));
    }  
  
    

}  