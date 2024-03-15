<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<style>
.quarterli > li{
	float: left;
	width: 20%;
	height: 20%;
	margin: 0 -1px -1px 0;
	border: 1px solid transparent;
	overflow: hidden;
}
.quarterli > li > img {
	width: 100%;
	cursor: -webkit-zoom-in;
	cursor: zoom-in;
}
</style>
<script type="text/javascript">
	var pageUrl = "pic.do";
	var showInfo = function() {
		$.ajax({
			type : "post",
			url : pageUrl,
			dataType : "json",
			timeout : 30000,
			data : {},
			success : function(data) {
				$("#viewers").empty();
				var htmlStr = "";
				for(var i = 0; i < data.length; i++){
					htmlStr += "<li><img src='http://local.static" + data[i].fileUrl + "'></li>";
				}
				$("#viewers").append(htmlStr);
				startShow();
			}
		});
	};

	var startShow = function() {
		var options = {
				"navbar":false,
				"movable":false,
				"title":false
		};
		$("#viewers").viewer(options);
		//$('#myModal').modal("show");
	};
	$(function() {
		showInfo();
	});
</script>
<div id="pad-wrapper" class="form-page">
	<form>
		<div class="field-box">
			<div class="col-md-12">
				<div style="max-height:600px;overflow-y:scroll;">
					<ul id="viewers" class="images quarterli">
					</ul>
				</div>
			</div>
		</div>
	</form>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</div>