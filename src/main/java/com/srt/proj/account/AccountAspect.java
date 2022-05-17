package com.srt.proj.account;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AccountAspect {

	private static final Logger LOG = Logger.getLogger("AccountAspect");

	@Pointcut("execution(* com.srt.proj.account.AccountService.transfer(..))")
	private void transferPoint() {
	}

	// Before annotation with argument
	public void beforeFindContact() {
		
	}
	@AfterReturning(pointcut = "transferPoint() && args(from,to,..)", returning = "result")
	public void updatePassbook(int from, int to, Object result) {
		Boolean res = (Boolean) result;
		if (res) {
			LOG.info("Logic to update " + from + " passbook");
			LOG.info("Logic to update " + to + " passbook");
		}else {
			LOG.warning("Transaction failed");
		}
		
		
	}
	
	@AfterThrowing(pointcut = "transferPoint()", throwing = "e")
	public void validateAccountAfterTransfer(Exception e) {
		LOG.warning(e.toString());
	}
	
}
