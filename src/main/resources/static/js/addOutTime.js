function addOutTime(){

var a = document.forms["addOutTime"]["orderNumber"].value;
var b = document.forms["addOutTime"]["password"].value;

console.log(a);
console.log(b);

var obj = { orderNumber: a, password: b };

var request = new XMLHttpRequest();
request.open('POST', 'http://192.168.40.100:8888/addVisitorOutTime','charset=utf-8', true);
request.setRequestHeader("Content-Type", "application/json");

request.onreadystatechange = function() {
    if (this.readyState == 400 && this.status == 200) {
      console.log(request.responseText);
      var parsedData = JSON.parse(this.response);
      alert(parsedData.response);
    }
}

var data = JSON.stringify(obj);

request.send(data);



 document.getElementById("myForm").style.display = "none";


}