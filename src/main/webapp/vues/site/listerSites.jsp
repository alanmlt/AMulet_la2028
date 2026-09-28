<%@ page import="java.util.ArrayList" %>
<%@ page import="sio.la2028.model.Site" %><%--
  Created by IntelliJ IDEA.
  User: sio2
  Date: 28/09/2026
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LOS ANGELES 2028</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <style>
        body {
            padding-top: 50px;
        }
        .special {
            padding-top:50px;
        }
    </style>
    <a href="${pageContext.request.contextPath}/index.html"><div class = accueil>Accueil</div></a>
</head>

<div class="container special">
    <h2 class="h2">Liste des sites</h2>
    <div class="table-responsive">
        <%
            ArrayList<Site> lesSites = (ArrayList)request.getAttribute("siLesSites");
        %>
        <table class="table table-striped table-sm">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <%
                    for (Site si : lesSites)
                    {
                        out.println("<tr><td>");
                        out.println(si.getId());
                        out.println("</td>");

                        out.println("<td><a href ='../ServletSite/consulter?idSite="+ si.getId()+ "'>");
                        out.println(si.getNom());
                        out.println("</a></td>");;
                    }
                %>
            </tr>
            </tbody>
        </table>
        </body>
    </div>
</div>

</html>

