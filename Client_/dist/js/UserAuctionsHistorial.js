var userId = "456456456";

$(document).ready(function () {
    getAuctionHistory();
});

function getAuctionHistory() {
    $.get("http://localhost:8080/api/users/"+userId+"/auctions?status=all", (data) => {

        for (i = 0; i < data.length; i++) {
            console.log(data[i]);
            var auctionStatus; 
            if(TDate(data[i].closeDate)){
                auctionStatus='</a><span class="badge badge-success active">Active</span>';
            }
            else{
                auctionStatus = '<span class="badge badge-danger active">Finished</span>';
            }
            
            html =  '<div class="col-lg-6 mb-4"><div class="card h-100"><div class="card-body"><h4 class="card-title"><a href="#">' + data[i].openingDate+ '</a>'+auctionStatus+'</h4><ul><li>Opening date: ' + data[i].openingDate +'</li><li> Closing date: '+data[i].closeDate+ '</li><li>Bitcoins amount ' + data[i].totalBitcoins + '</li><li>Starting price: '+ data[i].price+'</ul></div><a type="button" class="btn btn-outline-primary" href="Bid.html?auction='+data[i].id+'&user='+userId+'">SEE MY BID</a></div></div>';
            $("#subastas").append(html);

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

