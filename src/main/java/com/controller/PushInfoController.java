/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socket.AckChatLauncher;
import com.socket.ChatLauncher;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月5日
 */
@Controller
public class PushInfoController {
	
	private final ChatLauncher chat = new ChatLauncher();
	
	private final AckChatLauncher ack = new AckChatLauncher();
	
	@RequestMapping(value = "/chatPage.do")
	public String showChat(){
		return "chatInfo";
	}
	
	@RequestMapping(value = "/ackChatPage.do")
	public String showAck(){
		return "ackChatInfo";
	}
	
	@RequestMapping(value = "/startChatServer.do")
	public @ResponseBody Object stopChatServer() throws JsonProcessingException{
		//chat.stopServer();
		chat.startServer();
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", "sucess");

		return mapper.writeValueAsString(map);
	}
	
	@RequestMapping(value = "/startackChatServer.do")
	public @ResponseBody Object stopackChatServer() throws JsonProcessingException{
		//chat.stopServer();
		ack.startServer();
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", "sucess");

		return mapper.writeValueAsString(map);
	}
}
