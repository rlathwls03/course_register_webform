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
    <title>학점 요약</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/credits.css' />">
</head>
<body>
<h2 style="text-align: center;">학기별 이수 학점</h2>

<table>
    <thead>
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>취득 학점</th>
        <th>상세보기</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${summary}">
        <tr>
            <td>${row[0]}</td>  <%--년도--%>
            <td>${row[1]}</td> <%--학기--%>
            <td>${row[2]}</td> <%--학점--%>
            <td><a href="<c:url value='/credits/${row[0]}/${row[1]}'/>">상세보기</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="2"><strong>총계</strong></td>
        <td colspan="2"><strong>${totalCredit}</strong></td>
    </tr>
    </tbody>
</table>
<div style="text-align: center; margin-top: 20px;">
    <a href="<c:url value='/'/>">홈으로 돌아가기</a>
</div>
</body>
</html>

