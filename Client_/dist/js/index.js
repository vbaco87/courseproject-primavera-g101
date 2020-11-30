var userName = "";
var surname = "";
var email = ""
var birthDate = "2000-05-21";
var gender = "famale";

var city = "";
var country = ""
var phone = ""
var address = "";

var userID = "123123123"
var token = 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYmFyYmVyYW5AZWR1LnRlY25vY2FtcHVzLmNhdCIsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJpYXQiOjE2MDY3MzAzNjksImV4cCI6MTYwNzU1NDgwMH0.L7Kr5w9jM-uBifzSXGLWf4kwP-iwQjiRAfdOsUySnLZvfq76glwwpyZedyp-mNG5Xgk8VeT1Ijizs8QK91472w';

$(document).ready(function () {

    getUser();
    addUserName();
    addUserSurname();
    addUserEmail();
    addUserBirthdayDate();
    addUserCity();
    addUserCountry();
    addUserPhone();
    addUserAddress();

});



function getUser() {
    var result = "";
    var url = "http://localhost:8080/api/users/" + userID;
    $.ajax
        ({
            async: false,
            headers: {'Authorization': token},
            url: url,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                result = data;
                console.log(data);
                userName = data.name;
                surname = data.secondName;
                email = data.email;

                city = data.city;
                country = data.country;
                phone = data.phoneNumber;
                address = data.homeAddress;
            }

        });
}


function updateUser() {
    var url = "http://localhost:8080/api/users/" + userID;
    var datos = {
        "name": $("#frist-name").val(),
        "secondName": $("#surname-name").val(),
        "email": "jbarberan@edu.tecnocampus.cat",
        "phoneNumber": $("#phone").val(),
        // "birthday": console.log(event.toLocaleDateString()),
        "country": $("#country").val(),
        "city": $("#city").val(),
        "homeAddress": $("#address").val()
    };

    $.ajax({
        async: false,
        headers: {'Authorization': token},
        type: "PUT", // la variable type guarda el tipo de la peticion GET,POST,..
        url: url, //url guarda la ruta hacia donde se hace la peticion
        dataType: 'json', // El tipo de datos esperados del servidor. Valor predeterminado: Intelligent Guess (xml, json, script, text, html).
        data: datos // data recive un objeto con la informacion que se enviara al servidor        
    })
}

function addUserName() {
    $("#userName").append('<label for="frist-name" class="text-muted">First Name</label> <input id="frist-name" type="text" class="form-control resume" placeholder="" value="' + userName + '"></input>');
}

function addUserSurname() {
    $("#surname").append('<label for="surname-name" class="text-muted">Surname</label><input id="surname-name" type="text" class="form-control resume" placeholder="" value="' + surname + '"></input>');
}

function addUserEmail() {
    $("#userEmail").append(' <label for="e-mail" class="text-muted">User log-in e-mail</label><input id="e-mail" type="email" class="form-control resume"placeholder="" value="' + email + '" disabled>');
}

function addUserBirthdayDate() {
    $("#userBirthday").append('<label for="date-of-birth" class="text-muted">Date Of Birth</label> <input id="date-of-birth" type="date" max="2000-01-01" class="form-control resume" placeholder="13-02-1999" value="' + birthDate + '">');
}

function addUserCity() {
    $("#userCity").append('<label for="city" class="text-muted">City</label><input id="city" type="text" class="form-control resume" placeholder="" value="' + city + '">');
}

function addUserCountry() {
    $("#userCountry").append('<label for="country" class="text-muted">Country</label><input id="country" type="text" class="form-control resume" placeholder="" value="' + country + '">');
}

function addUserPhone() {
    $("#userPhone").append('<label for="phone" class="text-muted">Phone</label><input id="phone" type="text" class="form-control resume" placeholder="" value="' + phone + '">');
}

function addUserAddress() {
    $("#userAddress").append('<label for="address" class="text-muted">Address</label><input id="address" type="text" class="form-control resume" placeholder="" value="' + address + '"></input>');
}
