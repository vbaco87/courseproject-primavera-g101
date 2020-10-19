var date = "23/3/2020";
var price = 18;
var bitcoins = "2";

$(document).ready(function () {
    addHTML();
    addHTML();
    addHTML();
    addHTML();
});

function addHTML() {
    $("#historial").append('<div style="column-count: 3">\n' +
        '        <li class="list-group-item" >'+date+'</li>\n' +
        '        <li class="list-group-item">'+bitcoins+'</li>\n' +
        '    <li class="list-group-item">'+price+' euros</li>\n' +
        '        </div>');
}



