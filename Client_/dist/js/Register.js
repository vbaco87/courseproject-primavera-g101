var token = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYmFyYmVyYW5AZWR1LnRlY25vY2FtcHVzLmNhdCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDY3MzAzNjksImV4cCI6MTYwNzU1NDgwMH0.L7Kr5w9jM-uBifzSXGLWf4kwP-iwQjiRAfdOsUySnLZvfq76glwwpyZedyp-mNG5Xgk8VeT1Ijizs8QK91472w';

function registerNewUser() {

    if (checkInputValues())
        if ($("#inputPassword").val() === $("#inputConfirmPassword").val()) {

            var status;
            var type = getUserType();
            var url = "http://localhost:8080/api/users?"+type;
            var datos = {
                "name": $("#inputName").val(),
                "secondName": $("#inputSurname").val(),
                "email": $("#inputEmail").val(),
                "password": $("#inputPassword").val(),
                "phoneNumber": $("#inputPhoneNumber").val(),
                //  "birthday": $("#inputBirthday").val(),
                "country": $("#inputCounty").val(),
                "city": $("#inputCity").val(),
                "homeAddress": $("#inputHomeAddress").val(),
                
            };

            $.ajax({
                async: false,
                headers: {'Authorization': token},
                type: "POST", // la variable type guarda el tipo de la peticion GET,POST,..
                url: url, //url guarda la ruta hacia donde se hace la peticion
                dataType: 'json', // El tipo de datos esperados del servidor. Valor predeterminado: Intelligent Guess (xml, json, script, text, html).
                data: datos, // data recive un objeto con la informacion que se enviara al servidor        
                success: function (textStatus, jqXHR) {
                    //console.log(textStatus + ": " + jqXHR.status);
                    status = jqXHR.status;
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    //console.log(textStatus + ": " + jqXHR.status + " " + errorThrown);
                    status = jqXHR.status;
                }
            })
            if(status/100 == 2){
                window.open("../index.html");
            }
            else{
                $("#userError").css("display", "block");
            }
        }
}

function checkInputValues() {
    return $("#inputPassword").val() != "" && $("#inputName").val() != "" && $("#inputSurname").val() != "" && $("#inputEmail").val() != "" && $("#inputPassword").val() != "" && $("#inputPhoneNumber").val() != "" && $("#inputCounty").val() != "" && $("#inputCity").val() != "" && $("#inputHomeAddress").val() != "";
}

function getUserType() {
    var result = -1;
    $('.form-check-input:checked').each(
        function () {
            var userAnswer = $(this).val();
            if (userAnswer.charAt(userAnswer.length - 1) === "1")
                result = 1;
            else
                result = 2;
        }
    );
    return result;
}