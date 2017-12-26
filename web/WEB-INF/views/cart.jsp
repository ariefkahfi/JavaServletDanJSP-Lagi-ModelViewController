<%@page import="com.arief.models.ItemBean"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="cartBean" class="com.arief.models.ShoppingCart" scope="session"></jsp:useBean>
        <form method="POST" action="${pageContext.servletContext.contextPath}/page/checkout">
            <table border="2">
                <tr>
                    <td>Key</td>
                    <td>Name</td>
                    <td>Quantity</td>
                    <td>Remove</td>
                </tr>

                <%
                    for(Map.Entry me : cartBean.getItemsBeanCart().entrySet()){
                       ItemBean itemBean = (ItemBean)me.getValue();

                       out.println(
                               "<tr>"
                                       + "<td>" +me.getKey() + "</td>"
                                       + "<td>" +itemBean.getName() +  "</td>"
                                       + "<td>" +itemBean.getQuantity() + "</td>"
                                       + "<td><a href = '/ModelViewController/remove?id="+me.getKey()+"'>Remove This</a></td>"
                                       + "</tr>"
                       );
                    }
                %>

            </table>
            <input type="submit" value="Submit To Checkout"/>
        </form>
        
    </body>
</html>
