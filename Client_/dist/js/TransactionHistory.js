var userID = "123123123";
var result = "";
$(document).ready(function () {
    getPurchasedTransactionHistory();


    // HTML PURCHASED TRANSACTION
    for (var clave in result) {
        if (result.hasOwnProperty(clave)) {
            addHTML(result[clave].transactionBroker.date, result[clave].amount, result[clave].price, "green");
        }
    }

    getSoldTransactionHistory();

    // HTML SOLD TRANSACTION
    for (var clave in result) {
        if (result.hasOwnProperty(clave)) {
            addHTML(result[clave].closingDate, result[clave].amount, result[clave].price, "red");
        }
    }

});

function displayVals() {
    console.log($("#option1").attr('checked'));
    console.log($("#option2").attr('checked'));
    console.log($("#option3").attr('checked'));

}

function getPurchasedTransactionHistory() {
    var url = "http://localhost:8080/api/users/" + userID + "/purchasedBitcoins";
    $.ajax
        ({
            async: false,
            headers: { 'Access-Control-Allow-Origin': '*' },
            url: url,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                result = data;
            }
        });
    console.log(result);
}

function getSoldTransactionHistory() {
    var url = "http://localhost:8080/api/users/" + userID + "/soldBitcoins";
    $.ajax
        ({
            async: false,
            headers: { 'Access-Control-Allow-Origin': '*' },
            url: url,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                result = data;
            }
        });
    console.log(result);
}

function addHTML(date, bitcoins, price, color) {
    $("#mytable").append('<tr><td> <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-patch-plus-fll" fill=" ' + color + ' " xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.067.87a2.89 2.89 0 0 0-4.134 0l-.622.638-.89-.011a2.89 2.89 0 0 0-2.924 2.924l.01.89-.636.622a2.89 2.89 0 0 0 0 4.134l.637.622-.011.89a2.89 2.89 0 0 0 2.924 2.924l.89-.01.622.636a2.89 2.89 0 0 0 4.134 0l.622-.637.89.011a2.89 2.89 0 0 0 2.924-2.924l-.01-.89.636-.622a2.89 2.89 0 0 0 0-4.134l-.637-.622.011-.89a2.89 2.89 0 0 0-2.924-2.924l-.89.01-.622-.636zM8.5 6a.5.5 0 0 0-1 0v1.5H6a.5.5 0 0 0 0 1h1.5V10a.5.5 0 0 0 1 0V8.5H10a.5.5 0 0 0 0-1H8.5V6z"/></svg> </td> <td>' + date + '</td> <td>' + bitcoins + '</td> <td>' + price + ' euros</td> </tr>');
}
