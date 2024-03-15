/**
 * 
 */
package com.utils;

import java.util.Properties;

import org.apache.logging.log4j.Logger;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年9月15日
 */
public class Config {
	private Logger logger = LogUtil.getLogger("infolog");

	private String configFile = "config.properties";
	
	public void init() {
		loadConfig();
	}
	
	public void loadConfig() {
		logger.info("开始加载配置文件");

		Properties configConfig = new Properties();
		
		try {
			configConfig.load(Config.class.getClassLoader().getResourceAsStream(configFile));
			Constants.LOGFILE = configConfig.getProperty("logFile");
			logger.info(configFile + "加载完成");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(configFile + "加载失败");
		}
	}
}
