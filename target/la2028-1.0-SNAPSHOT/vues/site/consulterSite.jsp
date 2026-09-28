<%@ page import="sio.la2028.model.Site" %>
<%@ page import="sio.la2028.model.Sport" %>
<%@ page import="java.util.ArrayList" %><%--
<%@ page import="sio.la2028.model.Sport" %><%--
  Created by IntelliJ IDEA.
  User: sio2
  Date: 28/09/2026
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>LOS ANGELES 2028</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
  <%
                Site si = (Site)request.getAttribute("siSite");
        %>
<h1><%  out.println(si.getNom());%></h1>

  <%
                    ArrayList<Sport> lesSports = si.getLesSports();
                %>
<table class="table table-striped table-sm">
  <thead>
  <tr>
    <th>Id</th>
    <th>Nom</th>
  </tr>
  </thead>
  <%
    for (Sport s : lesSports)
    {
      out.println("<tr><td>");
      out.println(s.getId());
      out.println("</td>");

      out.println("<td><a href ='../ServletSport/consulter?idSport="+ s.getId()+ "'>");
      out.println(s.getNom());
      out.println("</a></td>");;
    }
  %>
</table>
</html>