var date = "23/3/2020";
var price = 18;
var bitcoins = "2";

$(document).ready(function () {
    addHTML();
    addHTML();
    addHTML();
    addHTML();
});

function addHTML() {
    $("#mytable").append('<tr> <td>'+date+'</td> <td>'+bitcoins+'</td> <td>'+price+' euros</td> </tr>');
}



