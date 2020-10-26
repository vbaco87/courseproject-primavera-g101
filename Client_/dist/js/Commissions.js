var date = "23/3/2020";
var price = 18;
var bitcoins = "2";
var commission = 1.8;

$(document).ready(function () {
    addHTML();
    addHTML();
    addHTML();
    addHTML();
});

function addHTML() {
    $("#mytable").append('<tr> <td>'+date+'</td> <td>'+commission+'</td> <td>'+bitcoins+'</td> <td>'+price+' euros</td> </tr>');
}



