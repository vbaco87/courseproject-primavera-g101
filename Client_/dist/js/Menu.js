var result = "";

var userID = "";

var userType = "";
var token = localStorage.getItem('token');

$(document).ready(function () {

    addUserType();

    addMenu();
});



function addMenu() {


    console.log("carapan" + userType);

    $("#menuHome").append('<div class="sb-sidenav-menu-heading">Core</div><a class="nav-link" href="index.html"><div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>Home</a>')

    $("#menuWallet").append('<div class="sb-sidenav-menu-heading">Account</div><a class="nav-link" href="wallet.html"><div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>Wallet</a>');

    if (userType === "ADMINISTRATOR" || userType === "BIDDER") {
        $("#menuCurrentAuctions").append('<a class="nav-link" href="ActualAuctions.html"><div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>Current Auctions</a>')

        $("#menuAuctionHistory").append('<a class="nav-link" href="UserAuctionsHistorial.html"><div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>Auction History</a>');

        $("#menuUserWonAuctions").append('<a class="nav-link" href="WonAuction.html"><div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>My won auctions</a>');
    }

    if (userType === "ADMINISTRATOR" || userType === "BROKER") {
        $("#menuBuyBitcoins").append('<a class="nav-link" href="BuyBitcoins.html"><div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>Buy Bitcoins</a>');

        $("#menuOrganizeAuction").append('<a class="nav-link" href="OrganizeAuction.html"><div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>Organize an auction</a>')

        $("#menuTransactionHistory").append('<a class="nav-link" href="TransactionHistory.html"><div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>Transaction History</a>')
    }

    if (userType === "ADMINISTRATOR") {
        $("#menuComissions").append('<a class="nav-link" href="Commissions.html"><div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>Comissions</a>');
    }

    $("#menuUserType").append(userType);

}


function addUserType() {
    var url = "http://localhost:8080/api/users/me/role";
    console.log("ESTEN EN EL MÈTODE");
    console.log("ABANS " + userType)
    $.ajax
        ({
            async: false,
            headers: { 'Authorization': token },
            url: url,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                console.log("DATA : " + data);
                userType = data.role;
            },
            "error": function (request, textStatus, errorThrown) {
                console.log('error: ' + textStatus + ' headers: ' + request.getAllResponseHeaders() + ' ErrorThrown: ' + errorThrown);
            }
            
        });
        console.log("DESPRES " + userType);
}