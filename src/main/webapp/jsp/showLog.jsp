<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<script type="text/javascript">
	var pageUrl = "showLog.do";
	var preSize = 0;
	var timerHomeHq;
	var showInfo = function(){
		$.ajax({
			type:"post",
			url:pageUrl,
			dataType:"json",
			timeout: 30000,
			data:{"preSize":preSize},
	    	success:function(data){
	    		if(preSize < data.newSize){
	    			preSize = data.newSize;
	    			$("#infoContent").append(data.result);
		    		if($("#infoContent").length){
		    			$("#infoContent").scrollTop($("#infoContent")[0].scrollHeight - $("#infoContent").height());
		    		}
	    		}
	    	},
	    	error:function(XMLHttpRequest, textStatus, errorThrown){
	    		
	    	}
	    });
	};
	
	var startShow = function(){
		showInfo();
		timerHomeHq = window.setInterval(showInfo, 5000);
		$("#start").attr("disabled","true");
		$("#stop").removeAttr("disabled");
	};
	
	var stopShow = function(){
		window.clearInterval(timerHomeHq);
		$("#start").removeAttr("disabled");
		$("#stop").attr("disabled","true");
	};
	
</script>
<div id="pad-wrapper" class="form-page">
	<form>
		<div class="field-box">
			<div class="col-md-5">
				<a class="btn-glow primary" onclick="startShow()" id="start">输出日志</a>
			</div>
			<div class="col-md-5">
				<a class="btn-glow primary" onclick="stopShow()" id="stop" disabled="true">停止输出</a>
			</div>
		</div>
		<div class="field-box">
             <div class="col-md-12">
                 <textarea class="form-control" style="resize:none;background-color:#fffdfd;"  rows="28" id="infoContent" readonly></textarea>
             </div>
         </div>
	</form>
</div>