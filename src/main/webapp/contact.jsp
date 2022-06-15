<%--
  Created by IntelliJ IDEA.
  User: zined
  Date: 04/06/2022
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp" %>
<body>
    <div class="contact-container">
        <div class="w-100 py-5 text-center">
            <h1>Demande de contact</h1>
        </div>
        <div class="contact-form-container container card d-flex justify-content-center align-items-center px-4 py-3">
    <%--        <div class="error mt-3">--%>
    <%--            &lt;%&ndash;            <c:forEach items="${errors}" var="err">&ndash;%&gt;--%>
    <%--            &lt;%&ndash;                <p>${err.value}</p>&ndash;%&gt;--%>
    <%--            &lt;%&ndash;            </c:forEach>&ndash;%&gt;--%>
    <%--            <p class="error-text text-start">${error}</p>--%>
    <%--        </div>--%>

            <form class="contact-form d-flex flex-wrap justify-content-center align-items-center" method="post">
                <div class="w-100 my-3">
                    <div class="w-100 mb-2"><label for="name" class="contact-labels">Votre nom *</label></div>
                    <input class="contact-inputs w-100" type="text" name="name" id="name">
                </div>

                <div class="w-100 my-3">
                    <div class="w-100 mb-2"><label for="email" class="contact-labels">Votre email *</label></div>
                    <input class="contact-inputs w-100" type="email" name="email" id="email">
                </div>

                <div class="w-100 my-3">
                    <div class="w-100 mb-2"><label for="phone" class="contact-labels">Votre téléphone *</label></div>
                    <input class="contact-inputs w-100" type="phone" name="phone" id="phone">
                </div>

                <div class="w-100 my-3">
                    <div class="w-100 mb-2"><label for="subject" class="contact-labels">Sujet *</label></div>
                    <select class="contact-inputs w-100" name="subject" id="subject">
                        <option>Ouverture de compte</option>
                        <option>Réinitialisation du mot de passe</option>
                        <option>Autre</option>
                    </select>
                </div>

                <div class="w-100 my-3">
                    <div class="w-100 mb-2"><label for="message" class="contact-labels">Votre message *</label></div>
                    <textarea class="contact-inputs w-100" name="message" id="message"></textarea>
                </div>

                <div class="w-100 text-end">
                    <p class="fw-light text-muted">Champ requis *</p>
                </div>
                <div class="w-100 text-center pt-3 w-100">
                    <button class="login-btn" type="submit">Envoyer</button>
                </div>
            </form>
        </div>
    </div>
<%@include file="includes/footer.jsp" %>
</body>
</html>
