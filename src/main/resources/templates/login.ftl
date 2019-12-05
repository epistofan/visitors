<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/loginStyle.css" rel="stylesheet">
    <script src="js/addOutTime.js"></script>
    <script src="js/openForm.js"></script>
    <script src="js/clearHistory.js"></script>
    <script src="js/loadHistory.js"></script>
    <script src="js/openAddVisitorForm.js"></script>
    <script src="js/addVisitor.js"></script>
    <script src="js/checkForm.js"></script>
    <script src="js/getVisitors.js"></script>
    <script src="js/time.js"></script>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
</head>
<body>

<script src="js/login.js"></script>


    <form class="login" id="loginForm">
        <h1 class="login-title">Sveiki!</h1>
        <input type="text" class="login-input" placeholder="Lietotājvārds" autofocus name="username" required autocomplete="off">
        <input type="password" class="login-input" placeholder="Parole" name="password" required autocomplete="off">


        <button type="button" class="login-button" onclick="login(username, password)">Aiziet!</button>

        <p class="login-lost"><a href="">sazināties</a></p>
    </form>


</body>
</html>
