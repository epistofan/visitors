function logout(){

    var logoutRequest = new XMLHttpRequest();
    logoutRequest.open('GET', 'http://10.10.10.100:8888', true);



    logoutRequest.send();
}