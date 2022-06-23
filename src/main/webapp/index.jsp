<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@include file="includes/header.jsp" %>

<div class="mt-5">
    <div class="top-div-content">
        <div class="container d-flex justify-content-between align-items-center">
            <div class="">
                <h1 class="title my-2 fw-bolder">KalbBank votre banque <br> nouvelle génération</h1>
                <p class="my-4 fw-light">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores commodi <br> cum delectus nobis perspiciatis quam quibusdam quis rem!</p>

                <a href="contact"><button type="button" class="open-acount-btn btn">Ouvrez votre compte</button></a>
            </div>
            <a href="client-area.jsp"> page lient</a>
            <div class="">
                <img class="money" src="public/assets/images/money.svg">
            </div>
        </div>

        <div class="container div-text-container d-flex justify-content-between align-items-center">
            <div class="m-3">
                <h4 class="text-white">Un compte de paiement</h4>
                <p class="h6">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto at deleniti dolor in .</p>
            </div>

            <div class="m-3">
                <h4 class="text-white">Un compte de paiement</h4>
                <p class="h6">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto at deleniti dolor in .</p>
            </div>

            <div class="m-3">
                <h4 class="text-white">Un compte de paiement</h4>
                <p class="h6">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto at deleniti dolor in .</p>
            </div>
        </div>
    </div>

    <div class="cards-background-container d-flex justify-content-center align-items-center">
        <div class="bg-transparent container">
            <div class="d-flex justify-content-center align-items-center">
                <img class="n26-card-red" src="public/assets/images/kalbbank-cards-mastercard-rhubarb-fr.png">
                <img class="n26-card-black" src="public/assets/images/kalbbank-cards-mastercard-metal-charcoalblack.png">
                <img class="n26-card-transparent" src="public/assets/images/kalbbank-cards-mastercard-fr.png">
            </div>
            <h3 class="text-white text-center pt-5">Comparez les offres KalbBank et choisissez la vôtre</h3>
            <div class="text-center mt-5">
                <a href="contact"><button type="button" class="open-acount-btn btn">Ouvrez votre compte</button></a>
            </div>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
</html>