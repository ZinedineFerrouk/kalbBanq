<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<script src="https://kit.fontawesome.com/d3b4554197.js" crossorigin="anonymous"></script>
<script src="https://unpkg.com/feather-icons"></script>
<%@include file="includes/header.jsp" %>

<div class="container mt-5">
    <div class="d-flex ">
        <div class="">
            <h1 class="">KalbBank votre banque <br> nouvelle génération</h1>
            <p class="">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores commodi <br> cum delectus nobis perspiciatis quam quibusdam quis rem!</p>

            <button href="/">Ouvrez votre compte</button>
            <a href="<%= request.getContextPath()%>/customer-reception.jsp">espace client</a>
            <a href="<%= request.getContextPath()%>/client-area.jsp">espace client compte</a>
            <a href="<%= request.getContextPath()%>/customer-detail.jsp">detail client compte</a>
            <a href="<%= request.getContextPath()%>/customer-transfer.jsp">page virement</a>

        </div>

        <div class="">
            <img class="money" src="public/assets/images/money.png">
        </div>
    </div>
</div>

<img style="width: 100px;" src="public/assets/images/Donald-Trump-Finger-4164996446">

<%@include file="includes/footer.jsp" %>
</html>