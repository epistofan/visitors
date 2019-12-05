function getVisitors() {


    var app = document.getElementById('root');


    var container = document.createElement('div');
    container.setAttribute('class', 'container');

//app.appendChild(logo);
    app.appendChild(container);

    var d = new Date();

    var y = d.getFullYear();
    var m = d.getMonth() + 1;
    var day = d.getDate();
    m = checkDate(m);
    day = checkDate(day);

    function checkDate(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }

    let date = day + "." + m + "." + y;

    let token1 = $("#token").text();

    let request = new XMLHttpRequest();
    request.open('GET', 'http://10.10.10.100:8888/getUsers?date=' + date, true);
    request.setRequestHeader('Authorization', token1);

    request.send();


    request.onload = function () {
        try {
            // Begin accessing JSON data here
            var data = JSON.parse(this.response);
        } catch (err) {

        }
        if (data == null) {


            var para = document.createElement("p");
            var node = document.createTextNode("pagaidam neka nava...");
            para.appendChild(node);
            var element = document.getElementById("root");
            element.appendChild(para);
        } else if (request.status >= 200 && request.status < 400) {
            data.reverse();




        }


        addHeader();
    };


}

