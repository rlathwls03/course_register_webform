<%--
  Created by IntelliJ IDEA.
  User: kimsojin
  Date: 25. 4. 15.
  Time: 오후 6:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>학사 정보 시스템</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/home.css' />">
  </head>
  <body>
  <div id="container">
    <h2>학사 정보 시스템</h2>
    <ul>
      <li><a href = "<c:url value='/credits'/>">학년별 이수 학점 조회</a></li>
      <li><a href = "<c:url value='/register'/>">수강 신청하기</a></li>
      <li><a href = "<c:url value='/registerView'/>">수강 신청 조회</a></li>
    </ul>
  </div>
  </body>
</html>
