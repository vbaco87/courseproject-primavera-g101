function registerNewUser() {

    if (checkInputValues())
        if ($("#inputPassword").val() === $("#inputConfirmPassword").val()) {

            var type = getUserType();
            console.log(type);
            var url = "http://localhost:8080/api/users";
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
                "userType": parseInt(type)
            };

            $.ajax({
                async: false,
                headers: { 'Access-Control-Allow-Origin': '*' },
                type: "POST", // la variable type guarda el tipo de la peticion GET,POST,..
                url: url, //url guarda la ruta hacia donde se hace la peticion
                dataType: 'json', // El tipo de datos esperados del servidor. Valor predeterminado: Intelligent Guess (xml, json, script, text, html).
                data: datos // data recive un objeto con la informacion que se enviara al servidor        
            })            
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