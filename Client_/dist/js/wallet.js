
var euros;
var bitcoins;
var locked;
var usable;
var accountId = 963963963;
var token = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYmFyYmVyYW5AZWR1LnRlY25vY2FtcHVzLmNhdCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDY3MzAzNjksImV4cCI6MTYwNzU1NDgwMH0.L7Kr5w9jM-uBifzSXGLWf4kwP-iwQjiRAfdOsUySnLZvfq76glwwpyZedyp-mNG5Xgk8VeT1Ijizs8QK91472w';


$(document).ready(function () {
    $.ajax({

        headers: {'Authorization': token},
        url: "http://localhost:8080/api/users/" + accountId+"/account",
        async: false,
        type: 'GET',
        crossDomain: true,
        dataType: 'json',
        success: function (data) {
            euros = data.euroBalance;
            bitcoins = data.bitcoinBalance;
            locked = data.blockedEuros;
            usable = euros - locked;
            usable = usable.toFixed(2);

        },
        //error: function() { alert('Failed!'); },

    });

    addHTML();


});

function addHTML() {

    $("#Bitcoin").append('<div class="media" ><h2 class="mr-3">' + bitcoins + '₿</h2><div class="media-body"><h5 class="mt-0">Bitcoins</h5> The amount of bitcoins you have in your account is ' + bitcoins + '₿.</div></div>');
  
    $("#Euro").append( '<div class="media">   <h2 class="mr-3">' + euros + '€ </h2><div class="media-body"> <h5 class="mt-0">Euros</h5> The total amount of euros you have in your account is ' + euros + '€, of which:  </div> </div>  ');
    $("#Usable").append('<div class="media">  <ul> <h2 class="mr-3">' + usable + '€ </h2></ul> <div class="media-body">  <h5 class="mt-0">Usable</h5> You have ' + usable +' usable €.</div>   </div>  ' );
    $("#Locked").append('<div class="media">  <ul> <h2 class="mr-3">' + locked + '€ </h2> </ul> <div class="media-body"><h5 class="mt-0">Locked</h5> You have ' + locked +' locked €.</div></div> ' );
  
}

