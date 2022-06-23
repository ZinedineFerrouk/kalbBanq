<%--
  Created by IntelliJ IDEA.
  User: zined
  Date: 23/06/2022
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="includes/connected-header.jsp" %>

<div class="blue d-flex justify-content-center">
    <div class="white-b w-50 my-5 ">
        <div class="border-bottom mx-3">
            <div class="fw-bold">
                Comptes & Contrats
            </div>
            <div class="t-blue ">
                Situation au
                <input class="t-blue" id="Aujourdhui" type="date" name="date" value="" readonly>
                <script>
                    document.getElementById("Aujourdhui").valueAsDate = new Date();
                </script>
            </div>
        </div>
        <div class="mx-3 border-bottom d-flex flex-row m-4">
            <c:forEach var="account" items="${accounts.values()}">
                <li>${account.getAccountType().getName()}</li>
                <div class="ms-auto mx-3 ">
                    <a href="${pageContext.request.contextPath}/customer/account/details/?id=${account.getId().toString()}" class="text-decoration-underline t-blue-f">Voir detail</a>
                </div>
            </c:forEach>
            <div class="w-75">
                <div class=" fw-bold t-blue-f">
                    type de compte
                </div>
                <div class="d-flex flex-row t-blue ">
                    <div>
                        Nom prenom
                    </div>
                    <div>
                        - n°compte
                    </div>
                    <div class="w-50 d-flex flex-row">
                        <div class="t-red w-50 text-center">
                            negatif
                        </div>
                        <div class="t-blue w-50 text-center">
                            positif
                        </div>
                    </div>
                </div>
            </div>


<%--            <div class="ms-auto mx-3 ">--%>
<%--                <a href="/customer/account/detail/${account.getId().toString()}" class="text-decoration-underline t-blue-f">Voir detail</a>--%>
<%--            </div>--%>
        </div>
        <div class="mx-3 my-4 d-flex justify-content-end">
            <button type="button" class="cyan rounded ">
                <div class="t-white mx-3 my-4">
                    <a class="text-decoration-none" href="contact">Ouvrir un compte</a>
                </div>
            </button>
        </div>

    </div>
</div>

<%@include file="includes/footer.jsp"%>
</html></html>
