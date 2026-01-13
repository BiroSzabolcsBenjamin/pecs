const form = document.getElementById("checkoutForm");
const paypal = document.getElementById("paypal");
const cardData = document.getElementById("cardData");

cardData.addEventListener("change", function () {
    if (paypal.checked) {
        cardData.style.display = "none";
    } else {
        cardData.style.display = "block";
    }
});

form.addEventListener("submit", function (event) {

});