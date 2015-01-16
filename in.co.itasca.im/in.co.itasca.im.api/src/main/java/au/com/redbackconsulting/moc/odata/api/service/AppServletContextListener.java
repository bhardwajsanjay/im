



package au.com.redbackconsulting.moc.odata.api.service;

import in.co.itasca.im.persistence.manager.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
public class AppServletContextListener implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger(AppServletContextListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContext) {
        try {
             .getInstance().initEntityManagerProvider();
            //initBenefits();
        } finally {
            PersistenceManager.getInstance().closeAll();
        }
    }
}
