<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/loginStyle.css" rel="stylesheet">
</head>
<body>


<center>
<form action="/login" method="post">
    <div class="imgcontainer">
        <img src="image/img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <label for="userName"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>

        <label for="passWord"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <button type="submit">Login</button>

    </div>


</form>
</center>
</body>
</html>
