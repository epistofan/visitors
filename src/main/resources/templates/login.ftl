<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/loginStyle.css" rel="stylesheet">
</head>
<body>

<script src="js/login.js"></script>


    <form class="login">
        <h1 class="login-title">Sveiki!</h1>
        <input type="text" class="login-input" placeholder="Lietotājvārds" autofocus name="username" required>
        <input type="password" class="login-input" placeholder="Parole" name="password" required>


        <button type="button" class="login-button" onclick="login(username, password)">Aiziet!</button>

        <p class="login-lost"><a href="">sazināties</a></p>
    </form>


</body>
</html>
