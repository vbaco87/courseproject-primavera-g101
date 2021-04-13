var price = 0;
var token = localStorage.getItem('token');
$(document).ready(function () {
  if (token == null) {
    window.location.replace("errors/401.html");
  }

  getBitcoinPrice();
  setInterval(function () {
    updateAmountToPay();
  }, 200);
  $("#buyButton").click(function () {

    sessionStorage.setItem("AmountOfBitcoins", $("#btp").val());
    window.location.href = "Checkout.html";
  });
});

function getBitcoinPrice() {
  var status = "";
  $.ajax({

    headers: { 'Access-Control-Allow-Origin': '*' },
    url: "https://stockmarkettrading.azurewebsites.net/stocks/bitcoins/primavera",
    async: false,
    type: "get",

    dataType: 'json',
    contentType: 'application/json',

    success: function (data) {
      price = data.unitPriceInEur;
      console.log(price);

      $("#bitcoinPrice").text(price + "€");
    },
    error: function (jqXHR, textStatus, errorThrown) {
      //console.log(textStatus + ": " + jqXHR.status + " " + errorThrown);
      status = jqXHR.status
    }

  })
  if (status == 403) {
    window.location.replace("errors/401.html");
  }
}

function updateAmountToPay() {
  $("#amountToPay").attr("placeholder", price * $("#btp").val());
}

function showPaymentForm() {
  $("#paymentForm").show();
  $("#buyBitcoins").hide();
}
