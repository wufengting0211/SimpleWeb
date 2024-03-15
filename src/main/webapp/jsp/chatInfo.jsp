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
	
	var chatSocket;
	
	/* utils.postAjax("startChatServer.do",null,function(){
		
		chatSocket = io.connect("http://localhost:9092");
		chatSocket.on("connect", function() {
			showInfo("chatContent","===>Client has connected to the server<===\n");
		});
		chatSocket.on("chatevent", function(data) {
			showInfo("chatContent",data.userName + ":" + data.message + "\n");
		});
		chatSocket.on("disconnect", function() {
			chatSocket.disconnect();
			showInfo("chatContent","===>The client has disconnected!<===\n");
		});
	}); */
	
	var sendChat = function(){
		var jsonObject = {
							"@class": "com.model.InfoObject",
							"userName":userName,
                			"message": "chatLauncher"
                		 };
		chatSocket.emit("chatevent", jsonObject);
	}
</script>
<div id="pad-wrapper" class="form-page">
	<form>
		<div class="field-box">
             <div class="col-md-6">
                 <textarea class="form-control" style="resize:none;background-color:#fffdfd;"  rows="10" id="chatContent" readonly></textarea>
             </div>
         </div>
         <div class="field-box">
			<div class="col-md-3">
				<a class="btn-glow primary" onclick="sendChat()" id="sendChat">send</a>
			</div>
		</div>
	</form>
</div>