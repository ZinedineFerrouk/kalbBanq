<%--
  Created by IntelliJ IDEA.
  User: maxime.carville
  Date: 19/06/2022
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="includes/connected-header.jsp" %>
</head>
<body>
  <div class="blue d-flex justify-content-center">
      <div class="white-b  w-75 m-4 p-3">
          <div class="t-blue-f fw-bold">
              Saisir un virement entre vos comptes
          </div>
          <div class="t-blue small">
            informations obligatoire *
          </div>
          <div class="b-red">
              <div class="t-red">
                  Veuillez sélectionner un compte à créditer different du compte à débiter
              </div>
          </div>
          <div class="d-flex flex-row justify-content-center">
              <div class="m-4 p-2 w-50">
                  <div class="t-blue">
                      Compte à débiter *
                  </div>
                  <div class="b-blue p-4 border-secondary">
                      <div class="b-white border-secondary">
                          <div class="form-check">
                              <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                              <label class="form-check-label" for="flexRadioDefault1">
                                  <div class="d-flex flex-row  ">
                                      <div>
                                          <div class="t-blue-f fw-bold">
                                              Type de compte
                                          </div>
                                          <div class="t-blue small ">
                                              Mprenom
                                          </div>
                                      </div>
                                      <div class="t-blue">
                                          Montant
                                      </div>
                                  </div>

                              </label>
                          </div>
                      </div>
                  </div>
              </div>
              <div class="m-4 p-2 w-50">
                  <div class="t-blue">
                      Compte à débiter *
                  </div>
                  <div class="b-blue p-4 border-secondary">
                      <div class="b-white border-secondary">
                          <div class="form-check">
                              <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                              <label class="form-check-label" for="flexRadioDefault1">
                                  <div class="d-flex flex-row  ">
                                      <div>
                                          <div class="t-blue-f fw-bold">
                                              Type de compte
                                          </div>
                                          <div class="t-blue small ">
                                              Mprenom
                                          </div>
                                      </div>
                                      <div class="t-blue">
                                          Montant
                                      </div>
                                  </div>
                              </label>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
          <div class="w-100 d-flex justify-content-center t-blue-f">
              Montant
              <input type="text">
              Eur
          </div>
          <div class="w-100 d-flex justify-content-center btn-acc m-4 ">
              <button class="cyan rounded">
                  <div class="t-white">
                      Valider
                  </div>
              </button>
          </div>
      </div>

  </div>
</body>
</html>
