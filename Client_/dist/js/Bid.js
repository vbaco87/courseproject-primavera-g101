var token = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYmFyYmVyYW5AZWR1LnRlY25vY2FtcHVzLmNhdCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDY3MzAzNjksImV4cCI6MTYwNzU1NDgwMH0.L7Kr5w9jM-uBifzSXGLWf4kwP-iwQjiRAfdOsUySnLZvfq76glwwpyZedyp-mNG5Xgk8VeT1Ijizs8QK91472w';

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
    $.ajax({
        headers: {'Authorization': token},
        url:  "http://localhost:8080/api/user/"+user+"/auction/"+auction+"/bid" ,
        async: false,
        type: "get",
        dataType: 'json',
        contentType: 'application/json',

        success: function (data) {
            $("#information").append('<ul><li>You bidded for ' +data.bitcoins+ '₿</li><li>You have bid ' +data.amount + ' €</li></ul>');
            console.log(data);
        },
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
