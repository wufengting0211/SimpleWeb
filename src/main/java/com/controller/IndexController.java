/**
 * 
 */
package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月4日
 */
@Controller
public class IndexController {
	
	@RequestMapping(value = "/index.do")
	public String showIndex(HttpServletRequest request, Model model){

		return "index";
	}
}
