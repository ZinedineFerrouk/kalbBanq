<%--
  Created by IntelliJ IDEA.
  User: zined
  Date: 02/06/2022
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="includes/header.jsp" %>
<body>
    <div class="container">
        <div>
            <%--<c:forEach items="${errors}" var="err">
                <p>${err.value}</p>
            </c:forEach> --%>

            <p>${error}</p>
        </div>

        <div class="">
            <form method="post">
                <label for="login" class="">Identifiant</label>
                <input type="text" name="login" id="login">

                <label for="password" class="">Mot de passe</label>
                <input type="password" name="password" id="password">

                <button type="submit">Connexion</button>
            </form>
        </div>
    </div>
</body>

<%@include file="includes/footer.jsp" %>
</html>
