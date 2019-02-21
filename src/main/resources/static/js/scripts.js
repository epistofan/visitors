const app = document.getElementById('root');

//const logo = document.createElement('img');
//logo.src = 'image/img_avatar2.png';

const container = document.createElement('div');
container.setAttribute('class', 'container');

//app.appendChild(logo);
app.appendChild(container);

var request = new XMLHttpRequest();
request.open('GET', 'http://192.168.40.100:8888/loginUser', true);

request.onload = function () {
try{
  // Begin accessing JSON data here
  var data = JSON.parse(this.response);
  }catch(err){

  }
  if (data==null){


      var para = document.createElement("p");
      var node = document.createTextNode("pagaidam neka nava...");
      para.appendChild(node);
      var element = document.getElementById("root");
      element.appendChild(para);
        }

  else if (request.status >= 200 && request.status < 400) {
    data.forEach(visitor => {

          var table = document.getElementById("myTable");
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
          cell1.innerHTML = visitor.orderNumber;
          cell2.innerHTML = visitor.inDateString;
          cell3.innerHTML = visitor.inTimeString;
          cell4.innerHTML = visitor.outDateString;
          cell5.innerHTML = visitor.outTimeString;
          cell6.innerHTML = visitor.firstName;
          cell7.innerHTML = visitor.lastName;
           cell8.innerHTML = visitor.cardNumber;
          cell9.innerHTML = visitor.company;
          cell10.innerHTML = visitor.responsiblePerson;
          cell11.innerHTML = visitor.roomName;
          cell12.innerHTML = visitor.responsiblePersonIdentity;

        });
  }
}

request.send();