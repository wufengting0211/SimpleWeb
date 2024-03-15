package com.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Name:LogUtil
 * Desc:返回指定名称日志
 * @author zhu
 * @date 2016年5月24日
 */
public class LogUtil {

    public static Logger getLogger(String name) {  
        if(StringUtils.isEmpty(name)) {
        	name = "default";
        }
        
        return LogManager.getLogger(name);
    }  
}
