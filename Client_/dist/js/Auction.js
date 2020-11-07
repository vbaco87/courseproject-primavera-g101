

var bitcoins = 2;
var user = "user123"
var date = "25 January 2021";
var active = true;
var euros;
var accountId=1;

$(document).ready(function () {
    $.ajax({

        headers: { 'Access-Control-Allow-Origin': '*' },
        url: "http://localhost:8080/available/" + accountId,
        async: false,
        type: 'GET',
        crossDomain: true,
        dataType: 'json',
        success: function (data) {
            euros = data;
     

        },
        //error: function() { alert('Failed!'); },

    });
    addHTML();
    $("#Start").click(() => {
        $("#QuantityBid").show();
        $("#Euro").show();
        $("#Start").hide();
    });
    $("#Submit").click(() => {
        //processar bid
    });
    if(!active){
        $("#activeTab").hide();
        $("#finishedTab").show();
    }
});

function addHTML() {

    $("#info").append('  <h3 class="display-4">Available Bitcoins:' + bitcoins + '₿</h3>    <h6 class="lead">Welcome to ' + user + ' Auction</h6>    <p class="lead">There are '+bitcoins+'₿ bitcoins available to bid. Click "Start Bidding" to make your bid.</p>    <hr class="my-4">    <p>This auction ends on <u>' + date + '</u></p>    <p id="Euro" style="display:none;">The amount of usable money you have in your account is <u>' + euros + '€.</u>   </p>   <a class="btn btn-primary btn-lg" href="#" role="button" id="Start">Start bidding</a>');

}

