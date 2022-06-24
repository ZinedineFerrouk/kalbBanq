<%--
  Created by IntelliJ IDEA.
  User: zined
  Date: 23/06/2022
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="includes/connected-header.jsp" %>

<div class="blue d-flex justify-content-center">
  <div class="white-b w-75 my-5">
      <div class="border-bottom my-4 mx-4">
          <div>
            <h2>${account.getAccountType().getName()}</h2>
          </div>
          <div class="t-blue fw-light">
            ${customer.getGender()} ${customer.getFirst_name()} ${customer.getLast_name()}
              -
              ${account.getAccountNumber()}
          </div>
      </div>
      <div class="b-blue m-4">
        <div class="fw-normal m-2">
          <h3>Rechercher une opération</h3>
        </div>

        <div class="m-2 small fw-light">
          Période de recherche maximale : 6 derniers mois
        </div>

        <div class="d-flex flex-row p-1">
            <div class="w-25">
              Date entre
            </div>

            <div class="w-25">
              <input type="text" placeholder="du">
            </div>

            <div class="w-25">
              <input type="text" placeholder="au">
            </div>
        </div>

        <div class="d-flex flex-row p-1">
            <div class="w-25">
              Montant entre
            </div>

            <div class="w-25">
              <input type="text" placeholder="de">
            </div>

            <div class="w-25">
              <input type="text" placeholder="à">
            </div>
        </div>
      </div>

          <div class="m-4" id="recap">
            <table class="table table-striped">
              <thead>
              <tr>
                <th scope="col">Date</th>
                <th scope="col">Libellé</th>
                <th scope="col">Débit</th>
                <th scope="col">Crédit</th>
              </tr>
              </thead>

              <tbody class="t-blue">
                  <tr>
                      <th scope="row">24/06/2022</th>
                      <td>VIREMENT</td>
                      <td></td>
                      <td class="t-blue">+ 45</td>
                  </tr>

                  <tr class="t-blue b-blue">
                      <th scope="row">31/05/2022</th>
                      <td>VIREMENT</td>
                      <td></td>
                      <td class="t-blue">+ 150€</td>
                  </tr>

                  <tr>
                      <th scope="row">13/05/2022</th>
                      <td>VIREMENT</td>
                      <td class="text-danger">- 50€</td>
                      <td></td>
                  </tr>

                  <tr class="t-blue b-blue">
                    <th scope="row">03/05/2022</th>
                      <td>VIREMENT</td>
                      <td class="text-danger">- 78€</td>
                      <td></td>
                  </tr>

                  <tr>
                      <th scope="row">31/05/2022</th>
                      <td>VIREMENT</td>
                      <td></td>
                      <td class="t-blue">+ 150€</td>
                  </tr>

                  <tr class="t-blue b-blue">
                    <th scope="row">13/05/2022</th>
                    <td>VIREMENT</td>
                    <td></td>
                    <td class="t-blue">+ 100€</td>
                  </tr>

                  <tr>
                      <th scope="row">21/11/2021</th>
                      <td>VIREMENT</td>
                      <td class="text-danger">- 23€</td>
                      <td></td>
                  </tr>

                  <tr class="t-blue b-blue">
                      <th scope="row">24/06/2022</th>
                      <td>VIREMENT</td>
                      <td></td>
                      <td class="t-blue">- 85</td>
                  </tr>

                  <tr>
                      <th scope="row">31/05/2022</th>
                      <td>VIREMENT</td>
                      <td></td>
                      <td class="t-blue">+ 1500€</td>
                  </tr>

                  <tr class="t-blue b-blue">
                      <th scope="row">13/05/2022</th>
                      <td>VIREMENT</td>
                      <td class="text-danger">- 138,89€</td>
                      <td></td>
                  </tr>

                  <tr>
                    <th scope="row">03/05/2022</th>
                      <td>VIREMENT</td>
                      <td class="text-danger">- 78,48€</td>
                      <td></td>
                  </tr>

                  <tr class="t-blue b-blue">
                      <th scope="row">31/05/2022</th>
                      <td>VIREMENT</td>
                      <td class="text-danger">- 1157,67€</td>
                      <td></td>
                  </tr>

                  <tr>
                    <th scope="row">13/05/2022</th>
                    <td>VIREMENT</td>
                    <td></td>
                    <td class="t-blue">+ 1400,12€</td>
                  </tr>

                  <tr class="t-blue b-blue">
                      <th scope="row">21/11/2021</th>
                      <td>VIREMENT</td>
                      <td class="text-danger">- 90,30€</td>
                      <td></td>
                  </tr>
              </tbody>
            </table>

              <div class="text-center">
                  <a class="t-blue fw-light text-decoration-underline text-center" href="${pageContext.request.contextPath}/customer/accounts">Plus d'opérations</a>
              </div>
          </div>
    </div>
</div>
</div>

<%@include file="includes/footer.jsp"%>
</html></html>
