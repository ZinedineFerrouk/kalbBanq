<%--
  Created by IntelliJ IDEA.
  User: zined
  Date: 23/06/2022
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- BOOTSTRAP -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/d3b4554197.js" crossorigin="anonymous"></script>
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="/public/assets/style/style.css"/>
    <link rel="stylesheet" type="text/css" href="/public/assets/style/customer-area.css"/>
    <title>Kalbanq - La banque qui se soucie d'elle même</title>
</head>
<body>
<div class=" d-flex justify-content-between shadow-sm ">
    <div class="w-50">
        <div class="logo-container">
            <a class="text-decoration-none" href="/customer/index"><img class="logo" src="/public/assets/images/logo_banq_2.png"></a>
            <p class="slogan">L'argent avant les gens</p>
        </div>
    </div>
    <div class="links-container w-50 d-flex justify-content-end align-items-center">
        <a class="text-decoration-none" href="/customer/index">Accueil</a>
        <a class="text-decoration-none" href="/customer/accounts">Mes Comptes</a>
        <a class="text-decoration-none" href="/customer-transfer.jsp">Virement</a>
    </div>
    <div class="text-white cyan w-25 d-flex flex-column bd-highlight justify-content-center p-4">
        <div class="small fw-light bd-highlight">
            Votre conseiller KalBank
        </div>
        <div class="bd-highlight">
            <p class="fw-normal">${banker.getGender()} ${banker.getLast_name()} ${banker.getFirst_name()}</p>
        </div>
        <div class="bd-highlight">
            <p class="fw-normal">${customer.getPhone()}</p>
        </div>
    </div>

        <div class="red-header px-3 me-3 d-flex justify-content-center align-items-center">
            <a class="fw-light" href="/logout">
                <div class="text-center mt-1 py-1">
                    <i class="fa-solid fa-power-off fa-3x fa-inverse w-50"></i>
                </div>
                <div class="t-white text-center">
                    Déconnexion
                </div>
            </a>
        </div>
</div>
