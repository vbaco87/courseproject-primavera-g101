var date = "23/3/2020";
var price = 18;
var bitcoins = "2";
var commission = 1.8;

$(document).ready(function () {
    $("#commissions").append('<div style="column-count: 4">\n' +
        '        <li class="list-group-item list-group-item-action active" >Date</li>\n' +
        '        <li class="list-group-item list-group-item-action active" >Commission</li>\n' +
        '        <li class="list-group-item list-group-item-action active">Number of Bitcoins</li>\n' +
        '    <li class="list-group-item list-group-item-action active">Price</li>\n' +
        '        </div>');
    addHTML();
    addHTML();
    addHTML();
    addHTML();


});

function addHTML() {
    $("#commissions").append('<div style="column-count: 4">\n' +
        '        <li class="list-group-item" >'+date+'</li>\n' +
        '        <li class="list-group-item">'+commission+' euros</li>\n' +
        '        <li class="list-group-item">'+bitcoins+'</li>\n' +
        '    <li class="list-group-item">'+price+' euros</li>\n' +
        '        </div>');
}



