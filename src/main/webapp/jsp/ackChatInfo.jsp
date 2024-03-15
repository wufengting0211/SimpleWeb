<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<script src="<%=request.getContextPath()%>/public/js/socket.io.js"></script>

<script type="text/javascript">
	var userName = "user" + Math.floor((Math.random()*1000)+1);
	
	var showInfo = function(name, info){
		var content = $("#" + name);
		content.append(info);
		if(content.length){
			content.scrollTop(content[0].scrollHeight - content.height());
		}
	}
	
	var ackSocket;
	/* utils.postAjax("startackChatServer.do",null,function(){
		ackSocket = io.connect("http://localhost:9093");
		ackSocket.on('connect', function() {
			showInfo("ackContent","===>Client has connected to the server<===\n");
		});
		ackSocket.on('message', function(data, ackServerCallback) {
			showInfo("ackContent",data.userName + ":" + data.message + "\n");
			if (ackServerCallback) {
		        // send ack data to server
		    	ackServerCallback('server message was delivered to client!');
		    }
		});
		ackSocket.on('disconnect', function() {
			ackSocket.disconnect();
			showInfo("ackContent","===>The client has disconnected!<===\n");
		});
		
		ackSocket.on('ackevent2', function(data, ackServerCallback, arg1) {
			showInfo("ackContent",data.userName + ":" + data.message + "\n");
			if (ackServerCallback) {
		        // send ack data to server
		    	ackServerCallback('server message was delivered to client!');
		    }
		});
		ackSocket.on('ackevent3', function(data, ackServerCallback) {
			showInfo("ackContent",data.userName + ":" + data.message + "\n");
			if (ackServerCallback) {
		        // send ack data to server
		    	ackServerCallback();
		    }
		});
	}); */
		
	var sendAck = function(){
		var jsonObject = {	
							"@class": "com.model.InfoObject",
			                "userName": userName,
			                "message": "ackchatLauncher"
			             };
		ackSocket.emit('ackevent1', jsonObject, function(arg1, arg2) {
			showInfo("ackContent", "ack from server! arg1: " + arg1 + ", arg2: " + arg2 + "\n");
		});
	}

</script>
<div id="pad-wrapper" class="form-page">
	<form>
		<div class="field-box">
             <div class="col-md-6">
                 <textarea class="form-control" style="resize:none;background-color:#fffdfd;"  rows="10" id="ackContent" readonly></textarea>
             </div>
         </div>
         <div class="field-box">
			<div class="col-md-3">
				<a class="btn-glow primary" onclick="sendAck()" id="sendAck">send</a>
			</div>
		</div>
	</form>
</div>