var href = "Auction.html";

$(document).ready(function () {
    getActiveAuctions();
});

function getActiveAuctions() {
    $.get("http://localhost:8080/api/auctions?status=active", (data) => {

        for (i = 0; i < data.length; i++) {
            console.log(data[i]);
            html =  '<div class="col-lg-6 mb-4"><div class="card h-100"><div class="card-body"><h4 class="card-title"><a href="' + href + '">' + data[i].openingDate+ '</a><span class="badge badge-success active">Active</span></h4><ul><li>Opening date: ' + data[i].openingDate +'</li><li> Closing date: '+data[i].closeDate+ '</li><li>Bitcoins amount ' + data[i].totalBitcoins + '</li><li>Starting price: '+ data[i].price+'</ul></div><a type="button" class="btn btn-outline-primary" href="' + href + '">See more</a></div></div>';
            
            
            $("#subastas").append(html);

        }

    });
}


