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
    <title>수강 과목 상세</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/coursedetail.css' />">
</head>
<body>
<h2 style="text-align:center;">수강 과목 상세</h2>

<table>
    <thead>
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.year}</td>
            <td>${course.semester}</td>
            <td>${course.name}</td>
            <td>${course.type}</td>
            <td>${course.professor}</td>
            <td>${course.credit}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div style="text-align: center; margin-top: 20px;">
    <a href="<c:url value='/'/>">홈으로 돌아가기</a>
</div>
</body>
</html>
