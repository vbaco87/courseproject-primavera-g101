
$(document).ready(function() {
    minDate();
    $("#closingDate").click(function(){
        updateClosingDate()
    });

    $("#openingDate").change(function(){
        updateClosingDate();
      });


});

function addAuction() {
    console.log("right now i do nothing");
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

