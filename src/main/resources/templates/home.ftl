<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Visitors App</title>

    <link href="https://fonts.googleapis.com/css?family=Dosis:400,700" rel="stylesheet">
    <link href="css/style2.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/popupStyle.css" rel="stylesheet">
    <link href="css/popup2Style.css" rel="stylesheet">
</head>

<body onload="startTime()">
<h1 id="demo"></h1>
<script>

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

</script>


<h1 id="time"></h1>
<script>
function startTime() {
  var today = new Date();
  var h = today.getHours();
  var m = today.getMinutes();
  var s = today.getSeconds();
  // add a zero in front of numbers<10
  m = checkTime(m);
  s = checkTime(s);
  document.getElementById("time").innerHTML = h + ":" + m + ":" + s;
  var t = setTimeout(function(){ startTime() }, 500);
}

function checkTime(i) {
  if (i < 10) {
    i = "0" + i;
  }
  return i;
}
</script>


<div style="overflow-x:auto;" >

<table id="myTable">
    <tr>
        <th>Nr.p.k.</th>
        <th>Ienākšanas datums</th>
        <th>Ienākšanas laiks</th>
        <th>Iziešanas datums</th>
        <th>Iziešanas laiks</th>
        <th>Vārds</th>
        <th>Uzvārds</th>
        <th>Caurlaides nr.</th>
        <th>Firma</th>
        <th>Atbildīga persona</th>
        <th>Telpas nr.</th>
        <th>Paraksts</th>
    </tr>

</table>
</div>

<div id="root"></div>

<script src="js/scripts.js"></script>



<div class="form-popup" id="myForm">
    <form action="/addVisitorOutTime" method="post" class="form-container">
        <h2>Atzīmet uz iziešanu</h2>

        <center>  <input type="text" name="orderNumber", required="true", placeholder="Nr.p.k.">
            <input type="password" name="password", required="true", placeholder="Parole">
            <br>
            <input type="submit">

            <button type="button" class="btn cancel" onclick="closeForm()">Close</button></center>
    </form>
</div>
<script src="js/openForm.js"></script>
</body>

</html>