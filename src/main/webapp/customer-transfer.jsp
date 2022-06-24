<%--
  Created by IntelliJ IDEA.
  User: zined
  Date: 23/06/2022
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="includes/connected-header.jsp"%>

<div class="blue d-flex justify-content-center">
    <div class="white-b w-75 m-4 p-3">
        <div class="t-blue-f fw-bold">
            Saisir un virement entre vos comptes
        </div>

        <div class="t-blue small">
            Informations obligatoire *
        </div>

        <div class="d-flex justify-content-center w-100">
            <div class="m-4 p-2 w-50">
                <div class="t-blue">
                    Compte à débiter *
                </div>

                <c:forEach var="account" items="${accounts.values()}">
                    <div class="b-blue p-3 border-secondary">
                        <div class="b-white text-start p-2 border border-1">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                                <label class="form-check-label" for="flexRadioDefault1">
                                    <div class="d-flex flex-row">
                                        <div>
                                            <div class="t-blue-f fw-bold">
                                                <p>${account.getAccountType().getName()}</p>
                                            </div>
                                            <div class="t-blue small">
                                                <p>${customer.getGender()} ${customer.getLast_name()} ${customer.getFirst_name()} - ${account.getAccountNumber()}</p>
                                            </div>
                                        </div>

                                        <div class="t-blue">
                                            <p>${acccount.getSold()}</p>
                                        </div>
                                    </div>

                                </label>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="m-4 p-2 w-50">
                <div class="t-blue">
                    Compte à créditer *
                </div>

                <c:forEach var="account" items="${accounts.values()}">
                    <div class="b-blue p-3 border-secondary">
                        <div class="b-white text-start p-2 border border-1">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                                <label class="form-check-label" for="flexRadioDefault1">
                                    <div class="d-flex flex-row">
                                        <div>
                                            <div class="t-blue-f fw-bold">
                                                <p>${account.getAccountType().getName()}</p>
                                            </div>
                                            <div class="t-blue small">
                                                <p>${customer.getGender()} ${customer.getLast_name()} ${customer.getFirst_name()} - ${account.getAccountNumber()}</p>
                                            </div>
                                        </div>

                                        <div class="t-blue">
                                            <p>${acccount.getSold()}</p>
                                        </div>
                                    </div>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        <div class="w-100 d-flex justify-content-center t-blue-f">
            Montant en € *
            <input class="w-25" type="text">
        </div>

        <div class="w-100 d-flex justify-content-center btn-acc m-4 ">
            <button class="cyan px-3 py-2 rounded w-25">
                <div class="t-white fw-light">
                    Valider
                </div>
            </button>
        </div>
        </div>
    </div>


    </div>

</div>

<%@include file="includes/footer.jsp"%>
</html>
