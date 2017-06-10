<%@ page import="java.util.*" %>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
 
<html>
    <head>
    </head>
    <body>
        <table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>User Record</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Prod ID</b></td>
                <td><b>Prod Name</b></td>
                <td><b>Price</b></td>
                <td><b>Desc</b></td>
                <td><b>Sc_Id</b></td>
                <td><b>C_Id</b></td>
            </tr>
            <%
                int count = 0;
                String color = "#F9EBB3";
                if (request.getAttribute("result") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("result");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                        if ((count % 2) == 0) {
                            color = "#eeffee";
                        }
                        count++;
                        ArrayList result = (ArrayList) itr.next();
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=result.get(0)%></td>
                <td><%=result.get(1)%></td>
                <td><%=result.get(2)%></td>
                <td><%=result.get(3)%></td>
                <td><%=result.get(4)%></td>
                <td><%=result.get(5)%></td>
            </tr>
            <%
                    }
                }
                if (count == 0) {
            %>
            <tr>
                <td colspan=4 align="center"
                    style="background-color:#eeffee"><b>No Record Found..</b></td>
            </tr>
            <%            }
            %>
        </table>
    </body>
</html>
