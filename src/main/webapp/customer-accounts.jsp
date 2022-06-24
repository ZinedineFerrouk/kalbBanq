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
    <div class="white-b w-75 my-5 ">
        <div class="border-bottom m-3 p-3">
            <div class="fw-bold">
                <h2>Comptes & Contrats</h2>
            </div>
            <div class="t-blue fw-normal">
                <% if(request.getAttribute("currentDate") != null) { %>
                    <p>Situation au ${currentDate}</p>
                <% } else { %>
                    <p>Situation au 26/06/1998</p>
                <% } %>
            </div>
        </div>

        <div class="m-3 p-3 d-flex flex-row">
            <table class="table">
                <tbody>
                    <c:forEach var="account" items="${accounts.values()}">
                        <tr class="p-3">
                            <td class="text-start">
                                <p class="fw-normal">${account.getAccountType().getName()}</p>
                                <div class="t-blue">
                                    <p class="fw-light">
                                            ${customer.getGender()}
                                            ${customer.getFirst_name()}
                                            ${customer.getLast_name()} -
                                            ${account.getAccountNumber()}
                                    </p>
                                </div>
                            </td>
                            <td class="t-blue text-center">+ ${account.getSold()} €</td>
                            <td class="t-blue text-center"><a href="${pageContext.request.contextPath}/customer/account/details/?id=${account.getId().toString()}" class="fw-light text-decoration-underline t-blue-f">Voir détails</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="d-flex justify-content-end">
            <div class="cyan t-white mx-5 my-4 py-3 px-5 rounded">
                <a class="text-decoration-none fw-light" href="${pageContext.request.contextPath}/contact">Ouvrir un compte</a>
            </div>
        </div>

    </div>
</div>
<%@include file="includes/footer.jsp"%>
</html>
