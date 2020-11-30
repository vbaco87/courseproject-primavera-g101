var bitcoins;
var price;
var token = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYmFyYmVyYW5AZWR1LnRlY25vY2FtcHVzLmNhdCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDY3MzAzNjksImV4cCI6MTYwNzU1NDgwMH0.L7Kr5w9jM-uBifzSXGLWf4kwP-iwQjiRAfdOsUySnLZvfq76glwwpyZedyp-mNG5Xgk8VeT1Ijizs8QK91472w';
var accountId = 123123123;


$(document).ready(function () {
   bitcoins = sessionStorage.getItem("AmountOfBitcoins");
  getBitcoinPrice();

    $("#payButton").click(function () {
        buyBitcoins() ;
        postTransaction();
        makeEntry();
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
        price = data.unitPriceInEur * bitcoins;
        price = parseFloat(price).toFixed(2);
        addHTML();

      },
      //error: function() { alert('Failed!'); },
  
  });
}
function addHTML(){
    $("#Bitcoins").append(bitcoins+'₿');
    $("#Total").append(price+'€');
}
function buyBitcoins() {
    var dataSend = {
        "groupId": "primavera",
        "amount": bitcoins
    };
    $.ajax({
  
      headers: { 'Access-Control-Allow-Origin': '*' },
      url:  "https://stockmarkettrading.azurewebsites.net/stocks/bitcoins/" ,
      async: false,
      type: "post",
  
      dataType: 'json',
      contentType: 'application/json',
      data: dataSend,
      success: function (dataReply) {
        price = dataReply.unitPriceInEur;


        
       
      },
      //error: function() { alert('Failed!'); },
  
  });
}


function postTransaction() {
    var comisio = (price * 0.01) / 100 ;
   price= (price + comisio)
    $.ajax({

        headers: {'Authorization': token},
        url:  "http://localhost:8080/api/users/" + accountId + "/buyBitcoins?bitcoins=" + bitcoins + "&price=" +price ,
        async: false,
        type: "POST",

        dataType: 'json',
        contentType: 'application/json',

        success: function () {

        },
        //error: function() { alert('Failed!'); },

    });

}
function makeEntry() {

    var data = {
        "quantity": bitcoins,
        "type": "bitcoin"
    };
    $.ajax({

        headers: {'Authorization': token},
        url: "http://localhost:8080/api/users/" + accountId + "/account",
        async: false,
        type: 'post',
        crossDomain: true,
        dataType: 'json',

        data: data,
        success: function () {
            console.log("Success");
        },
        //error: function() { alert('Failed!'); },
    });
    $("#TransactionSuccess").show();
}

