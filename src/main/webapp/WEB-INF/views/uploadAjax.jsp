<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 ajax</title>
</head>
<body>
	<h1>파일 업로드 ajax</h1>
	<div class='uploadDiv'>
		<input type='file' name='uploadFile' onchange="readURL(this);" multiple>
	</div>
	<img id="img" width="150px" src="" alt="사진">
	<button id='uploadBtn'>Upload</button>
	
	<script src=" https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		function readURL(input) {
	        var reader = new FileReader();
	        reader.onload = function (e) {
	        	$('#img').attr('src', e.target.result);
	        }
	        reader.readAsDataURL(input.files[0]);
	    }
		$(document).ready(function(){
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880;
			
			function checkExtension(fileName, fileSize){
				if(fileSize >= maxSize){
					alert("파일 사이즈 초과");
					return false;
				}
				
				if(regex.test(fileName)){
					alert("해당 종류의 파일은 업로드할 수 없습니다.");
					return false;
				}
				return true;
			}
			
			// 첨부파일 초기화
			var cloneObj = $(".uploadDiv").clone();
			
			$("#uploadBtn").on("click",function(e){
				var formData = new FormData();
				var inputFile = $("input[name='uploadFile']");
				var files = inputFile[0].files;
				
				for(var i=0; i<files.length; i++){
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}
					
					formData.append("uploadFile", files[i]);
				}
				
				$.ajax({
					url: '/uploadAjaxAction',
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					dataType: 'json',
					success: function(result){
						console.log(result);
					}
				});
			});
		});
	</script>
</body>
</html>