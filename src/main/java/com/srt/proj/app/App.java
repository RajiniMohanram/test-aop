package com.srt.proj.app;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srt.proj.account.AccountService;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger LOG = Logger.getLogger("App");
	
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        AccountService service = ctx.getBean(AccountService.class);
        
        try {
        	service.transfer(1001, 1003, 230.23);
        }catch(Exception ex) {
        	
        }
        
    }
}
