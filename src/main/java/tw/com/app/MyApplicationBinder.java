package tw.com.app;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import tw.com.service.ExpensesService;
import tw.com.service.MemberService;
import tw.com.service.Impl.ExpensesServiceImpl;
import tw.com.service.Impl.MemberServiceImpl;

/**
 * MyApplicationBinder
 * 
 * @author chrisryo
 *
 */
public class MyApplicationBinder extends AbstractBinder {
	
    @Override
    protected void configure() {
    	// services
        bind(MemberServiceImpl.class).to(MemberService.class).in(Singleton.class);;
        bind(ExpensesServiceImpl.class).to(ExpensesService.class).in(Singleton.class);;
  
        // dao
    }
}
