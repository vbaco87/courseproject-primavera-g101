var bitcoins = getParameterByName('bitcoins');
var date = getParameterByName('closeDate');
var active = true;
var euros;
var basePrice = parseFloat(getParameterByName('price'));

var userId= "963963963";
var auctionId = getParameterByName('auction');
var bitcoinsBid;
var amountBid;
var token = localStorage.getItem('token');

$(document).ready(function () {
    if(token == null){
        window.location.replace("errors/401.html");
    }
    $.ajax({
        headers: {'Authorization': token },
        url: "http://localhost:8080/api/users/me/account/available",
        async: false,
        type: 'GET',
        crossDomain: true,
        dataType: 'json',
        success: function (data) {
            euros = data;
            euros =parseFloat(euros).toFixed(2);
        }

    })


    addHTML();
    $("#Start").click(() => {
        $("#QuantityBid").show();
        $("#Euro").show();
        $("#Price").show();
        $("#comission").show();
        $("#Start").hide();
    });

    $("#Submit").click(() => {
        $("#SubmitOk").css("display", "none");
        $("#SubmitNotOk").css("display", "none");
        $("#SubmitNotMoney").css("display", "none");
        $("#SubmitNotPrice").css("display", "none");
        bitcoinsBid= $("#bitcoins").val();
        amountBid = $("#euros").val();
        if(amountBid >= basePrice ){
            if(parseFloat(amountBid) <= euros){
                addBid();
                $("#SubmitOk").show();
            }else {
                $("#SubmitNotMoney").show();
            }
        }else {
            $("#SubmitNotPrice").show();
        }
    });

    if(!active){
        $("#activeTab").hide();
        $("#finishedTab").show();
    }
});

function addHTML() {

    $("#info").append('  <h3 class="display-4">Available Bitcoins:' + bitcoins + '₿</h3> <p class="lead">There are '+bitcoins+'₿ bitcoins available to bid. Click "Start Bidding" to make your bid.</p>    <hr class="my-4">    <p>This auction ends on <u>' + date + '</u></p>   <p id="Price" style="display:none;">The base price of the auction is <u>' + basePrice + '€.</u>   </p> <p id="Euro" style="display:none;">The amount of usable money you have in your account is <u>' + euros + '€.</u> <p id="comission" style="display:none;">Remember that exists a comission of 1% for bitcoin center :)</p> </u>  </p>   <a class="btn btn-primary btn-lg" href="#" role="button" id="Start">Start bidding</a>');

}

function addBid(){
    var url = "http://localhost:8080/api/users/me/bids/auctions/"+auctionId;
    var datos = {
        "bitcoins": parseFloat(bitcoinsBid),
        "amount": parseFloat(amountBid) +parseFloat(amountBid)*0.01
    };

    $.ajax({
        async: false,
        headers: {'Authorization': token},
        type:"POST",
        url:url,
        contentType: 'application/json',
        dataType: 'json',
        data:JSON.stringify(datos)
    })
}

function getParameterByName(name, url = window.location.href) {
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}
