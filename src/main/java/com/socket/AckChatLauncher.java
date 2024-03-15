/**
 * 
 */
package com.socket;

import org.apache.logging.log4j.Logger;

import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.VoidAckCallback;
import com.corundumstudio.socketio.listener.DataListener;
import com.model.InfoObject;
import com.utils.LogUtil;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月6日
 */
public class AckChatLauncher {

	private Logger log = LogUtil.getLogger("infolog");
	private static SocketIOServer ackServer = null;
	
	public AckChatLauncher(){
		Configuration config = new Configuration();
	    config.setHostname("localhost");
	    config.setPort(9093);
	    
	    ackServer = new SocketIOServer(config);
	    
	    ackServer.addEventListener("ackevent1", InfoObject.class, new DataListener<InfoObject>() {
            @Override
            public void onData(SocketIOClient client, InfoObject data, AckRequest ackRequest) {
                if(ackRequest.isAckRequested()){
                	ackRequest.sendAckData("client message was delivered to server!", "yeah!");
                }
                
                InfoObject ackData = new InfoObject(data.getUserName(), "message with ack data!");
                client.sendEvent("ackevent2", new AckCallback<String>(String.class) {
                    @Override
                    public void onSuccess(String result) {
                    	log.info("ack from client: " + client.getSessionId() + " data: " + result);
                    }
                }, ackData);
                
                InfoObject ackDataVoid = new InfoObject(data.getUserName(), "message with void ack!");
                client.sendEvent("ackevent3", new VoidAckCallback() {
                    @Override
					protected void onSuccess() {
						// TODO Auto-generated method stub
                    	log.info("void ack from client: " + client.getSessionId());
					}
                }, ackDataVoid);
            }
        });
	}
	
	public void startServer(){
		try{
			ackServer.start();
		}catch (Exception e) {
			log.info(e.getMessage());
		}
		
	}
	
	//同一实例关闭后不能再打开
	public void stopServer(){
		ackServer.stop();
	}
}
