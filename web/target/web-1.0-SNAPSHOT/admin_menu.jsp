<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin_meny</title>

</head>
<body>

<h3>Пользователи</h3>

<c:if test="${users != null}">
    <table border=1>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>phone</th>
            <th>Email</th>
            <th>card Number</th>
            <th colspan=1>Action</th>
        </tr>



        <c:forEach items="${users}" var="user" >


            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.phone}</td>
                <td>${user.email}</td>
                <td>${user.cardNumber }</td>
                <td><a href="AsminServlet?action=delete&Id=<c:out value="${user.id}"/>">Delete</a></td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
    </form>
    <form method="get" action="/addUser">
        <input class="button" type="submit" value="Добавить пользователя">
    </form>
    </body>
    </html>
</c:if>