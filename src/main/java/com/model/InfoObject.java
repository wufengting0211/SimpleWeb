/**
 * 
 */
package com.model;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月6日
 */
public class InfoObject {
	private String userName;
	private String message;
	
	public InfoObject(){
		
	}
	
	public InfoObject(String userName, String message){
		this.message = message;
		this.userName = userName;
	}
	
	/**
	 * 
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
