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

    .col-sm-12 {
      margin-bottom: 10px;
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h1 id="title">사원 검색</h1>
      <div class="col-sm-12">
        <label for="empName">이름</label>
        <input type="text" name="empName" id="empName" required>
        <button class="btn btn-primary" id="searchBtn">검색</button>
      </div>
      <table>
        <thead>
          <tr>
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
          <c:forEach items="${emp}" var="emp">
			<tr>
			  <td><c:out value="${emp.emp_num }" /></td>
			  <td><c:out value="${emp.pos }" /></td>
			  <td><c:out value="${emp.kor_name }" /></td>
			  <td><c:out value="${emp.dept }" /></td>
			  <td><c:out value="${emp.career }" /></td>
			  <td><c:out value="${emp.emp_level }" /></td>
			  <td><fmt:formatDate value="${emp.join_date }" pattern="yyyy-MM-dd"/></td>
			  <td><c:out value="${emp.cert }" /></td>
			</tr>          
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>

  <script src=" https://code.jquery.com/jquery-1.12.4.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>