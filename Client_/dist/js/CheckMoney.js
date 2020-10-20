
var euros = 18;
var bitcoins = 2;


$(document).ready(function () {
    addHTML();

});

function addHTML() {

    $("#Bitcoin").append(' <div class="media" >    <h2 class="mr-3">' + bitcoins + '₿    </h2>    <div class="media-body">        <h5 class="mt-0">Bitcoins</h5>        The amount of bitcoins you have in your account is ' + bitcoins + '₿.    </div></div>');
    $("#Euro").append(' <div class="media">    <h2 class="mr-3">' + euros + '€    </h2>    <div class="media-body">        <h5 class="mt-0">Euros</h5>      The amount of euros you have in your account is ' + euros + '€.    </div></div>');
}

