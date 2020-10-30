var userName = "Judith";
var surname = "Barberan";
var email = "jbarberan@edu.tecnocampus.cat"
var birthdate = "21/05/2000";
var gender = "famale";

var city = "Barcelona";
var country = "Espanya"
var phone = "601689422"
var address = "c/ espronceda 6";

$(document).ready(function () {
    addUserName();
    addUserSurname();
    addUserEmail();
    addUserCity();
    addUserCountry();
    addUserPhone();
    addUserAddress();

});

function addUserName() {
    $("#userName").append('<label for="frist-name" class="text-muted">First Name</label> <input id="frist-name" type="text" class="form-control resume" placeholder="" value="' + userName + '"></input>');
}

function addUserSurname() {
    $("#surname").append('<label for="surname-name" class="text-muted">Surname</label><input id="surname-name" type="text" class="form-control resume" placeholder="" value="' + surname + '"></input>');
}

function addUserEmail() {
    $("#userEmail").append(' <label for="e-mail" class="text-muted">User log-in e-mail</label><input id="e-mail" type="email" class="form-control resume"placeholder="" value="' + email + '" disabled>');
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
