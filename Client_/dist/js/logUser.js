$(document).ready(function () {
    $("#submit").click(() => {

        var settings = {
            "url": "http://localhost:8080/login",
            "method": "POST",
            "timeout": 0,
            "data": JSON.stringify( {
                "username": $("#inputEmail").val(),
                "password": $("#inputPassword").val()
            }),
            "success": function (data, textStatus, request) {
                console.log('success: ',  request.getAllResponseHeaders());
            },
            "error": function (request, textStatus, errorThrown) {
                console.log('error: ' + textStatus + ' headers: ' + request.getAllResponseHeaders() + ' ErrorThrown: ' + errorThrown);
            }
        };

        $.ajax(settings).done(function (data, textStatus, request) {
            localStorage.setItem('token', request.getResponseHeader('authorization'))
            console.log('Done Response. Data: ', request.getResponseHeader('authorization'));
        });
        $(location).attr('href','index.html');
        return false;
    });
});

