var creatorId=963963963;
var price;
var totalBitcoins;
var bitcoinsBroker;
var token = localStorage.getItem('token');

$(document).ready(function() {
    noDisplay();
    $.ajax({
        headers: {'Authorization': token},
        url: "http://localhost:8080/api/users/me/account",
        async: false,
        type: 'GET',
        crossDomain: true,
        dataType: 'json',
        success: function (data) {
            bitcoinsBroker = data["bitcoinBalance"];
            $("#nBitcoins").append('<th scope="col" id="nBitcoins">nBitcoins: '+parseFloat(bitcoinsBroker).toFixed(2)+'</th>');
        },
    });


    minDate();
    $("#closingDate").click(function(){
        updateClosingDate()
    });

    $("#openingDate").change(function(){
        updateClosingDate();
      });

     $("#submit").click(function(){
         noDisplay();
        price= $("#basePrice").val();
        totalBitcoins= $("#numberOfBitcoins").val();
        if(price >=0 && totalBitcoins >=0 ){
            if($("#exampleCheck1").prop('checked')){
                if(bitcoinsBroker>= totalBitcoins){
                    addAuction();
                    $("#SubmitOk").show();
                }else{
                    $("#SubmitNoBitcoins").show();
                }
            }else{
                $("#SubmitNotOkT").show();
            }
        }else{
            $("#SubmitNotOk").show();
        }
    });


});

function noDisplay(){
    $("#SubmitOk").css("display", "none");
    $("#SubmitNoBitcoins").css("display", "none");
    $("#SubmitNotOk").css("display", "none");
    $("#SubmitNotOkT").css("display", "none");
}

function validate()  {

};

function minDate(){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10){
            dd='0'+dd
        } 
        if(mm<10){
            mm='0'+mm
        } 

    today = yyyy+'-'+mm+'-'+dd;
    $("#openingDate").attr("min", today);
    $("#openingDate").attr("value", today);
    updateClosingDate();
}

function updateClosingDate(){
    var date = new Date(new Date($("#openingDate").val()).getTime()+1000*60*60);
        var dd = date.getDate() + 1;
        var mm = date.getMonth() +1; //January is 0!
        var yyyy = date.getFullYear();
        
        if(dd<10){
            dd='0'+dd
        } 
        if(mm<10){
            mm='0'+mm
        } 
        date = yyyy+'-'+mm+'-'+dd;

        $("#closingDate").attr("min", date);
        $("#closingDate").attr("value", date);
}

function addAuction(){
    var url = "http://localhost:8080/api/users/me/auctions";

    var datos = {
        "totalBitcoins": parseFloat(totalBitcoins),
        "price": parseFloat(price),
        "openingDate": $("#openingDate").val(),
        "closeDate": $("#closingDate").val(),
        "brokerId:" : creatorId
    };
    $.ajax({
        async: false,
        headers: {'Authorization':token},
        type:"POST",
        url:url,
        contentType: 'application/json',
        dataType: 'json',
        data:JSON.stringify(datos)

    })

}

