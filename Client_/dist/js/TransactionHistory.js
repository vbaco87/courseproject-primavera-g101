
$(document).ready(function () {
    addHTML("23/3/2020", 18, "22");
    addHTML("27/7/2008", 12, "24");
    addHTML("23/3/2020", 7, "26");
    addHTML("23/3/2020", 1, "2");
});

function getAllTransactionHistory(){

}

function getPurchasedTransactionHistory(){
    
}

function getSoldTransactionHistory(){
    
}

function addHTML(date, bitcoins, price) {
    $("#mytable").append('<tr> <td>'+date+'</td> <td>'+bitcoins+'</td> <td>'+price+' euros</td> </tr>');
}



