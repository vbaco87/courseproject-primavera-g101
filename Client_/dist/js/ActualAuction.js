var href = "Auction.html";
var token = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYmFyYmVyYW5AZWR1LnRlY25vY2FtcHVzLmNhdCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDY3MzAzNjksImV4cCI6MTYwNzU1NDgwMH0.L7Kr5w9jM-uBifzSXGLWf4kwP-iwQjiRAfdOsUySnLZvfq76glwwpyZedyp-mNG5Xgk8VeT1Ijizs8QK91472w';


$(document).ready(function () {
    getActiveAuctions();
});

function getActiveAuctions() {
    $.ajax({
        headers: {'Authorization': token},
        url:  "http://localhost:8080/api/auctions?status=active" ,
        async: false,
        type: "get",
        dataType: 'json',
        contentType: 'application/json',

        success: function (data) {
            for (i = 0; i < data.length; i++) {
                console.log(data[i]);
                html =  '<div class="col-lg-6 mb-4"><div class="card h-100"><div class="card-body"><h4 class="card-title"><a href="' + href + '">' + data[i].openingDate+ '</a><span class="badge badge-success active">Active</span></h4><ul><li>Opening date: ' + data[i].openingDate +'</li><li> Closing date: '+data[i].closeDate+ '</li><li>Bitcoins amount ' + data[i].totalBitcoins + '</li><li>Starting price: '+ data[i].price+'</ul></div><a type="button" class="btn btn-outline-primary" href="'+href+'?auction='+data[i].id+'&bitcoins='+data[i].totalBitcoins+'&closeDate='+data[i].closeDate+'&price='+data[i].price+'">See more</a></div></div>';
                $("#subastas").append(html);
            }
        }
    });

}


