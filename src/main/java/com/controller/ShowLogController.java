/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ShowLogService;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月4日
 */
@Controller
public class ShowLogController {
	
	@Autowired
	private ShowLogService showLogService;
	
	@RequestMapping(value = "/logPage.do")
	public String showIndex(){

		return "showLog";
	}
	
	@RequestMapping(value = "/showLog.do")
	public @ResponseBody Map<String, Object> showLog(long preSize){
		Map<String, Object> map = new HashMap<>();
		map = showLogService.getLogInfo(preSize);
		return map;
	}
	
}
