package com.srt.proj.account;

import java.util.logging.Logger;

public class AccountService {

	private static final Logger LOG = Logger.getLogger("AccountService");

	public boolean transfer(int fromAcc, int toAcc, double amount) throws Exception {
		boolean result1 = validateAccount(fromAcc);
		boolean result2 = validateAccount(toAcc);

		if (result1 && result2) {
			LOG.info("Debited " + amount + " from " + fromAcc);
			LOG.info("Credited " + amount + " to " + toAcc);
			return true;
		}else {
			return false;
		}

	}

	public boolean validateAccount(int accNo) throws Exception {
		if (accNo >= 1000 && accNo <= 2000) {
			return true;
		} else {
			throw new Exception("Invalid Account Number: " + accNo);
		}
	}
}
