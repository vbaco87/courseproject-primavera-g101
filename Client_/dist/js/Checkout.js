var bitcoins;
var price;
var token = localStorage.getItem('token');
var accountId = 123123123;


$(document).ready(function () {
    bitcoins = sessionStorage.getItem("AmountOfBitcoins");
    getBitcoinPrice();

    $("#payButton").click(function () {
        postTransaction();

    });
});
function getBitcoinPrice() {

    $.ajax({

        headers: { 'Access-Control-Allow-Origin': '*' },
        url: "https://stockmarkettrading.azurewebsites.net/stocks/bitcoins/primavera",
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
function addHTML() {
    $("#Bitcoins").append(bitcoins + '₿');
    $("#Total").append(price + '€');
}
/*
function buyBitcoins() {

    $.ajax({
  
      headers: { 'Access-Control-Allow-Origin': '*' },
      url:  "https://stockmarkettrading.azurewebsites.net/stocks/bitcoins" ,
      async: false,
      type: "post",
  
      dataType: 'json',
      contentType: 'application/json',
      data: dataSend,
      success: function (dataReply) {
        price = dataReply.unitPriceInEur;
        console.log("Success");
        postTransaction();
    
        
       
      },
      error: function() {
          console.log("fail"); 
          $("#TransactionError").show();
       },
  
  });
}*/


function postTransaction() {
    // var price = price + (price * 0.01) / 100 ;
    // price= (price +  (price * 0.01) / 100).toFixed(2);
    var dataSend = {
        "groupId": "primavera",
        "amount": bitcoins
    };
    $.ajax({
        headers: { 'Authorization': token },
        url: "http://localhost:8080/api/users/me/buyBitcoins?bitcoins=" + bitcoins,

        async: false,
        type: "POST",

        //dataType: 'json',
        contentType: 'application/json',

        success: function () {
            $("#TransactionSuccess").show();
            //makeEntry();
        },
        error: function () {
            console.log("fail");
            $("#TransactionError").show();
        },


    });

}/*
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
  
}*/

