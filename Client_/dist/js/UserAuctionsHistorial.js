var userId = "456456456";
var active;
var token = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYmFyYmVyYW5AZWR1LnRlY25vY2FtcHVzLmNhdCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDY3MzAzNjksImV4cCI6MTYwNzU1NDgwMH0.L7Kr5w9jM-uBifzSXGLWf4kwP-iwQjiRAfdOsUySnLZvfq76glwwpyZedyp-mNG5Xgk8VeT1Ijizs8QK91472w';

$(document).ready(function () {
    getAuctionHistory();
});

function getAuctionHistory() {

    $.ajax({
        headers: {'Authorization': token},
        url:  "http://localhost:8080/api/users/"+userId+"/auctions?status=all" ,
        async: false,
        type: "get",
        dataType: 'json',
        contentType: 'application/json',

        success: function (data) {
            for (i = 0; i < data.length; i++) {
                console.log(data[i]);
                var auctionStatus;
                if(TDate(data[i].closeDate)){
                    auctionStatus='</a><span class="badge badge-success active">Active</span>';
                    active = true;
                }
                else{
                    auctionStatus = '<span class="badge badge-danger active">Finished</span>';
                    active = false;
                }

                html =  '<div class="col-lg-6 mb-4"><div class="card h-100"><div class="card-body"><h4 class="card-title"><a href="#">' + data[i].openingDate+ '</a>'+auctionStatus+'</h4><ul><li>Opening date: ' + data[i].openingDate +'</li><li> Closing date: '+data[i].closeDate+ '</li><li>Bitcoins amount ' + data[i].totalBitcoins + '</li><li>Starting price: '+ data[i].price+'</ul></div><a type="button" class="btn btn-outline-primary" href="Bid.html?auction='+data[i].id+'&user='+userId+'&active='+active+'">SEE MY BID</a></div></div>';
                $("#subastas").append(html);

            }
        }
    });
}

function TDate(date) {
    var ToDate = new Date();

    if (new Date(date).getTime() <= ToDate.getTime()) {
          return false;
     }
    return true;
}

