<%--
  Created by IntelliJ IDEA.
  User: Shayneek
  Date: 17.05.2020
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="POST" action='/registration' name="AddUser">
    First Name : <input
        type="text" name="firstName"
        value="${user.firstName}" /> <br />
    Last Name : <input
        type="text" name="lastName"
        value="${user.lastName}" /> <br />
    Phone : <input
        type="text" name="phone"
        value="${user.phone}" /> <br />
    Email : <input
        type="text" name="email"
        value="${user.email}" /> <br />
    Card Number : <input
        type="text" name="cardNumber"
        value="${user.cardNumber}"  /> <br />
    Login : <input
        type="text" name="login"
        value="${authUser.login}"  /> <br />
    Password : <input
        type="text" name="password"
        value="${authUser.password}" /> <br />

    <input
        type="submit" value="ok" />
</form>
</body>
</html>



</body>
</html>
