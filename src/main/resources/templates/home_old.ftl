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
    <a class="active" href="#"><i class="fa fa-home"></i></a>
    <a href="#about"><i class="fa fa-search"></i></a>
    <a href="#" id="openF" onclick="openAddVisitorForm()"><i class="fa fa-user-plus"></i></a>
   
    <a href="/"><i class="fa fa-sign-out"></i></a>
</div>

<div class="icon-bar">
    <span class="a" id="date"></span>
    <span class="b" id="accessPoint"></span>
    <span class="a" id="time"></span>
</div>



<div id="page1" style="overflow-x:auto;" class="page-padding">

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
    <div class="form-popup" id="addVisitorForm">
        <h2>Reģistrēt viesi</h2>
        <table class="form-container">
            <tr>


                <th>   <input type="text" id="firstName" onkeypress="checkForm(firstName)" placeholder="Vārds"/></th>

                <th><input type="text" id="lastName" onkeypress="checkLastName(lastName)" placeholder="Uzvārds"/></th>

                <th> <input type="text" id="cardNumber" onkeypress="checkForm(cardNumber)" placeholder="Caurlaides nr."/></th>

                <th>  <input type="text" id="company" onkeypress="checkForm(company)" placeholder="Firma"></th>

                <th> <input type="text" id="responsiblePerson" onkeypress="checkForm(responsiblePerson)" placeholder="Atbildīga persona"/></th>
                <th><input type="text" id="roomName" onkeypress="checkForm(roomName)" placeholder="Telpas nr."/></th>


            </tr>
        </table>
        <div id="buttons">
       <button type="button" class="cancelbtn" onclick="addVisitor()">Ok</button>
        <button type="button" class="cancelbtn" onclick="closeAddVisitorForm()">Close</button>
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



<br>



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
<div id="history"></div>
</div>


</body>

</html>