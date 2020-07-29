package com.wordpress.craftminemods.ringworld.handlers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingHandler {
	private static final Logger LOGGER = LogManager.getLogger("RingWorld");
	
	public static void Log(Level level, String strMessage) {
		if (level == Level.INFO) {
			LOGGER.info(strMessage);
		}
	}
	
	public static void Log(String str) {
		Log(Level.INFO, str);
	}

}
