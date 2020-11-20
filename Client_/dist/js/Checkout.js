var bitcoins ;
var price ;

var accountId = 123123123;


$(document).ready(function () {
    bitcoins = sessionStorage.getItem("AmountOfBitcoins");
    price = sessionStorage.getItem("AmountToPay");
    setValuesPrice();
    $("#payButton").click(function () {
        //Comprovació dades tarjeta
        //si dades son correctes --> postTransaction
        postTransaction();
        makeEntry();
    });
});

function setValuesPrice() {
    $("#amounts").append(" <p>Bitcoins = " + bitcoins + ",  price = " + price + "</p>");
}

function postTransaction() {
    var comisio = ((price * 0.01) * 100 / 100);
    var data = {
        "bitcoins":bitcoins,
        "price": price+comisio
        };
        var url = "http://localhost:8080/api/users/" + accountId + "/buyBitcoins";
    $.ajax({

        headers: { 'Access-Control-Allow-Origin': '*'},
        url: url,
        async: false,
        type:"POST",

        dataType: 'json',
        contentType: 'application/json',
        data: data,
        success: function () {
          
        },
        //error: function() { alert('Failed!'); },

    });

}
function makeEntry() {

    var data = {
        "quantity": bitcoins ,
        "type": "bitcoin"
    };
    $.ajax({

        headers: { 'Access-Control-Allow-Origin': '*'},
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
