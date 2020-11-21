var bitcoins;
var price;

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
        price = data.unitPriceInEur;
        console.log(price);
        $("#amounts").append(" <p>Bitcoins = " + bitcoins + ",  price = " + price + "</p>");

      },
      //error: function() { alert('Failed!'); },
  
  });
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
        console.log(price);
        
       
      },
      //error: function() { alert('Failed!'); },
  
  });
}


function postTransaction() {
    var comisio = (price * 0.01) / 100 ;
   price= (price + comisio)
    $.ajax({

        headers: { 'Access-Control-Allow-Origin': '*' },
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

        headers: { 'Access-Control-Allow-Origin': '*' },
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

