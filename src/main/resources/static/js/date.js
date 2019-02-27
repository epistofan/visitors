var d = new Date();
var y = d.getFullYear();
var m = d.getMonth()+1;
var day = d.getDate();
m = checkDate(m);
day = checkDate(day);

function checkDate(i) {
  if (i < 10) {
    i = "0" + i;
  }
  return i;
  }

document.getElementById("demo").innerHTML = day+"."+m+"."+y;