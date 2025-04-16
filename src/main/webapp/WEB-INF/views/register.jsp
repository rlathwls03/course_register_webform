<%--
  Created by IntelliJ IDEA.
  User: kimsojin
  Date: 25. 4. 15.
  Time: 오후 6:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>수강 신청</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/register.css' />">
</head>
<body>
<div class="form-container">
    <h2>수강 신청</h2>

    <form:form method="post" modelAttribute="course">
        <label>수강년도</label>
        <form:input path="year" />
        <form:errors path="year" cssClass="error"/>

        <label>학기</label>
        <form:input path="semester" />
        <form:errors path="semester" cssClass="error"/>

        <label>교과코드</label>
        <form:input path="code" />
        <form:errors path="code" cssClass="error"/>

        <label>교과목명</label>
        <form:input path="name" />
        <form:errors path="name" cssClass="error"/>

        <label>교과구분 (예: 전필, 전선)</label>
        <form:input path="type" />
        <form:errors path="type" cssClass="error"/>

        <label>담당교수</label>
        <form:input path="professor" />
        <form:errors path="professor" cssClass="error"/>

        <label>학점</label>
        <form:input path="credit" />
        <form:errors path="credit" cssClass="error"/>

        <input type="submit" value="신청" />
    </form:form>
</div>
</body>
</html>

