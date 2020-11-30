var bitcoins = getParameterByName('bitcoins');
var date = getParameterByName('closeDate');
var active = true;
var euros;
var basePrice = getParameterByName('price');

var userId= "963963963";
var auctionId = getParameterByName('auction');
var bitcoinsBid;
var amountBid;
var token = localStorage.getItem('token');

$(document).ready(function () {
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
     

        },
        //error: function() { alert('Failed!'); },

    });

    addHTML();
    $("#Start").click(() => {
        $("#QuantityBid").show();
        $("#Euro").show();
        $("#Price").show();
        $("#Start").hide();
    });

    $("#Submit").click(() => {
        $("#SubmitOk").css("display", "none");
        $("#SubmitNotOk").css("display", "none");
        $("#SubmitNotMoney").css("display", "none");
        $("#SubmitNotPrice").css("display", "none");
        bitcoinsBid= $("#bitcoins").val();
        amountBid = $("#euros").val()
        if(bitcoinsBid >=0 && amountBid>=0){
            if(euros>=amountBid){
                if(basePrice<=amountBid){
                    addBid();
                    $("#SubmitOk").show();
                }else {
                    $("#SubmitNotPrice").show();
                }
            }else {
                $("#SubmitNotMoney").show();
            }
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

    $("#info").append('  <h3 class="display-4">Available Bitcoins:' + bitcoins + '₿</h3> <p class="lead">There are '+bitcoins+'₿ bitcoins available to bid. Click "Start Bidding" to make your bid.</p>    <hr class="my-4">    <p>This auction ends on <u>' + date + '</u></p>   <p id="Price" style="display:none;">The base price of the auction is <u>' + basePrice + '€.</u>   </p> <p id="Euro" style="display:none;">The amount of usable money you have in your account is <u>' + euros + '€.</u>   </p>   <a class="btn btn-primary btn-lg" href="#" role="button" id="Start">Start bidding</a>');

}

function addBid(){
    var url = "http://localhost:8080/api/users/me/bids/auctions/"+auctionId;
    var datos = {
        "bitcoins": parseFloat(bitcoinsBid),
        "amount": parseFloat(amountBid)
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
