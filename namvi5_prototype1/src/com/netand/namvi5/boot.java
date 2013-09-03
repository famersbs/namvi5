package com.netand.namvi5;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Application Lifecycle Listener implementation class boot
 *
 */
public class boot implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public boot() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	N5Modules modules = N5Modules.getInstance();
    	//modules.add("/Users/famersbs/git/namvi5/namvi5_prototype1/namvi5/modules/");
    	modules.add("D:/ProjectSource/GIT_REPO/namvi5/namvi5_prototype1/namvi5/modules");
    	modules.load();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	
    }
	
}
