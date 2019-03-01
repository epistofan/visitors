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
<script src="js/date.js"></script>


<h1 id="time"></h1>
<script src="js/time.js"></script>

<h1 id="accessPoint"></h1>

<script src="js/getAccessPoint.js"></script>

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

<div id="test"></div>

<div id="root"></div>

<script src="js/getVisitors.js"></script>



<div class="form-popup" id="myForm">
    <form id="addOutTime" class="form-container">
        <h2>Atzīmet uz iziešanu</h2>

        <center>  <input type="text" name="orderNumber", required="true", placeholder="Nr.p.k.">
            <input type="password" name="password", required="true", placeholder="Parole">
            <br>
            <input type="button" onclick="addOutTime()" value="Submit">

            <button type="button" class="btn cancel" onclick="closeForm()">Close</button></center>
    </form>
</div>
<script src="js/addOutTime.js"></script>
<script src="js/openForm.js"></script>



<script src="js/addVisitor.js"></script>

<div class="test" >
    <form action="/" method="get">
        <button class="open-button" type="submit" class="logout-button">Iziet</button>
    </form>
</div>

<br>
<div class="test" id="addVisitorButton">
    <button class="open-button" onclick="openAddVisitorForm()" id="button">Esmu atnacis!</button>
</div>
<div class="form-popup" id="addVisitorForm">
    <form class="form-container">
        <h2>Reģistrēt viesi</h2>

        <span class="a"> <input type="text" name="firstName" placeholder="Vārds"/></span>
        <span class="a"> <input type="text" name="lastName" placeholder="Uzvārds"/></span>

        <span class="a"><input type="text" name="cardNumber" placeholder="Caurlaides nr."/></span>

        <span class="a"><input type="text" name="company" placeholder="Firma"></span>
        <span class="a"><input type="text" name="responsiblePerson" placeholder="Atbildīga persona"/></span>
        <span class="a"><input type="text" name="roomName" placeholder="Telpas nr."/></span>

        <br>
        <input type="button" onclick="addVisitor(firstName, lastName, cardNumber, company, responsiblePerson, roomName )" value="Submit">
        <button type="button" class="btn cancel" onclick="closeAddVisitorForm()">Close</button>

    </form>
</div>
<script src="js/openAddVisitorForm.js"></script>

</body>

</html>