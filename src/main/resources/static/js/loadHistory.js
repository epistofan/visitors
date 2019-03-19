function loadHistory(selectedDate){
    console.log(selectedDate.value);
        var d = new Date(selectedDate.value);
        console.log(d);

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

        var date = day + "." + m + "." + y;
        console.log(date);


        var request = new XMLHttpRequest();
        request.open('GET', 'http://192.168.40.100:8888/loginUser?date=' + date, true);

        request.onload = function () {
            try {

                var data = JSON.parse(this.response);
            } catch (err) {

            }
            if (data == null) {


                var para = document.createElement("p");
                var node = document.createTextNode(date);
                para.appendChild(node);
                var element = document.getElementById("history");
                element.appendChild(para);
            } else if (request.status >= 200 && request.status < 400) {
                data.reverse();

                var para = document.createElement("p");
                var node = document.createTextNode(date);
                para.appendChild(node);
                var element = document.getElementById("history");
                element.appendChild(para);
                var table = document.createElement("table");
                var historyElement = document.getElementById("history");
                historyElement.appendChild(table);

                var header = table.createTHead();
                var headerRow = header.insertRow(0);

                var headerCell1 = headerRow.insertCell(0);
                var headerCell2 = headerRow.insertCell(1);
                var headerCell3 = headerRow.insertCell(2);
                var headerCell4 = headerRow.insertCell(3);
                var headerCell5 = headerRow.insertCell(4);
                var headerCell6 = headerRow.insertCell(5);

                var headerCell7 = headerRow.insertCell(6);
                var headerCell8 = headerRow.insertCell(7);
                var headerCell9 = headerRow.insertCell(8);
                var headerCell10 = headerRow.insertCell(9);
                var headerCell11 = headerRow.insertCell(10);
                var headerCell12 = headerRow.insertCell(11);

                headerCell1.innerHTML = "Order";
                headerCell2.innerHTML = "in datums";
                headerCell3.innerHTML = "in laiks";
                headerCell4.innerHTML = "out datums";
                headerCell5.innerHTML = "out laiks";
                headerCell6.innerHTML = "vards";
                headerCell7.innerHTML = "uzvards";
                headerCell8.innerHTML = "caurlaides nr.";
                headerCell9.innerHTML = "firma";
                headerCell10.innerHTML = "atbildiga persona";
                headerCell11.innerHTML = "korpuss";
                headerCell12.innerHTML = "paraksts";


                for (i = 0; i < data.length; i++) {



                    var row = table.insertRow(1);
                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var cell3 = row.insertCell(2);
                    var cell4 = row.insertCell(3);
                    var cell5 = row.insertCell(4);
                    var cell6 = row.insertCell(5);
                    var cell7 = row.insertCell(6);
                    var cell8 = row.insertCell(7);
                    var cell9 = row.insertCell(8);
                    var cell10 = row.insertCell(9);
                    var cell11 = row.insertCell(10);
                    var cell12 = row.insertCell(11);
                    cell1.innerHTML = data[i].orderNumber;
                    cell2.innerHTML = data[i].inDateString;
                    cell3.innerHTML = data[i].inTimeString;
                    cell4.innerHTML = data[i].outDateString;
                    cell5.innerHTML = data[i].outTimeString;
                    cell6.innerHTML = data[i].firstName;
                    cell7.innerHTML = data[i].lastName;
                    cell8.innerHTML = data[i].cardNumber;
                    cell9.innerHTML = data[i].company;
                    cell10.innerHTML = data[i].responsiblePerson;
                    cell11.innerHTML = data[i].roomName;
                    cell12.innerHTML = data[i].responsiblePersonIdentity;

                }
            }
        };

        request.send();


}