<%@ page import="sio.la2028.model.Pays" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sio2
  Date: 16/09/2026
  Time: 09:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LOS ANGELES 2028</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <title>LOS ANGELES 2028</title>

    <style>
        body {
            padding-top: 50px;
        }
        .special {
            padding-top:50px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a  href ='../ServletPays/lister' class="navbar-brand" href=".">Système de gestion des pays</a>
        </div>
    </div>
</nav>
</body>
<div class="container special">
    <h2 class="h2">Liste des pays</h2>
    <div class="table-responsive">
        <%
            ArrayList<Pays> lesPays = (ArrayList)request.getAttribute("pLesPays");
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
                    for (Pays a : lesPays)
                    {
                        out.println("<tr><td>");
                        out.println(a.getId());
                        out.println("</td>");

                        out.println("<td><a href ='../ServletPays/consulter?idPays="+ a.getId()+ "'>");
                        out.println(a.getNom());
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

