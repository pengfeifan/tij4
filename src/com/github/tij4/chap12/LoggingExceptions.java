package com.github.tij4.chap12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception {
	private static Logger logger = Logger.getLogger("LoggingException");

	public LoggingException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

public class LoggingExceptions {

	public static void main(String[] args) {
		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}

		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
	}
}
/**Output:
八月 09, 2017 12:40:19 上午 com.github.tij4.chap12.LoggingException <init>
严重: com.github.tij4.chap12.LoggingException
	at com.github.tij4.chap12.LoggingExceptions.main(LoggingExceptions.java:21)

Caught com.github.tij4.chap12.LoggingException
八月 09, 2017 12:40:19 上午 com.github.tij4.chap12.LoggingException <init>
严重: com.github.tij4.chap12.LoggingException
	at com.github.tij4.chap12.LoggingExceptions.main(LoggingExceptions.java:27)

Caught com.github.tij4.chap12.LoggingException
 */
