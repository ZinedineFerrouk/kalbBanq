<%--
  Created by IntelliJ IDEA.
  User: zined
  Date: 23/06/2022
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="connected-header.jsp" %>

<div class ="container w-50" id="main">
    <div class ="container my-5" id="dashboard">
        <div id="infoUser" >
            <div id="l1"class="d-flex bd-highlight">
                <div class="mx-4 my-2 me-auto bd-highlight ">
                    Acceuil
                </div>
                <div class="mx-4 my-2 bd-highlight ">
                    <button type="button" class="btn btn-primary btn-acc cyan">Mes Comptes</button>
                </div>
                <div class="mx-4 my-2 bd-highlight ">
                    <button type="button" class="btn btn-primary btn-acc cyan">Mes informations</button>
                </div>
            </div>
            <div  class="d-flex bd-highlight ">
                <div class="mx-4 my-2 me-auto bd-highlight">
                    Montant
                </div>
                <div class="mx-4 my-2 bd-highlight ">
                    <button type="button" class="btn btn-primary btn-acc cyan"> Virement</button>
                </div>
            </div>
        </div>
        <div class =" my-5" id="options">
            <div id="l-1" class="d-flex justify-content-end d-inline">
                <div class="mx-4 my-2">
                    Trier par date
                </div>
                <div class="md-form md-outline input-with-post-icon datepicker mx-4 my-2 " inline="true" >
                    <input id="startDate" class="form-control btn-acc blue"  type="date" placeholder="Au" />
                </div>
                <div class="md-form md-outline input-with-post-icon datepicker mx-4 my-2" inline="true">
                    <input id="endDate" class="form-control btn-acc blue" type="date" placeholder="Au" />
                </div>
            </div>
            <div id="l2" class="d-flex justify-content-end">
                <div class="md-form md-outline input-with-post-icon datepicker mx-4 my-2" inline="true">
                    <input  class="form-control btn-acc blue" type="text" placeholder="Montant Min"/>
                </div>
                <div class="md-form md-outline input-with-post-icon datepicker mx-4 my-2" inline="true">
                    <input class="form-control btn-acc blue" type="text" placeholder="Montant Max" />
                </div>
            </div>
        </div>
    </div>
    <div class="container " id="recap">
        <table class="table table-striped ">
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
            </tr>
            <tr>
                <th scope="row">21/10/2002</th>
                <td>edf</td>
                <td>23$</td>
            </tr>
            <tr>
                <th scope="row">52/10/2055</th>
                <td>lol</td>
                <td>32$</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>