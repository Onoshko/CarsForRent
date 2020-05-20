<%--
  Created by IntelliJ IDEA.
  User: Shayneek
  Date: 19.05.2020
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<a href="${pageContext.request.contextPath}/logout">logout</a>
<h3>Пользователи</h3>

<table border=1>
    <thead>
    <tr>
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>phone</th>
        <th>Email</th>
        <th>card Number</th>
        
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.firstName}" /></td>
            <td><c:out value="${user.lastName}" /></td>
            <td><c:out value="${user.phone}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><c:out value="${user.cardName}" /></td>

        </tr>
    </c:forEach>
    </tbody>
</table>