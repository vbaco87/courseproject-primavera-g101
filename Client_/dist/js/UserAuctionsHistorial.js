var date = "25 de Enero";
var state = "active"
var euros = 18;
var bitcoins = "2";
var comission = 0.001;

$(document).ready(function () {
    addHTML();
    addHTML();
    addHTML();
    addHTML();
});

function addHTML() {
    $("#subastas").append(' <div class="col-lg-6 mb-4"><div class="card h-100"><div class="card-body"><h4 class="card-title"><a href="#">' + date + '</a></h4><ul><li>Auction date ' + date + '</li><li>Initial euros amount ' + euros + ' euros</li><li>Final euros amount ' + (euros + euros*comission) + ' euros </li><li>Bitcoins amount ' + bitcoins + '</li><li style = "font-weight: bold">This auction is ' + state +' </li></ul></div><button type="button" class="btn btn-outline-primary">See more</button></div></div>');
}

function getSubastasGanadas() {

}


