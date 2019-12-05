<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Visitors App</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="css/style2.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/popupStyle.css" rel="stylesheet">


</head>

<body>
<p hidden id="token"></p>
<div class="icon-bar">
    <a class="active" href="#">Sakums</a>
    <a href="#" id="openF" onclick="openAddVisitorForm()">Jauns Viesis</a>

        <div class="test"><p id="date"></p>
      <p id="accessPoint">K1</p>
       <p id="time"></p>
        </div>

    <a href="#about">Vesture</a>
    <a href="/">Iziet</a>
</div>





<div>

<#--<table id="myTable">
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

</table>-->

    <div id="blocks" class="blocks">

    </div>
</div>
    <div class="form-popup" id="addVisitorForm">
        <h2>Reģistrēt viesi</h2>
        <div class="form-container">



                <input type="text" id="firstName" onkeypress="checkForm()" placeholder="Vārds" autocomplete="off">

              <input type="text" id="lastName" onkeypress="checkLastName()" placeholder="Uzvārds" autocomplete="off">

              <input type="text" id="cardNumber" onkeypress="checkForm()" placeholder="Caurlaides nr." autocomplete="off">

                <input type="text" id="company" onkeypress="checkForm()" placeholder="Firma" autocomplete="off">

                <input type="text" id="responsiblePerson" onkeypress="checkForm()" placeholder="Atbildīga persona" autocomplete="off">
                <input type="text" id="roomName" onkeypress="checkForm()" placeholder="Telpas nr." autocomplete="off">
<div id="buttons">
            <button class="cancelbtn" onclick="addVisitor()">Ok</button>
            <button class="cancelbtn" onclick="closeAddVisitorForm()">Close</button>
        </div>
        </div>



    </div>


<div id="test"></div>

<div id="root"></div>


<div class="form-popup" id="myForm">
    <form id="addOutTime" class="form-container">
        <h2>Atzīmet uz iziešanu</h2>

       <input type="text" name="orderNumber", required="true", placeholder="Nr.p.k.">
            <input type="password" name="password", required="true", placeholder="Parole">
            <br>
        <span><button type="button" class="btn cancel" onclick="addOutTime()" >Ok</button></span>

            <span><button type="button" class="btn cancel" onclick="closeForm()">Close</button></span>
    </form>
</div>



<#--<br>



<br>


<div id="page2" class="page-padding"">
    <a id="about" class="smooth"></a>
<div style="padding-top: 70px">
    <form class="form-container">
        <h2>Meklēt pēc datuma</h2>

        <input type="date" name="selectedDate", required="true">

        <br>
        <button type="button" class="btn cancel" onclick="loadHistory(selectedDate)">Ok</button>

        <button type="button" class="btn cancel" onclick="clearHistory()">Dzest</button>
    </form>
</div>
<div id="history"></div>-->



</body>

</html>