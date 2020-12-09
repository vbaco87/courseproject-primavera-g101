$(document).ready(function () {
    $("#submit").click(() => {

        var settings = {
            "url": "http://localhost:8080/login",
            "async": false,
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
                $("#password").show();
            }
        };

        $.ajax(settings).done(function (data, textStatus, request) {
            localStorage.setItem('token', request.getResponseHeader('authorization'))
            console.log('Done Response. Data: ', request.getResponseHeader('authorization'));
        });
        if(localStorage.getItem('token')!=null)
            $(location).attr('href','index.html');
        return false;
    });
});

