var price = "";
$(document).ready(function() {

    setInterval(function(){
        getBitcoinPrice();
        updateAmountToPay();
     }, 200);
    
   
});

function getBitcoinPrice() {
    $.get("https://blockchain.info/ticker", (data) => {
        price = data.EUR.sell;
        $("#bitcoinPrice").text(price + data.EUR.symbol);
    });
}

function updateAmountToPay(){
    console.log($("#btp").val());
        $("#amountToPay").attr("placeholder", price*$("#btp").val())
}