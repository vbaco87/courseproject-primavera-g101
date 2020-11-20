

$(document).ready(function () {
    getBidStatus(getParameterByName('active'));
    getBid(getParameterByName('user'),getParameterByName('auction'), );
});
//Bid.html?auction=1&user=456456456


function getBidStatus(active) {
    if(active== "true"){
        $("#status").append('<h1 id="activeTab">Bid information <span class="badge badge-success mt-4">Active</span></h1>');
    }
    else{
        $("#status").append('<h1 id="activeTab">Bid information <span class="badge badge-danger mt-4">Finished</span></h1>');
    }
}
function getBid(user, auction){
    $.get("http://localhost:8080/api/user/"+user+"/auction/"+auction+"/bid", (data) => {

        $("#information").append('<ul><li>You bidded for ' +data.bitcoins+ '₿</li><li>You have bid ' +data.amount + ' €</li></ul>');
            console.log(data);
            

    });

}

function getParameterByName(name, url = window.location.href) {
    name = name.replace(/[\[\]]/g, '\\$&');
    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}