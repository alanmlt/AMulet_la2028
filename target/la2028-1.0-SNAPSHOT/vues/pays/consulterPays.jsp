<%@ page import="sio.la2028.model.Athlete" %>
<%@ page import="sio.la2028.model.Pays" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sio2
  Date: 16/09/2026
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>LOS ANGELES 2028</title>
</head>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>LOS ANGELES 2028</title>
</head>
<body>
  <%
                Pays p = (Pays)request.getAttribute("pPays");
        %>
<h1><%  out.println(p.getNom());%></h1>

    <%
                    ArrayList<Athlete> lesAthletes = p.getLesAthletes();
                %>
  <table class="table table-striped table-sm">
  <thead>
  <tr>
      <th>Id</th>
      <th>Nom</th>
      <th>Prenom</th>
  </tr>
  </thead>
    <%
      for (Athlete a : lesAthletes)
      {
        out.println("<tr><td>");
        out.println(a.getId());
        out.println("</td>");

        out.println("<td><a href ='../ServletAthlete/consulter?idAthlete="+ a.getId()+ "'>");
        out.println(a.getNom());
        out.println("</a></td>");;

        out.println("<td>");
        out.println(a.getPrenom());
        out.println("</td>");
      }
    %>
</table>
</html>

