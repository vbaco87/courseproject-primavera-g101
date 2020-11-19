active = true;
closingDate = "2000/05/21";
qttEuros = 120;
qttBitcoins = 2;
$(document).ready(function () {
    getBidStatus();
    showBid();
});

function getBidStatus() {
    if(active === true){
        $("#status").append('<h1 id="activeTab">Bid information <span class="badge badge-success mt-4">Active</span></h1>');
    }
    else{
        $("#status").append('<h1 id="activeTab">Bid information <span class="badge badge-danger mt-4">Finished</span></h1>');
    }
}

function showBid() {
    $("#information").append('<ul><li>This bid ends ' + closingDate + '</li><li>Your bitcoin amount is ' +qttBitcoins+ '₿</li><li>You have bid ' +qttEuros + ' €</li></ul>');
    
}

// Proposta... No se si és necessari ensenyar la informació de auction (qui la va crear, qtt de bitcoins que es van subastar, qtt euros inicials...)
// Si creus que s'ha d'afegir cosa al front avisa... se que ha quedat ultra soso but no sé que més posar i he seguit el model del Pau :)
