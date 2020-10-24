var date = "25 de Enero";
var bitcoins = "2";
var href = "Auction.html";

$(document).ready(function () {
    addHTML();
    addHTML();
    addHTML();
    addHTML();
    addHTML();
});

function addHTML() {
    $("#subastas").append(' <div class="col-lg-6 mb-4"><div class="card h-100"><div class="card-body"><h4 class="card-title"><a href="'+href+'">' + date + '</a></h4><ul><li>Auction date ' + date + '</li><li>Bitcoins amount ' + bitcoins + '</li></ul></div><a type="button" class="btn btn-outline-primary" href="'+href+'">See more</a></div></div>');
}

function getSubastasGanadas() {

}


