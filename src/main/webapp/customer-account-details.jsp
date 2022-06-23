<%--
  Created by IntelliJ IDEA.
  User: zined
  Date: 23/06/2022
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/connected-header.jsp" %>

<div class="blue d-flex justify-content-center">
  <div class="white-b  w-75 my-5">
    <div class="border-bottom my-4 mx-4">
      <div class="fw-bold">
        Type de compte
      </div>
      <div class="t-blue">
        M Nom Prenom - n° de compte
      </div>
    </div>
    <div class="b-blue m-4">
      <div class="fw-bold m-2">
        Rechercher une opération
      </div>
      <div class="m-2 small ">
        Période de recherche maximale : 6 derniers mois
      </div>
      <div class="d-flex flex-row p-4">
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
      <div class="d-flex flex-row p-4">
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
    <div class=" m-4 " id="recap">
      <table class="table table-striped">
        <thead>
        <tr>
          <th scope="col">Date</th>
          <th scope="col">Libellé</th>
          <th scope="col">Débit</th>
          <th scope="col">Crédit</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <th scope="row">02/21/2002</th>
          <td>auto</td>
          <td> 325$</td>
          <td>23$</td>
        </tr>
        <tr>
          <th scope="row">21/10/2002</th>
          <td>edf</td>
          <td>23$</td>
          <td>23$</td>
        </tr>
        <tr>
          <th scope="row">52/10/2055</th>
          <td>lol</td>
          <td>32$</td>
          <td>23$</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
</div>

<%@include file="includes/footer.jsp"%>
</html></html>
