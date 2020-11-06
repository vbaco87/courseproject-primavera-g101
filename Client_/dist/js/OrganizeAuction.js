var creatorId=963963963;
var price;
var totalBitcoins;
$(document).ready(function() {
    minDate();
    $("#closingDate").click(function(){
        updateClosingDate()
    });

    $("#openingDate").change(function(){
        updateClosingDate();
      });

    $("#submit").click(function(){
        price= $("#basePrice").val();
        totalBitcoins= $("#numberOfBitcoins").val();
        if(price >0.0 && totalBitcoins > 0.0 ){
            if($("#exampleCheck1").prop('checked')){
                addAuction();
                $("#SubmitOk").show();
            }else{
                $("#SubmitNotOkT").show();
            }
        }else{
            $("#SubmitNotOk").show();
        }
    });

});


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
    var url = "http://localhost:8080/api/auction/"+creatorId;
    var datos = {
        "totalBitcoins": parseFloat(totalBitcoins),
        "price": parseFloat(price),
        "openingDate": $("#openingDate").val(),
        "closeDate": $("#closingDate").val()
    };
    $.ajax({
        async: false,
        headers: {'Access-Control-Allow-Origin': '*'},
        type:"POST",
        url:url,
        contentType: 'application/json',
        dataType: 'json',
        data:JSON.stringify(datos)
    })
}
