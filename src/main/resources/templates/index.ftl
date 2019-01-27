<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="css/style.css" rel="stylesheet">
    <link href="css/popupStyle.css" rel="stylesheet">
    <link href="css/selectByDate.css" rel="stylesheet">
    <link href="css/popup2Style.css" rel="stylesheet">

</head>
<body>

<center><h1>Laipni lūdzam!</h1></center>
<center><h2>${date}</h2></center>


<h2>K-1 dienas viesi</h2>

<div class="col-3" id="table">

    <table>

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

            <#list visitors as visitor>
        <tr>
            <td>${visitor.orderNumber}</td>
            <td>${visitor.inDateString}</td>
            <td>${visitor.inTimeString}</td>
            <td><#if visitor.outDateString??>${visitor.outDateString}</#if> </td>
            <td><#if visitor.outTimeString??>${visitor.outTimeString}</#if> </td>
            <td>${visitor.firstName}</td>
            <td>${visitor.lastName}</td>
            <td>${visitor.cardNumber}</td>
            <td>${visitor.company}</td>
            <td>${visitor.responsiblePerson}</td>
            <td>${visitor.roomName}</td>
            <td><#if visitor.responsiblePersonIdentity??>${visitor.responsiblePersonIdentity}</#if></td>
        </tr>
        </#list>

    </table>
</div>

<div class="sticky">
<center>
    <button class="open-button" onclick="openForm1()">Meklēt pēc datuma</button>
    <button class="open-button" onclick="openForm3()" id="button">Reģistrēt viesi</button>
    <button class="open-button" onclick="openForm()">Atzīmet uz iziešanu</button>
</center>
</div>

   <div class="form-popup" id="myForm2">
        <form action="/selectByDate" method="post" class="form-container">
            <h2>Meklēt pēc datuma</h2>

            <center> <input type="date" name="selectedDate", required="true">

                <br>
                <input type="submit">

                <button type="button" class="btn cancel" onclick="closeForm1()">Close</button></center>
        </form>
    </div>

<script>
function openForm1() {
  document.getElementById("myForm2").style.display = "block";
}

function closeForm1() {
  document.getElementById("myForm2").style.display = "none";
}
</script>
<br>

<div class="form-popup" id="myForm">
    <form action="/addVisitorOutTimeByOrderNumber" method="post" class="form-container">
        <h2>Atzīmet uz iziešanu</h2>

        <center>  <input type="text" name="orderNumber", required="true", placeholder="Nr.p.k.">
            <input type="password" name="password", required="true", placeholder="Parole">
            <br>
            <input type="submit">

            <button type="button" class="btn cancel" onclick="closeForm()">Close</button></center>
    </form>
</div>

<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>

<div class="form-popup" id="myForm3">
    <form action="/addVisitor" method="post" class="form-container">
        <h2>Reģistrēt viesi</h2>
<center>
        <span class="a"> <input type="text" name="firstName", required="true", placeholder="Vārds"></span>
        <span class="a"> <input type="text" name="lastName", required="true", placeholder="Uzvārds"></span>

        <span class="a"><input type="text" name="cardNumber", required="true", placeholder="Caurlaides nr."></span>

        <span class="a"><input type="text" name="company", required="true", placeholder="Firma"></span>
        <span class="a"><input type="text" name="responsiblePerson", required="true", placeholder="Atbildīga persona"></span>
        <span class="a"><input type="text" name="roomName", required="true", placeholder="Telpas nr."></span>

        <br>
        <input type="submit">
            <button type="button" class="btn cancel" onclick="closeForm3()">Close</button
</center>
    </form>
</div>

<script>
function openForm3() {
  document.getElementById("myForm3").style.display = "block";
}

function closeForm3() {
  document.getElementById("myForm3").style.display = "none";
}
</script>

<script>
let div = document.createElement('div');
div.className = "alert";
if ('<#if response??>${response}</#if>'!= 0) {

div.innerHTML = '<#if response??>${response}</#if>';

document.body.appendChild(div);
setTimeout(() => div.remove(), 2000);
}
</script>




<script>
function func() {

document.getElementById('button').style.backgroundColor = "#80aaff";
}

function func1() {
document.getElementById('button').style.backgroundColor = "gray";
}
setInterval(func, 1000);

setInterval(func1, 3000);

</script>

<script>
function printContent(el){

	var restorepage = document.body.innerHTML;
	var printcontent = document.getElementById(el).innerHTML;

	document.body.innerHTML = printcontent;
	window.print();
	document.body.innerHTML = restorepage;
}
</script>
<button onclick="printContent('table')">Print Content</button>


<footer>
    <center><p>@2019. Posted by: Hege Refsnes</p>
    <p>Contact information: <a href="mailto:someone@example.com">someone@example.com</a>.</p>
    </center>
</footer>


</body>
</html>
