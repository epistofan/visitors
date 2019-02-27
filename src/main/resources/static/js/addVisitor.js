function addVisitor(firstName, lastName, cardNumber, company, responsiblePerson, roomName){
var f = firstName.value;

console.log(f);


var obj = { firstName: firstName.value, lastName: lastName.value, cardNumber: cardNumber.value, company: company.value, responsiblePerson: responsiblePerson.value, roomName:roomName.value };

var addVisitorRequest = new XMLHttpRequest();
addVisitorRequest.open('POST', 'http://192.168.40.100:8888/addVisitor','charset=utf-8', true);
addVisitorRequest.setRequestHeader("Content-Type", "application/json");

addVisitorRequest.onreadystatechange = function() {
    if (addVisitorRequest.status >= 200 && addVisitorRequest.status < 400) {
      console.log(addVisitorRequest.responseText);
      try{
      var parsedData = JSON.parse(this.response);
      }catch(err){}

         }

}
var data = JSON.stringify(obj);

addVisitorRequest.send(data);


var para = document.createElement("p");
    var node = document.createTextNode(parsedData.visitorId);
    para.appendChild(node);
      var element = document.getElementById("test");
      element.appendChild(para);


 document.getElementById("addVisitorForm").style.display = "none";


}