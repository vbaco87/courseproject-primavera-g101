$(document).ready(function () {
    $("#submit").click(() => {
        $.ajax({
            async: false,
            headers: {'Access-Control-Allow-Origin': '*'},
            type:"POST",
            url:"http://localhost:8080/login",
            contentType: 'application/json',
            dataType: 'json',
            data:JSON.stringify( {
                "username": $("#inputEmail").val(),
                "password": $("#inputPassword").val()
            }),
            success : function(json) {
                //$('<h1/>').text(json.title).appendTo('body');
                //$('<div class="content"/>').html(json.html).appendTo('body');
                alert('Todo bien');
            },

            error : function(xhr, status) {
                alert('Disculpe, existió un problema ='+$("#inputEmail").val()+"/"+$("#inputPassword").val());
            }
        })
    });
});