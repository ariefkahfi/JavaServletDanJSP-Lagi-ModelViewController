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
        <form method="POST" action="${pageContext.servletContext.contextPath}/page/submit-checkout">
            <table border="2">
                <tr>
                    <td>Key</td>
                    <td>Name</td>
                    <td>Quantity</td>
                    <td>Total Price</td>
                    <td>Formatted Price</td>
                </tr>
                <%
                    for(Map.Entry me : cartBean.getItemsBeanCart().entrySet()){
                        ItemBean bean = (ItemBean)me.getValue();

                        float totalPrice = cartBean.calculatePricePerItemBeanKey(bean);
                        String formattedPrice = cartBean.formatPrice(totalPrice);
                        
                        out.println(
                                "<tr>"
                                        + "<td>" +bean.getKey() + "</td>"
                                        + "<td>" +bean.getName() +"</td>"
                                        + "<td>" +bean.getQuantity() + "</td>"
                                        + "<td>" +totalPrice + "</td>"
                                        + "<td>" +formattedPrice + "</td>"
                                        + "</tr>"
                        );

                    }
                %>
            </table>
            <input type="submit" value="Final Process"/>
        </form>
        
    </body>
</html>
