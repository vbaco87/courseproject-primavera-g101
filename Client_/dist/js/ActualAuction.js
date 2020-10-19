var date = "25 de Enero";
var bitcoins = "2";

$(document).ready(function () {
    addHTML();
    addHTML();
    addHTML();
    addHTML();
    addHTML();
});

function addHTML() {
    $("#subastas").append(' <div class="col-lg-6 mb-4"><div class="card h-100"><div class="card-body"><h4 class="card-title"><a href="#">' + date + '</a></h4><ul><li>Auction date ' + date + '</li><li>Bitocins amount ' + bitcoins + '</li></ul></div><button type="button" class="btn btn-outline-primary">See more</button></div></div>');
}

function getSubastasGanadas() {

}


