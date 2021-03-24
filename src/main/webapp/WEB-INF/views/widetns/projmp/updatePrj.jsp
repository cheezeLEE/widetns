<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>프로젝트맵핑</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
  <style>
    body {
      font-size: 16px;
    }

    .container {
      width: 800px;
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

    .col-sm-12 {
      padding: 0px;
    }

    p {
      margin-top: 20px;
    }

    .btnArea {
      text-align: right;
    }

    textarea {
      width: 100%;
    }

    table {
      border: 1px solid black;
      margin: 20px 0px 20px 0px;
      width: 100%;
    }

    table th,
    table td {
      border: 1px solid black;
      text-align: center;
    }

    table tbody td:first-child {
      text-align: center;
    }
  </style>
</head>

<body>
  <div class="container">
    <div class="row">
      <h1 id="title">프로젝트 수정</h1>
      <p>프로젝트 3</p>

      <p><label>프로젝트 정보</label></p>
      <textarea name="prjInfo" id="prjInfo" rows="10">

  발주처 : LG
  프로젝트 기간 : 2018.3.9 ~ 2018.8.12
  담당자명 : 김길동
  담당자 연락처 : 010-1001-1001
  프로젝트 PM : 홍길동
  사용 기술 : JAVA, MySQL, Sping, AWS...
  비고 : ...
        </textarea>
      <div class="btnArea col-sm-12">
        <button class="btn btn-primary btn-sm">추가</button>
        <button class="btn btn-danger btn-sm">삭제</button>
      </div>
      <p><label>사원정보</label></p>
      <table>
        <thead>
          <tr>
            <th></th>
            <th>사원번호</th>
            <th>직책</th>
            <th>이름</th>
            <th>부서</th>
            <th>경력</th>
            <th>등급</th>
            <th>입사일</th>
            <th>자격증</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th><input type="checkbox" class="selBtn"></th>
            <th>1</th>
            <th>PM</th>
            <th>홍길동</th>
            <th>개발부</th>
            <th>12년</th>
            <th>고급</th>
            <th>2009.2.1</th>
            <th>정보처리기사</th>
          </tr>
          <tr>
            <th><input type="checkbox" class="selBtn"></th>
            <th>2</th>
            <th>PE</th>
            <th>김철수</th>
            <th>개발부</th>
            <th>7년</th>
            <th>중급</th>
            <th>2014.8.30</th>
            <th>정보처리기사</th>
          </tr>
        </tbody>
      </table>
      <div class="btnArea col-sm-12">
        <button class="btn btn-primary" id="regBtn">수정</button>
        <button class="btn btn-danger" id="cancelBtn">취소</button>
      </div>
    </div>
  </div>
  <script src=" https://code.jquery.com/jquery-1.12.4.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
	  $(document).ready(function () {
	      $("#regBtn").on("click", function () {
	        location.href = "/searchPrj"; //데이터를 가지고 페이지이동
	      });
	      
	      $("#cancelBtn").on("click", function () {
	        location.href = "/searchPrj"; //페이지만 이동
	      });
	
	      $("#addBtn").on("click", function () {
	        location.href = "/searchEmp"; //페이지만 이동
	      });
	
	    });
  </script>
</body>

</html>