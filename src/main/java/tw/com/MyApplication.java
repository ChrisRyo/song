package tw.com;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import tw.com.logic.filter.MyFilter;
 
public class MyApplication extends ResourceConfig{
    public MyApplication(){
    	packages("tw.com.view.resource");
    	packages("tw.com.webservice");
    	// Filter
    	register(MyFilter.class);
    	// jsp
        register(JspMvcFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");
    }
}