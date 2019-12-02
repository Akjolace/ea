package edu.mum.cs544.bank.logging;

import org.springframework.stereotype.Component;

@Component
public class Logger implements ILogger{

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("AKALogger").info(logstring);
	}

}
