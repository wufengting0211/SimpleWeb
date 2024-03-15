/**
 * 
 */
package com.socket;

import org.apache.logging.log4j.Logger;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.model.InfoObject;
import com.utils.LogUtil;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月6日
 */
public class ChatLauncher {
	private Logger log = LogUtil.getLogger("infolog");

	private static SocketIOServer ChatServer = null;
	
	public ChatLauncher(){
		Configuration config = new Configuration();
	    config.setHostname("localhost");
	    config.setPort(9092);
	    
	    
	    ChatServer = new SocketIOServer(config);
	    
	    ChatServer.addEventListener("chatevent", InfoObject.class, new DataListener<InfoObject>() {
            @Override
            public void onData(SocketIOClient client, InfoObject data, AckRequest ackRequest) {
                // broadcast messages to all clients
            	ChatServer.getBroadcastOperations().sendEvent("chatevent", data);
            	log.info(data.getUserName() + ":" + data.getMessage());
            }
        });
	}
	
	public void startServer(){
		try{
			ChatServer.start();
		}catch (Exception e) {
			log.info(e.getMessage());
		}
		
	}
	
	//同一实例关闭后不能再打开
	public void stopServer(){
		ChatServer.stop();
	}
	
	public void sendInfo(){
		InfoObject data = new InfoObject("server", "pay attention!");
		ChatServer.getBroadcastOperations().sendEvent("chatevent", data);
	}
}
