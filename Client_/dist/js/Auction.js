

var bitcoins = 2;
var user = "user123"
var date = "25 January 2021";
var active = true;
var euros;

var userId= "963963963";
var auctionId="1";
var bitcoinsBid;
var amountBid;

$(document).ready(function () {
    $.ajax({
        headers: { 'Access-Control-Allow-Origin': '*' },
        url: "http://localhost:8080/account/" + userId+"/available",
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
        $("#SubmitOk").css("display", "none");
        $("#SubmitNotOk").css("display", "none");
        bitcoinsBid= $("#bitcoins").val();
        amountBid = $("#euros").val()
        if(bitcoinsBid > 0.0 && amountBid>0.0){
            addBid();
            $("#SubmitOk").show();
        }else{
            $("#SubmitNotOk").show();
        }
    });

    if(!active){
        $("#activeTab").hide();
        $("#finishedTab").show();
    }
});

function addHTML() {

    $("#info").append('  <h3 class="display-4">Available Bitcoins:' + bitcoins + '₿</h3>    <h6 class="lead">Welcome to ' + user + ' Auction</h6>    <p class="lead">There are '+bitcoins+'₿ bitcoins available to bid. Click "Start Bidding" to make your bid.</p>    <hr class="my-4">    <p>This auction ends on <u>' + date + '</u></p>    <p id="Euro" style="display:none;">The amount of usable money you have in your account is <u>' + euros + '€.</u>   </p>   <a class="btn btn-primary btn-lg" href="#" role="button" id="Start">Start bidding</a>');

}

function addBid(){
    var url = "http://localhost:8080/api/bids/"+userId+"/"+auctionId;
    var datos = {
        "bitcoins": parseFloat(bitcoinsBid),
        "amount": parseFloat(amountBid)
    };

    $.ajax({
        async: false,
        headers: {'Access-Control-Allow-Origin': '*'},
        type:"POST",
        url:url,
        contentType: 'application/json',
        dataType: 'json',
        data:JSON.stringify(datos)
    })
}

