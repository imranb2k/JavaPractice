<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Registration Information</h2>
   <table>
    <tr>
        <td>ID</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>User Name</td>
        <td>${userName}</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>${password}</td>
    </tr>
</table>
</body>
</html>