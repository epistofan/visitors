<!DOCTYPE html>
<html>
<head>


    <link href="css/style.css" rel="stylesheet">
    <link href="css/popupStyle.css" rel="stylesheet">
    <link href="css/popup1Style.css" rel="stylesheet">

</head>
<body>

<center><h1>Laipni lūdzam!</h1></center>
<center><h2>${date}</h2></center>


<h2>K-1 dienas viesi</h2>

<div>

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

<!--<div>
    <form action="/addVisitorOutTimeByOrderNumber" method="post">
        <h2>Atzīmet uz iziešanu</h2>

        <center>  <input type="text" name="orderNumber", required="true", placeholder="Nr.p.k.">
            <input type="password" name="password", required="true", placeholder="Parole">
<br>
            <input type="submit"> <input type="reset"></center>
    </form>

</div>-->
<!--<div>
    <form action="/selectByDate" method="post">
        <h2>Meklēt pēc datuma</h2>

        <center> <input type="date" name="selectedDate", required="true">

            <br>
            <input type="submit"> <input type="reset"></center>
    </form>

</div>-->


<div class="sticky">

    <form action="/addVisitor" method="post">

        <br>
        <center>
            <span class="a"> <input type="text" name="firstName", required="true", placeholder="Vārds"></span>
            <span class="a"> <input type="text" name="lastName", required="true", placeholder="Uzvārds"></span>

            <span class="a"><input type="text" name="cardNumber", required="true", placeholder="Caurlaides nr."></span>

            <span class="a"><input type="text" name="company", required="true", placeholder="Firma"></span>
            <span class="a"><input type="text" name="responsiblePerson", required="true", placeholder="Atbildīga persona"></span>
            <span class="a"><input type="text" name="roomName", required="true", placeholder="Telpas nr."></span>

            <br>
            <input type="submit"> <input type="reset">
        </center>
    </form>

</div>
<script>
let div = document.createElement('div');
div.className = "alert";
if ('<#if response??>${response}</#if>'!= 0) {

div.innerHTML = '<#if response??>${response}</#if>';

document.body.appendChild(div);
setTimeout(() => div.remove(), 2000);
}
</script>

<button class="open-button1" onclick="openForm1()">Meklēt pēc datuma</button>
    <div class="form-popup1" id="myForm2">
        <form action="/selectByDate" method="post" class="form-container1">
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
<button class="open-button" onclick="openForm()">Atzīmet uz iziešanu</button>
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
<br>



</body>
</html>
