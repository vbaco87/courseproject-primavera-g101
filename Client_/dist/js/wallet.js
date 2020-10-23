
var euros = 18;
var bitcoins = 2;
var locked= 5;
var usable = euros - locked;

$(document).ready(function () {
    addHTML();

});

function addHTML() {

    $("#Bitcoin").append(' <div class="media" >    <h2 class="mr-3">' + bitcoins + '₿    </h2>    <div class="media-body">        <h5 class="mt-0">Bitcoins</h5>        The amount of bitcoins you have in your account is ' + bitcoins + '₿.    </div></div>');
   // $("#Euro").append(' <div class="media">  <ul>  <h2 class="mr-3">' + euros + '€ Total   </h2>  <h3 class="mr-3">' + locked + '€  locked   </h3> <h3 class="mr-3">' + usable + '€  usable  </h3>  </ul> <div class="media-body">        <h5 class="mt-0">Euros</h5>      The total amount of euros you have in your account is ' + euros + '€, of which:   <div> You have ' + locked +' locked €.</div>    <div> You have ' + usable +' usable €.</div> </div> </div>');
    $("#Euro").append('<div> <div class="media">  <ul>  <h2 class="mr-3">' + euros + '€    </h2>  </ul> <div class="media-body">        <h5 class="mt-0">Euros</h5>      The total amount of euros you have in your account is ' + euros + '€, of which:    </div> </div>'
    + '<div> <div class="media">  <ul>  <h3 class="mr-3">' + usable + '€    </h3> </ul> <div class="media-body">        <h5 class="mt-0">Usable</h5>    You have ' + usable +' usable €. </div> </div>  </div>   '
    +    '<div> <div class="media">  <ul> <h3 class="mr-3">' + locked + '€     </h3> </ul> <div class="media-body">        <h5 class="mt-0">Locked</h5>      You have ' + locked +' locked €. </div> </div></div> '
   );
}

