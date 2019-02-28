

var app = document.getElementById('root');

//const logo = document.createElement('img');
//logo.src = 'image/img_avatar2.png';

var container = document.createElement('div');
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
    data.reverse();
    for(i=0; i<data.length; i++){


   // var para = document.createElement("p");
    //para.setAttribute("class", "serif");
    //var node = document.createTextNode(data[i].orderNumber +" "+ data[i].inDateString + " "+ data[i].inTimeString+" "+ data[i].outDateString+" "+ data[i].outTimeString +" "+ data[i].firstName+" "+ data[i].lastName+" "+ data[i].cardNumber+" "+ data[i].company+" "+ data[i].responsiblePerson+" "+ data[i].roomName+" "+ data[i].responsiblePersonIdentity);
    //para.appendChild(node);
      //var element = document.getElementById("test");
      //element.appendChild(para);
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

