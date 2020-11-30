var price=0;
var token = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYmFyYmVyYW5AZWR1LnRlY25vY2FtcHVzLmNhdCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDY3MzAzNjksImV4cCI6MTYwNzU1NDgwMH0.L7Kr5w9jM-uBifzSXGLWf4kwP-iwQjiRAfdOsUySnLZvfq76glwwpyZedyp-mNG5Xgk8VeT1Ijizs8QK91472w';

$(document).ready(function () {

    getBitcoinPrice();
  setInterval(function () {
    updateAmountToPay();
 }, 200);
  $("#buyButton").click(function(){

    sessionStorage.setItem("AmountOfBitcoins",$("#btp").val());
    window.location.href = "Checkout.html";
  });
});

function getBitcoinPrice() {

  $.ajax({

    headers: {'Authorization': token},
    url:  "https://stockmarkettrading.azurewebsites.net/stocks/bitcoins/primavera" ,
    async: false,
    type: "get",

    dataType: 'json',
    contentType: 'application/json',

    success: function (data) {
      price = data.unitPriceInEur;
      console.log(price);
      
      $("#bitcoinPrice").text(price + "€");
    },
    //error: function() { alert('Failed!'); },

});

}

function updateAmountToPay() {
  $("#amountToPay").attr("placeholder", price * $("#btp").val());
}

function showPaymentForm() {
  $("#paymentForm").show();
  $("#buyBitcoins").hide();
}
