package org.mql.java.fp.method_referecence;

public class DataManager {
	private Logger logger;
	public DataManager(Logger log) {
		logger = log;
		System.out.println(logger.getClass().getName());
	}
	
	void print(String msg) {
		logger.log(msg);
	}
}
