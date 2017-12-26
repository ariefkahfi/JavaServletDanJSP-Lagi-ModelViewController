<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Process has been submitted to our server</h1>
        <p>
            Please wait a minute ....
        </p>
        <%
            response.setHeader("Refresh", "3; url=http://localhost:8080/ModelViewController");
        %>
    </body>
</html>
