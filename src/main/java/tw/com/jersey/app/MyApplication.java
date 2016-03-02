package tw.com.jersey.app;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.MvcFeature;
import org.glassfish.jersey.server.mvc.beanvalidation.MvcBeanValidationFeature;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import tw.com.jersey.filter.BaseRequestFilter;
import tw.com.jersey.filter.BaseResponseFilter;

public class MyApplication extends ResourceConfig {
  public MyApplication() {

    // service build
    register(new MyApplicationBinder());

    // Resources
    packages("tw.com.view.resource");

    // Filter.
    register(BaseRequestFilter.class);
    register(BaseResponseFilter.class);

    // MVC.
    register(MvcFeature.class);
    // Bean Validation
    register(MvcBeanValidationFeature.class);
    // JSP
    register(JspMvcFeature.class);
    property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");
  }
}
