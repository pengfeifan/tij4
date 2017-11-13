package com.github.tij4.chap12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingExceptions2 {

	private static Logger logger = Logger.getLogger("LoggingException2");

	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}

	public static void main(String[] args) {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			logException(e);
		}
	}
}
/**
 * Output:
八月 09, 2017 12:46:40 上午 com.github.tij4.chap12.LoggingExceptions2 logException
严重: java.lang.NullPointerException
	at com.github.tij4.chap12.LoggingExceptions2.main(LoggingExceptions2.java:19)
 */
