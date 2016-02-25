package tw.com.app;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import tw.com.service.CommonService;
import tw.com.service.ExpensesMainService;
import tw.com.service.ExpensesService;
import tw.com.service.MemberService;
import tw.com.service.Impl.CommonServiceImpl;
import tw.com.service.Impl.ExpensesMainServiceImpl;
import tw.com.service.Impl.ExpensesServiceImpl;
import tw.com.service.Impl.MemberServiceImpl;

/**
 * MyApplicationBinder
 * 
 * @author chrisryo
 *
 */
public class MyApplicationBinder extends AbstractBinder {

  /**
   * 一次只能一組, 找到好方法再改
   */
  @Override
  protected void configure() {
    // services
    bind(MemberServiceImpl.class).to(MemberService.class).in(Singleton.class);
    bind(ExpensesServiceImpl.class).to(ExpensesService.class).in(Singleton.class);
    bind(ExpensesMainServiceImpl.class).to(ExpensesMainService.class).in(Singleton.class);
    bind(CommonServiceImpl.class).to(CommonService.class).in(Singleton.class);
  }
}
