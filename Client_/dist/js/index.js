var userName = "";
var surname = "";
var email = ""
var birthDate = "2000-05-21";
var gender = "famale";

var city = "";
var country = ""
var phone = ""
var address = "";


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
    var url = "http://localhost:8080/api/users/123123123";
    $.ajax
        ({
            async: false,
            headers: {'Access-Control-Allow-Origin': '*'},
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
                country =data.country;
                phone = data.phoneNumber;
                address = data.homeAddress;
            }
            
        });   
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
    $("#userBirthday").append('<label for="date-of-birth" class="text-muted">Date Of Birth</label> <input id="date-of-birth" type="date" max="2000-01-01" class="form-control resume" placeholder="13-02-1999" value="'+birthDate+'">');
}

function addUserCity() {
    $("#userCity").append('<label for="e-mail" class="text-muted">City</label><input id="e-mail" type="text" class="form-control resume" placeholder="" value="'+city+'">');
}

function addUserCountry() {
    $("#userCountry").append('<label for="e-mail" class="text-muted">Country</label><input id="e-mail" type="text" class="form-control resume" placeholder="" value="'+country+'">');
}

function addUserPhone() {
    $("#userPhone").append('<label for="phone" class="text-muted">Phone</label><input id="phone" type="text" class="form-control resume" placeholder="" value="'+phone+'">');
}

function addUserAddress() {
    $("#userAddress").append('<label for="text" class="text-muted">Address</label><input id="address" type="text" class="form-control resume" placeholder="" value="'+address+'"></input>');
}
