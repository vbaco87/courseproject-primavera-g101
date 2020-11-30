var token = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYmFyYmVyYW5AZWR1LnRlY25vY2FtcHVzLmNhdCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDY3MzAzNjksImV4cCI6MTYwNzU1NDgwMH0.L7Kr5w9jM-uBifzSXGLWf4kwP-iwQjiRAfdOsUySnLZvfq76glwwpyZedyp-mNG5Xgk8VeT1Ijizs8QK91472w';

$(document).ready(function () {
    $("#submit").click(() => {
        $.ajax({
            async: false,
            headers: {'Authorization': token},
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