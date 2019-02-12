<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/loginStyle.css" rel="stylesheet">
</head>
<body>


<center>
<!--<form action="/login" method="post">
    <div class="imgcontainer">
        <img src="image/img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <button type="submit">Login</button>

    </div>


</form>-->
    <form class="login" action="/login" method="post">
        <h1 class="login-title">Sveiki!</h1>
        <input type="text" class="login-input" placeholder="Lietotājvārds" autofocus name="username" required>
        <input type="password" class="login-input" placeholder="Parole" name="psw" required>
        <input type="submit" value="Aiziet!" class="login-button">
        <p class="login-lost"><a href="">sazināties</a></p>
    </form>

</center>
</body>
</html>
