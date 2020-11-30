var purchased = "";
var sold = "";
var all;
var token = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYmFyYmVyYW5AZWR1LnRlY25vY2FtcHVzLmNhdCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDY3MzAzNjksImV4cCI6MTYwNzU1NDgwMH0.L7Kr5w9jM-uBifzSXGLWf4kwP-iwQjiRAfdOsUySnLZvfq76glwwpyZedyp-mNG5Xgk8VeT1Ijizs8QK91472w';

$(document).ready(function () {
     getAllPurchases();
    getAllSales();
    sortAllComissions();
    showAllComissions();
});

function addHTML(date, commission, bitcoins, price) {
    $("#mytable").append('<tr> <td><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-patch-plus-fll" fill="green" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10.067.87a2.89 2.89 0 0 0-4.134 0l-.622.638-.89-.011a2.89 2.89 0 0 0-2.924 2.924l.01.89-.636.622a2.89 2.89 0 0 0 0 4.134l.637.622-.011.89a2.89 2.89 0 0 0 2.924 2.924l.89-.01.622.636a2.89 2.89 0 0 0 4.134 0l.622-.637.89.011a2.89 2.89 0 0 0 2.924-2.924l-.01-.89.636-.622a2.89 2.89 0 0 0 0-4.134l-.637-.622.011-.89a2.89 2.89 0 0 0-2.924-2.924l-.89.01-.622-.636zM8.5 6a.5.5 0 0 0-1 0v1.5H6a.5.5 0 0 0 0 1h1.5V10a.5.5 0 0 0 1 0V8.5H10a.5.5 0 0 0 0-1H8.5V6z"/></svg></td> <td>'+date+'</td> <td>'+commission+'</td> <td>'+bitcoins+'</td> <td>'+price+' euros</td> </tr>');
}

function getAllPurchases() {
    var url = "http://localhost:8080/api/users/purchaseBitcoins";
    $.ajax
        ({
            async: false,
            headers: {'Authorization': token},
            url: url,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                purchased = data;
            }
        });
    console.log(purchased);
}

function getAllSales() {
    var url = "http://localhost:8080/api/users/soldBitcoins";
    $.ajax
        ({
            async: false,
            headers: {'Authorization': token},
            url: url,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                sold = data;
            }
        });
    console.log(sold);
}

function sortAllComissions(){
    all = [];

    for (var clave in sold) {
        if (sold.hasOwnProperty(clave)) {
            var comisio = Math.round((sold[clave].price * 0.01) * 100) / 100;
            var json = { fecha: sold[clave].closingDate, comission: comisio, amount: sold[clave].amount, price: sold[clave].price, type: "sold" }
            all.push(json);
        }
    }
    console.log(all);

    for (var clave in purchased) {
        if (purchased.hasOwnProperty(clave)) {
            var comisio = Math.round((purchased[clave].price * 0.01) * 100) / 100;
            var json = { fecha: purchased[clave].transactionBroker.date, comission: comisio, amount: purchased[clave].amount, price: purchased[clave].price, type: "sold" }
            all.push(json);   
        }
    }
    console.log(all);

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
}

function showAllComissions(){

    var i;
    for (i=0; i<all.length;i++){
        addHTML(all[i].fecha, all[i].comission, all[i].amount, all[i].price);
    }

}
