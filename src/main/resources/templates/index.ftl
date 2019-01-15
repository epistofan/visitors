<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
body {font-family: Arial, Helvetica, sans-serif;}

form {border: 0px solid #f1f1f1;

        margin: auto;


        }
form1 {border: 1px solid white;

        margin: auto;


        }

span.a {
  display: inline-block; /* the default for span */
  width: 150px;
  height: 50px;

  padding: 12px;


}


button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 50%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;

}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {

    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
h1 {
    color: #008CBA;
    text-align: center;
}
h2 {

    text-align: center;
}
p.serif {
    font-family: "Times New Roman", Times, serif;
    text-align: center;



}
table {
    width: 90%;
    border-spacing: 1px;
    margin: auto;
}
td {
    border: 1px solid white;
    border-collapse: collapse;

    text-align: center;
    padding: 8px;

}
th {
    border: 1px solid white;
    border-collapse: collapse;
    background-color: #99ddff;
    text-align: center;
    padding: 8px;

}



tr:nth-child(even) {
  background-color: #e6e6e6;

}

body {
    background-color: lightblue;

}
input[type=text], input[type=password] {

    width: 150px;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 1px solid gray;
    border-radius: 4px;
}

input[type=text] {
    width: 150px;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 1px solid gray;
    border-radius: 4px;
}
input[type=date] {
    width: 200px;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 1px solid gray;
    border-radius: 4px;
}
input[type=button], input[type=submit], input[type=reset] {
    background-color: #0080ff;
    border: none;
    color: white;
    padding: 16px 32px;
    text-decoration: none;
    margin: auto;
    cursor: pointer;
}

/* The alert message box */
.alert {
  padding: 20px;
  background-color: #f44336; /* Red */
  color: white;
  margin-bottom: 15px;
}

/* The close button */
.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

/* When moving the mouse over the close button */
.closebtn:hover {
  color: black;
}
.button {
    background-color: #0080ff;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.item1 { grid-area: header;}
.item2 { grid-area: menu; }
.item3 { grid-area: main; }
.item4 { grid-area: right; }
.item5 { grid-area: footer; }

.grid-container {
    display: grid;
    grid-template-areas:
            'header header header header header header'
            'menu main main main main right'
            'footer footer footer footer footer footer';
    grid-gap: 3px;
    background-color: lightgrey;
    padding: 10px;
    grid-template-rows: 200px auto;

}
<!--.grid-container > div {-->
    <!--background-color: aliceblue;-->
    <!--text-align: center;-->
    <!--padding: 20px 0;-->
    <!--font-size: 30px;-->

<!--}-->
 /*the container must be positioned relative:*/
.select {
  position: relative;
  font-family: Arial;
}
.select select {
  display: none; /*hide original SELECT element:*/
}
.select-selected {
  background-color: DodgerBlue;
}
/*style the arrow inside the select element:*/
.select-selected:after {
  position: absolute;
  content: "";
  top: 14px;
  right: 10px;
  width: 0;
  height: 0;
  border: 6px solid transparent;
  border-color: #fff transparent transparent transparent;
}
/*point the arrow upwards when the select box is open (active):*/
.select-selected.select-arrow-active:after {
  border-color: transparent transparent #fff transparent;
  top: 7px;
}
/*style the items (options), including the selected item:*/
<!--.select-items div,.select-selected {-->
  <!--color: #ffffff;-->
  <!--padding: 8px 16px;-->
  <!--border: 1px solid transparent;-->
  <!--border-color: transparent transparent rgba(0, 0, 0, 0.1) transparent;-->
  <!--cursor: pointer;-->
<!--}-->
/*style items (options):*/
.select-items {
  position: absolute;
  background-color: DodgerBlue;
  top: 100%;
  left: 0;
  right: 0;
  z-index: 99;
}
/*hide the items when the select box is closed:*/
.select-hide {
  display: none;
}
.select-items div:hover, .same-as-selected {
  background-color: rgba(0, 0, 0, 0.1);
}
/* Tooltip container */
.tooltip {
    position: relative;
    display: inline-block;
    border-bottom: 1px dotted black; /* If you want dots under the hoverable text */
}

/* Tooltip text */
.tooltip .tooltiptext {
    visibility: hidden;
    width: 120px;
    background-color: #555;
    color: #fff;
    text-align: center;
    padding: 5px 0;
    border-radius: 6px;

    /* Position the tooltip text */
    position: absolute;
    z-index: 1;
    bottom: 125%;
    left: 50%;
    margin-left: -60px;

    /* Fade in tooltip */
    opacity: 0;
    transition: opacity 0.3s;
}

/* Tooltip arrow */
.tooltip .tooltiptext::after {
    content: "";
    position: absolute;
    top: 100%;
    left: 50%;
    margin-left: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: #555 transparent transparent transparent;
}

/* Show the tooltip text when you mouse over the tooltip container */
.tooltip:hover .tooltiptext {
    visibility: visible;
    opacity: 1;
}
</style>
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
<div>

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
<div>
    <form action="/addVisitorOutTimeByOrderNumber" method="post">
        <h2>Atzīmet uz iziešanu</h2>

        <center>  <input type="text" name="orderNumber", required="true", placeholder="Nr.p.k.">
            <input type="password" name="password", required="true", placeholder="Parole">
<br>
            <input type="submit"> <input type="reset"></center>
    </form>

</div>
<div>
    <form action="/selectByDate" method="post">
        <h2>Meklet pec datuma</h2>



        <script>
if ('<#if response??>${response}</#if>'!= 0) {

  alert('<#if response??>${response}</#if>');
}
</script>

        <center> <input type="date" name="selectedDate", required="true">

            <br>
            <input type="submit"> <input type="reset"></center>
    </form>

</div>


</body>
</html>
