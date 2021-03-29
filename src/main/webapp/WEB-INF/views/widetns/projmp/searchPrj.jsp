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
  <title>프로젝트 맵핑</title>
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

    #title {
      margin: 20px 0px 20px 20px;
      font-weight: bold;
    }

    label {
      margin: 0px 10px 0px 0px;
    }

    #searchBtn {
      margin-left: 10px;
    }

    table {
      border: 1px solid black;
      margin: 20px 0px 20px 20px;
      width: 98%;
    }

    table th,
    table td {
      border: 1px solid black;
      text-align: center;
    }

    table tbody td:first-child {
      text-align: center;
    }

    #btnArea {
      text-align: right;
    }

    .col-sm-12 {
      margin-bottom: 10px;
    }

    .col-sm-12 input {
      margin-right: 20px;
    }

    span {
      margin-right: 20px;
    }
  </style>
</head>

<body>
  <div class="container">
    <div class="row">
      <h1 id="title">프로젝트 검색</h1>

      <div class="col-sm-12">
        <label for="prjName">프로젝트명</label>
        <input type="text" name="prjName" id="prjName" required>
        <label for="empName">사원명</label>
        <input type="text" name="empName" id="empName">
      </div>
      <div class="col-sm-12">
        <label for="startDate">프로젝트기간</label>
        <input type="date" name="startDate" id="startDate">
        <span>~</span>
        <input type="date" name="endDate" id="endDate">
        <button type="button" id="searchBtn" class="btn btn-primary">검색</button>

      </div>
      <table>
        <thead>
          <tr>
            <th></th>
            <th>프로젝트명</th>
            <th>책임자</th>
            <th>프로젝트기간</th>
          </tr>
        </thead>
        <tbody>
		  <c:forEach items="${list}" var="list">
		  	<tr>
		  	  <td><input type="radio" name="selBtn" class="selBtn"></td>
		  	  <td><c:out value="${list.prj_name}" /></td>
		  	  <td><c:out value="${list.pm_name}" /></td>
		  	  <td><fmt:formatDate value="${list.prj_start}" pattern="yyyy-MM-dd"/> ~ <fmt:formatDate value="${list.prj_end}" pattern="yyyy-MM-dd"/></td>
		  	</tr>
		  </c:forEach>
<!--           <tr>
            <td><input type="radio" name="selBtn" class="selBtn"></td>
            <td>프로젝트1</td>
            <td>홍길동</td>
            <td>2021.2.20 ~ 2021.5.31</td>
          </tr>
          <tr>
            <td><input type="radio" name="selBtn" class="selBtn"></td>
            <td>프로젝트2</td>
            <td>홍길동</td>
            <td>2020.4.30 ~ 2020.7.25</td>
          </tr>
          <tr>
            <td><input type="radio" name="selBtn" class="selBtn"></td>
            <td>프로젝트3</td>
            <td>홍길동</td>
            <td>2019.1.2 ~ 2019.6.31</td>
          </tr> -->
        </tbody>
      </table>
      <div id="btnArea">
        <button class="btn btn-primary" id="regBtn">등록</button>
        <button class="btn btn-default" id="updateBtn">수정</button>
      </div>

    </div>
  </div>

  <script src=" https://code.jquery.com/jquery-1.12.4.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
    $(document).ready(function () {
      $("#regBtn").on("click", function () {
        location.href = "/writePrj";
      });
      $("#updateBtn").on("click", function () {
        location.href = "/updatePrj";
      });
    });
  </script>
</body>

</html>