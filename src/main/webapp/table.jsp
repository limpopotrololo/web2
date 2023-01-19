<%@page import="Beans.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="table" class="Beans.ResultBean" scope="session"/>

<%
    if (table != null) {
        for (Bean bean : table.getResponse()) {

%>

<head>
    <style>
        table, th, tr, td {
            border: 1px solid black;
            padding: 10px;
            font-family: Sans-Serif;
            font-size: 14px;
            border-radius: 10px;
            text-align: center;
        }
    </style>
</head>

    <tr>
        <td><%=bean.getX()%></td>
        <td><%=bean.getY()%></td>
        <td><%=bean.getR()%></td>
        <td><%=bean.isResult() ? "HIT" : "MISS"%></td>
        <td><%=bean.getCurrentTime()%></td>
        <td><%=bean.getComputingTime()%></td>
    </tr>


<%
        }
    }
%>