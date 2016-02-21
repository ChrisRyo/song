package tw.com.app;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.beanvalidation.MvcBeanValidationFeature;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import tw.com.logic.filter.MyFilter;
 
public class MyApplication extends ResourceConfig{
    public MyApplication(){
    	
    	// service build
    	register(new MyApplicationBinder());
    	
    	// Resources
    	packages("tw.com.view.resource");
    	packages("tw.com.webservice");
    	
    	// Logging.
        register(LoggingFilter.class);
    	
    	// Filter
    	register(MyFilter.class);
    	
    	// MVC.
    	// Bean Validation
        register(MvcBeanValidationFeature.class);
        // JSP
        register(JspMvcFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");
    }
}