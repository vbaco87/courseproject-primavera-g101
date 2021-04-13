var userId = "456456456";
var token = localStorage.getItem('token');

$(document).ready(function () {
    if(token == null){
        window.location.replace("errors/401.html");
    }
    getWonAuctions();
});

function getWonAuctions() {

    $.ajax({
        headers: {'Authorization': token},
        url:  "http://localhost:8080/api/bidders/me/auctions?onlyWon=true" ,
        async: false,
        type: "get",
        dataType: 'json',
        contentType: 'application/json',

        success: function (data) {
            for (i = 0; i < data.length; i++) {
                console.log(data[i]);
                html =  '<div class="col-lg-6 mb-4"><div class="card h-100"><div class="card-body"><h4 class="card-title"><a href="#">' + data[i].openingDate+ '</a><span class="badge badge-danger active">Finished</span></h4><ul><li>Opening date: ' + data[i].openingDate +'</li><li> Closing date: '+data[i].closeDate+ '</li><li>Bitcoins amount ' + data[i].totalBitcoins + '</li><li>Starting price: '+ data[i].price+'</ul></div><a type="button" class="btn btn-outline-primary" href="Bid.html?auction='+data[i].id+'&user='+userId+'&active=false">SEE MY BID</a></div></div>';
                $("#subastas").append(html);

            }
        }
    })


}


