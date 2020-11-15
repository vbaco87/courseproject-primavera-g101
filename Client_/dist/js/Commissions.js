var purchased = "";
var sold = "";
var all;

$(document).ready(function () {
     getAllPurchases();
    getAllSales();
    sortAllComissions();
    showAllComissions();
});

function addHTML(date, commission, bitcoins, price) {
    $("#mytable").append('<tr> <td>'+date+'</td> <td>'+commission+'</td> <td>'+bitcoins+'</td> <td>'+price+' euros</td> </tr>');
}

function getAllPurchases() {
    var url = "http://localhost:8080/api/users/purchaseBitcoins";
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

function getAllSales() {
    var url = "http://localhost:8080/api/users/soldBitcoins";
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
