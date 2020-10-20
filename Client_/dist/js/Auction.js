
var euros = "18";
var bitcoins = 2;
var user = "user123"
var date = "25 January 2021";

$(document).ready(function () {
    addHTML();
    $("#Start").click(() => {
        $("#QuantityBid").show();
    });
    $("#Submit").click(() => {
        //processar bid
    });
});

function addHTML() {

    $("#info").append('  <h3 class="display-4">Available Bitcoins:' + bitcoins + '₿</h3>    <h6 class="lead">Welcome to ' + user + ' Auction</h6>    <p class="lead">There are '+bitcoins+'₿ bitcoins available to bid. Click "Start Bidding" to make your bid.</p>    <hr class="my-4">    <p>This auction ends on ' + date + '</p>    <a class="btn btn-primary btn-lg" href="#" role="button" id="Start">Start bidding</a>');
    $("#Euro").append(' <div class="media">    <h2 class="mr-3">' + euros + '€    </h2>    <div class="media-body">        <h5 class="mt-0">Euros</h5>      The amount of euros you have in your account is ' + euros + '€.    </div></div>');
}

