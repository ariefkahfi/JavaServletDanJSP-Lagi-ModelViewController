<%@page 
    contentType="text/html" 
    pageEncoding="UTF-8"
    session="true"
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <h1>Index Page</h1>
        
        <jsp:useBean id="cartBean" class="com.arief.models.ShoppingCart" scope="session"></jsp:useBean>
        <jsp:setProperty name="cartBean" property="*"/>
        
        <form method="POST" action="${pageContext.servletContext.contextPath}/form">
            <select name="item">
                <option value="Laptop">Laptop</option>
                <option value="Headset">Headset</option>
            </select>
            <input type="submit" value="Add To Cart"/>
        </form>
            
        <a href="${pageContext.servletContext.contextPath}/page/cart">My Cart</a>
        
    </body>
</html>
