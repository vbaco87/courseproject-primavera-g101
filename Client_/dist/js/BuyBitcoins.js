var price=0;
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

    headers: { 'Access-Control-Allow-Origin': '*' },
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
