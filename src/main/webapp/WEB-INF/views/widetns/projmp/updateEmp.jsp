<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>사원정보 수정</title>
  <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
  <link rel="icon" href="/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
  <style>
    body {
      font-size: 16px;
    }

    .container {
      width: 1000px;
      padding: 0px;
      margin: 0px 0px 0px 20px;
    }

    .row {
      margin: 0px;
    }

    #title {
      margin: 20px 0px 20px 0px;
      font-weight: bold;
    }

    .col-sm-2,
    .col-sm-6,
    .col-sm-12 {
      padding: 0px;
    }

    img {
      margin-bottom: 10px;
    }

    table td {
      height: 40px;
    }

    .prj,
    .tech {
      width: 100%;
    }

    .prj th,
    .prj td,
    .tech th,
    .tech td,
    .addTech th,
    .addTech td {
      border: 1px solid black;
      text-align: center;
      height: 20px;
    }

    .btnArea {
      margin-top: 10px;
      text-align: right;
    }
    
    #addr1{
      margin-right:10px;
    }
  </style>
</head>

<body>
  <div class="container">
    <div class="row">
      <h1 id="title">사원정보 수정</h1>
      <form role='form' action="/updateEmp" method="POST" enctype="multipart/form-data">
 	      <div class="col-sm-3">
	      	<div class="col-sm-12">
		      <img id="empImg" width="150px" src="/resources/img/${empDetail.file_name }">
		      <input type="hidden" name="file_name" value="${empDetail.file_name }">
		    </div>
   	      	<div class="col-sm-12">
		      <label class="btn btn-primary btn-file btn-sm">
			    파일추가 <input type="file" id="img" name="file" accept="image/*" onchange="readURL(this);" style="display:none;"/>
			  </label>	      	  
	      	</div>
	      </div>
	      <div class="col-sm-9">
	        <table>
	          <tbody>
	            <tr>
	              <td class="col-sm-2">사원번호</td>
	              <td class="col-sm-6"><input type="text" name="emp_num" value='<c:out value="${empDetail.emp_num }"/>' readonly></td>
	              <td class="col-sm-2">직책</td>
	              <td class="col-sm-2">
	                <select name="pos" id="position">
	                  <option value="${empDetail.pos }"><c:out value="${empDetail.pos }"/></option>
	                  <option value="사원">사원</option>
	                  <option value="대리">대리</option>
	                  <option value="팀장">팀장</option>
	                </select>
	              </td>
	            </tr>
	            <tr>
	              <td>한글이름</td>
	              <td><input type="text" name="emp_num" value='<c:out value="${empDetail.kor_name }"/>' readonly></td>
	              <td>부서</td>
	              <td>
	              <select name="dept" id="dept">
	              	<option value="${empDetail.dept }"><c:out value="${empDetail.dept }"/></option>
	              	<option value="개발부">개발부</option>
	              	<option value="관리부">관리부</option>
	              </select>
	              </td>
	            </tr>
	            <tr>
	              <td>영문이름</td>
	              <td><input type="text" name="emp_num" value='<c:out value="${empDetail.eng_name }"/>' readonly></td>
	              <td>경력</td>
	              <td><input type="number" name="career" id="career" value='<c:out value="${empDetail.career }"/>' max="50" min="1" required>&nbsp;년</td>
	            </tr>
	            <tr>
	              <td>우편번호</td>
	              <td><input type="text" name="addr1" id="addr1" value='<c:out value="${empDetail.addr1 }"/>' required readonly><button class="btn btn-sm btn-primary">검색</button></td>
	              <td>등급</td>
	              <td>
	                <select name="emp_level" id="level">
	                  <option value="${empDetail.emp_level}"><c:out value="${empDetail.emp_level }"/></option>
	                  <option value="초급">초급</option>
	                  <option value="중급">중급</option>
	                  <option value="고급">고급</option>
	                </select>
	              </td>
	            </tr>
	            <tr>
	              <td>도로명주소</td>
	              <td><input type="text" name="addr2" id="addr2" value='<c:out value="${empDetail.addr2 }"/>' required readonly></td>
	              <td>입사일</td>
	              <td><input type="text" name="join_date" value='<fmt:formatDate value="${empDetail.join_date }" pattern="yyyy-MM-dd"/>' readonly></td>
	            </tr>
	            <tr>
	              <td>상세주소</td>
	              <td><input type="text" name="addr3" id="addr3" value='<c:out value="${empDetail.addr3 }"/>' required></td>
	              <td>자격증</td>
	              <td><input type="text" name="cert" id="cert" value='<c:out value="${empDetail.cert }"/>'></td>
	            </tr>
	          </tbody>
	        </table><br>
	        <h4>사용가능기술</h4>
	        <table class="tech">
	          <thead>
	            <tr>
	              <th></th>
	              <th>기술명</th>
	              <th>등급</th>
	            </tr>
	          </thead>
	          <tbody id="tbl_body">
				<c:forEach items="${empTech}" var="empTech">
		          <tr>
		            <td><input type="checkbox" class="selBtn" name="chkBtn"></td>
		            <td class="techList"><c:out value="${empTech.tech_code }"/></td>
		            <td><c:out value="${empTech.tech_level }"/></td>
		          </tr>
		        </c:forEach>
	          </tbody>
	        </table>
	        <br>
	        <table class="addTech">
	          <thead>
	            <tr>
	              <th>기술명</th>
	              <th>등급</th>
	            </tr>
	          </thead>
	          <tbody class="tbl_body2">
	          </tbody>
	        </table>
	        <div class="btnArea">
	          <button type="button" class="btn btn-sm btn-primary" id="addBtn">추가</button>
	          <button type="button" class="btn btn-sm btn-danger" id="delBtn">삭제</button>
	        </div>
	        <h4>참여 프로젝트</h4>
	        <table class="prj">
	          <thead>
	            <tr>
	              <th>프로젝트번호</th>
	              <th>프로젝트명</th>
	              <th>PM</th>
	              <th>담당자</th>
	              <th>기간</th>
	            </tr>
	          </thead>
	          <tbody>
	            <c:forEach items="${empPrj }" var="empPrj">
	              <tr>
	                <td><c:out value="${empPrj.prj_num }"/></td>
	                <td><c:out value="${empPrj.prj_name }"/></td>
	                <td><c:out value="${empPrj.pm_name }"/></td>
	                <td><c:out value="${empPrj.manager }"/></td>
	                <td><fmt:formatDate value="${empPrj.prj_start }" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${empPrj.prj_end }" pattern="yyyy-MM-dd"/></td>
	              </tr>
	            </c:forEach>
	          </tbody>
	        </table>
	        <div class="btnArea">
	          <button class="btn btn-primary" id="regBtn">수정</button>
	          <button class="btn btn-danger" id="cancelBtn">취소</button>
	        </div>
	      </div>
	    </form> 
    </div>
  </div>
  <script src=" https://code.jquery.com/jquery-1.12.4.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {

	  $('.techList').first().closest('tr').remove();
	  
	  
      $("#regBtn").on("click",function(e){
    	  location.href="/"; 
      });
      
      $("#cancelBtn").on("click",function(){
    	 location.href="/"; 
      });
    	
      // 사용 가능 기술 목록
      /* DB에 접근해서 목록 가져오기... */
      var allTechList = new Array();
      <c:forEach items="${allTech}" var="allTech">
	      allTechList.push("${allTech.code_name}")
      </c:forEach>
	
      // 사용 가능 기술 목록에서 이미 저장되어 있는 기술 삭제
      var rows = $("#tbl_body tr").length;
      for (var i = 1; i <= rows; i++) {
        var useTech = $("tr:nth-child(" + i + ") .techList").text().trim();
        if (allTechList.indexOf(useTech) > -1)
          allTechList.splice(allTechList.indexOf(useTech), 1);
      }

      // 삭제한 기술을 제외하고 selectbox에 표시되도록 작성
      var opt = "";
      opt = '<option value="">---</option>';
      for (var i = 0; i < allTechList.length; i++) {
        opt = opt + '<option value="' + allTechList[i] + '">' + allTechList[i] + '</option>';
      }

      $(".tbl_body2").html(
        '<tr>\
              <td class="techList1">\
                <select name="tech" id="tech">'
        + opt +
        ' </select>\
              </td>\
              <td class="techRank1">\
                <select name="rank" id="rank">\
                  <option value="">---</option>\
                  <option value="상">상</option>\
                  <option value="중">중</option>\
                  <option value="하">하</option>\
                </select>\
              </td>\
            </tr>'
      );

      // 추가 버튼을 누르면 한 줄이 추가됨
      $("#addBtn").on("click", function () {

	  // 추가시 데이터를 json으로 전송해 db에 접근시켜 insert함
        // 선택한 데이터의 값을 받아옴
    	var selectedTech = $("#tech option:selected").val();
        var selectedRank = $("#rank option:selected").val();
    	
        // 선택값을 객체에 저장
        var addTech = {};
        addTech.tech_code = selectedTech;
        addTech.tech_level = selectedRank;
        
        $.ajax({
        	url: 'addTech',
			type: "POST",
			data: JSON.stringify(addTech),
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function(data){
				console.log("addTech 성공: " + data);
			},
			error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
        });
    	
        
        // 선택한 기술을 기술목록에서 삭제함
        if (allTechList.indexOf(selectedTech) > -1) {
          if (typeof selectedTech != "undefined" && selectedTech != "") {
            allTechList.splice(allTechList.indexOf(selectedTech), 1);
          }
        }

        // 다음에 추가시 이번에 선택한 기술이 selectbox에 나오지 않게 하기 위한 변수작업 
        opt = '<option value="">---</option>';
        for (var i = 0; i < allTechList.length; i++) {
          opt = opt + '<option value="' + allTechList[i] + '">' + allTechList[i] + '</option>';
        }

        // 선택한 등급의 값을 가져옴
        var rank = "";
        rank = $("#rank option:selected").val();

        // selectbox가 공백이면 alert를 실행하고, 선택이 되었으면 선택된 값을 테이블에 넣어줌
        if (selectedTech === "") {
          alert('기술명을 선택해주세요');
          return false;
        } else if (rank === "") {
          alert('등급을 선택해주세요');
          return false;
        } else {
          // 위에서 했던 변수작업을 적용해 추가를 누르면 이전에 선택했던 값이 selectbox에 나오지 않게함
          $(".tbl_body2").html(
            '<tr>\
            <td class="techList1">\
              <select name="tech" id="tech">'
            + opt +
            ' </select>\
            </td>\
            <td>\
              <select name="rank" id="rank">\
                <option value="">---</option>\
                <option value="상">상</option>\
                <option value="중">중</option>\
                <option value="하">하</option>\
              </select>\
            </td>\
          </tr>'
          );

          //선택한 값을 사용가능기술 테이블에 올림
          $("#tbl_body").append(
            '<tr>\
                <td><input type="checkbox" name="chkBtn" class="selBtn"></td>\
                <td class="techList1">'
            + selectedTech +
            '</td>\
              <td>'
            + rank +
            '</td>\
            </tr>'
          );
        }
      });
      
      //삭제 버튼을 누르면 선택한 행이 삭제됨
      $("#delBtn").on("click", function () {
        var checkTechs = $("[name='chkBtn']:checked");
        var delTechs = new Array();
        if(checkTechs.val() == undefined){
        	alert("삭제할 기술을 선택하세요");
        	return false;
        }
        for (var i = checkTechs.length - 1; i > -1; i--) {
          // 삭제되는 행의 기술명을 가져와서 allTechList에 넣음
          var removeTech = checkTechs.eq(i).closest('tr').text().replace(/^\s*/, "").split(" ")[0];
		  removeTech = removeTech.trim();
          allTechList.push(removeTech);
          delTechs.push(removeTech);
          // 삭제된 기술명을 selectbox를 추가 
          opt = opt + '<option value="' + removeTech + '">' + removeTech + '</option>';
          $(".tbl_body2").html(
            '<tr>\
            <td class="techList1">\
              <select name="tech" id="tech">'
            + opt +
            ' </select>\
            </td>\
            <td>\
              <select name="rank" id="rank">\
                <option value="">---</option>\
                <option value="상">상</option>\
                <option value="중">중</option>\
                <option value="하">하</option>\
              </select>\
            </td>\
          </tr>'
          );
          checkTechs.eq(i).closest('tr').remove(); //삭제
        }
        
        $.ajax({
        	url: 'delTech',
        	type: 'POST',
        	data: JSON.stringify(delTechs),
        	dataType: 'json',
        	contentType: 'application/json; charset=UTF-8',
        	success: function(data){
        		console.log("성공");
        	},
        	error:function(request,status,error){
		        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    },
		    complete: function(){
		    	console.log("전송 성공")
		    }
        });
      });
      
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
	
		
		$("input[type='file']").on("change",function(e){
			var formData = new FormData();
			var inputFile = $("input[name='file']");
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
  <script>
    function readURL(input) {
      var reader = new FileReader();
      reader.onload = function (e) {
        $('#empImg').attr('src', e.target.result);
      }
      reader.readAsDataURL(input.files[0]);
    }
  </script>
</body>
</html>