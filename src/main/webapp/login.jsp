<%--
  Created by IntelliJ IDEA.
  User: zined
  Date: 02/06/2022
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="includes/header.jsp" %>
<body>
    <div class="login-container">
        <div class="login-form-container container card d-flex justify-content-center align-items-center py-5">

            <p class="error-text text-start mt-3">${message}</p>
<%--            <% if (!request.getAttribute("error").equals("")){ %>--%>
<%--                <p class="error-text text-start mt-3">${error}</p>--%>
<%--            <% } %>--%>

            <div class="d-block text-center my-3">
                <i class="fa-regular fa-user fa-3x"></i>
                <h1 class="login-title mt-2">Mon espace client</h1>
            </div>

            <form action="login" id="login-form" class="login-form d-flex flex-wrap justify-content-center align-items-center" method="post">
                <div class="login-widget-containers my-3">
                    <div class="login-labels-containers mb-2"><label for="identifier" class="login-labels">Identifiant</label></div>
                    <input class="login-inputs w-100" type="text" name="identifier" id="identifier">
                </div>

                <div class="login-widget-containers my-3">
                    <div class="login-labels-containers mb-2"><label for="password" class="login-labels">Mot de passe</label></div>
                    <input class="login-inputs w-100" type="password" name="password" id="password">
                </div>

                <div class="w-100 text-center pt-3 w-100">
                    <button class="login-btn" type="submit">Se connecter</button>
                </div>

                <a class="login-reset-link" href="contact">Mot de passe oublié</a>
            </form>
        </div>
    </div>
</body>

<%@include file="includes/footer.jsp" %>
</html>
