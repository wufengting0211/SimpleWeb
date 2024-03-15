/**
 * 
 */
package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Spider;
import com.service.MongoService;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年11月20日
 */
@Controller
public class PicController {
	
	@Autowired
	private MongoService mongoServiceImpl;
	
	@RequestMapping(value = "/picPage.do")
	public String showIndex(HttpServletRequest request, Model model){
		return "pic";
	}
	
	@RequestMapping(value = "/pic.do")
	public @ResponseBody Object showPic(HttpServletRequest request, Spider object){

		return mongoServiceImpl.search(object);
	}

	/**
	 * 
	 */
	public MongoService getMongoServiceImpl() {
		return mongoServiceImpl;
	}

}
