<%@ page import="sio.la2028.model.Athlete" %>
<%@ page import="sio.la2028.model.Epreuve" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static jdk.internal.org.jline.utils.Colors.s" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>LOS ANGELES 2028</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <a href="${pageContext.request.contextPath}/index.html"><div class = accueil>Accueil</div></a>
</head>
<body>
  <%
                Epreuve e = (Epreuve)request.getAttribute("eEpreuve");
        %>
    <div class="container special">
      <h2 class="h2">Liste des athletes participant à l'epreuve : <%  out.println(e.getNom());%></h2>
    <div class="table-responsive">

  <%
                    ArrayList<Athlete> lesAthletes = e.getLesAthletes();
                %>
<table class="table table-striped table-sm">
  <thead>
  <tr>
    <th>Id</th>
    <th>Nom</th>
    <th>Prénom</th>
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