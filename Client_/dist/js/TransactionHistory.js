var date = "23/3/2020";
var price = 18;
var bitcoins = "2";

$(document).ready(function () {
    $("#historial").append('<div style="column-count: 3">\n' +
        '                <li class="list-group-item list-group-item-action active" >Date</li>\n' +
        '                <li class="list-group-item list-group-item-action active">Number of Bitcoins</li>\n' +
        '                <li class="list-group-item list-group-item-action active">Price</li>\n' +
        '            </div>');
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



