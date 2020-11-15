var userID = "123123123";
var sold = "";
var totalSold = 0;
var purchased = "";
var totalPurchased = 0;
var all = [];


$(document).ready(function () {

    $("select").change(function () {
        $("select option:selected").each(function () {

            if ($(this).text() === "ALL") {

                $("tbody").empty();
                $("#estadistica").empty();

                getPurchasedTransactionHistory();
                getSoldTransactionHistory();

                sortTransactions();
                addHTMLAllTransactions();

                addEstadistica();
            }
            else if ($(this).text() === "SOLD") {

                $("tbody").empty();
                $("#estadistica").empty();

                getSoldTransactionHistory();
                addSoldHTML();
            }
            else {
                $("tbody").empty();
                $("#estadistica").empty();

                getPurchasedTransactionHistory();
                addPurchasedHTML();
            }
        });
    }).trigger("change");

});

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
                purchased = data;
            }
        });
    console.log(purchased);
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
                sold = data;
            }
        });
    console.log(sold);
}

function addHTML(date, bitcoins, price, color) {
    $("#mytable").append('<tr><td> <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-patch-plus-fll" fill=" ' + color + ' " xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.067.87a2.89 2.89 0 0 0-4.134 0l-.622.638-.89-.011a2.89 2.89 0 0 0-2.924 2.924l.01.89-.636.622a2.89 2.89 0 0 0 0 4.134l.637.622-.011.89a2.89 2.89 0 0 0 2.924 2.924l.89-.01.622.636a2.89 2.89 0 0 0 4.134 0l.622-.637.89.011a2.89 2.89 0 0 0 2.924-2.924l-.01-.89.636-.622a2.89 2.89 0 0 0 0-4.134l-.637-.622.011-.89a2.89 2.89 0 0 0-2.924-2.924l-.89.01-.622-.636zM8.5 6a.5.5 0 0 0-1 0v1.5H6a.5.5 0 0 0 0 1h1.5V10a.5.5 0 0 0 1 0V8.5H10a.5.5 0 0 0 0-1H8.5V6z"/></svg> </td> <td>' + date + '</td> <td>' + bitcoins + '</td> <td>' + price + ' euros</td> </tr>');
}

function addPurchasedHTML() {
    // HTML PURCHASED TRANSACTION
    for (var clave in purchased) {
        if (purchased.hasOwnProperty(clave)) {
            addHTML(purchased[clave].transactionBroker.date, purchased[clave].amount, purchased[clave].price, "red");
        }
    }
}

function addSoldHTML() {
    // HTML SOLD TRANSACTION
    for (var clave in sold) {
        if (sold.hasOwnProperty(clave)) {
            addHTML(sold[clave].closingDate, sold[clave].amount, sold[clave].price, "green");
        }
    }
}

function addEstadistica() {
    if (totalSold-totalPurchased >= 0) {
        $("#estadistica").append('<div class="alert alert-success" role="alert"> <h4 class="alert-heading">STATISTICS</h4> <hr><p class="mb-0">You have won ' + totalPurchased + ' euros with your auctions <br> You have paid ' + totalSold + ' euros with your purchases <br> You have won ' + (totalPurchased - totalSold) + ' euros with your auctions transactions </p> </div>')
    }
    else {
        $("#estadistica").append('<div class="alert alert-danger" role="alert"> <h4 class="alert-heading">STATISTICS</h4> <hr><p class="mb-0">You have won ' + totalPurchased + ' euros with your auctions <br> You have paid ' + totalSold + ' euros with your purchases <br> You have won ' + (totalPurchased - totalSold) + ' euros with your auctions transactions </p> ')
    }
}

function sortTransactions() {
    all = [];
    for (var clave in sold) {
        if (sold.hasOwnProperty(clave)) {
            var json = { fecha: sold[clave].closingDate, amount: sold[clave].amount, price: sold[clave].price, type: "sold" }
            all.push(json);
        }
    }
    for (var clave in purchased) {
        if (purchased.hasOwnProperty(clave)) {
            var json = { fecha: purchased[clave].transactionBroker.date, amount: purchased[clave].amount, price: purchased[clave].price, type: "purchased" };
            all.push(json);
        }
    }
    all.sort(function (a, b) {
        if(parseInt(b.fecha.slice(0, 4)) - parseInt(a.fecha.slice(0, 4)) != 0){
            return parseInt(b.fecha.slice(0, 4)) - parseInt(a.fecha.slice(0, 4));
        }
        else if(parseInt(b.fecha.slice(5, 7)) - parseInt(a.fecha.slice(5, 7)) != 0){
            return parseInt(b.fecha.slice(5, 7)) - parseInt(a.fecha.slice(5, 7));
        }
        else{
            return parseInt(a.fecha.slice(8, 10)) - parseInt(b.fecha.slice(8, 10))
        }
        
    });

    console.log(all);
}

function addHTMLAllTransactions() {
    var i;
    totalPurchased = 0;
    totalSold = 0;
    for (i = 0; i < all.length; i++) {
        if (all[i].type === "sold") {
            addHTML (all[i].fecha, all[i].amount, all[i].price, "green");
            totalSold += all[i].price * all[i].amount;
        }
        else {
            addHTML (all[i].fecha, all[i].amount, all[i].price, "red");
            totalPurchased += all[i].price * all[i].amount;
        }
    }
}
