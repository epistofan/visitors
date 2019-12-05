function login(username, password){
let token;
let a = username.value;
let b = password.value;

console.log(a);
console.log(b);

let obj = { username: a, password: b };




let loginRequest = new XMLHttpRequest();
    loginRequest.open('POST', 'http://10.10.10.100:8888/login',true);
    loginRequest.setRequestHeader("Content-Type", "application/json");
    loginRequest.setRequestHeader('Authorization', username.value);

    loginRequest.setRequestHeader('Authorization', password.value);
//let data = JSON.stringify(obj);

    loginRequest.send();

   loginRequest.onload = function () {
        try {


            let tkn = loginRequest.getResponseHeader("Authorization");


            document.getElementsByTagName("html")[0].innerHTML = "";
            document.getElementsByTagName("html")[0].innerHTML = loginRequest.response;
          $("#token").text(tkn);


            startTime();
getVisitors();


        }catch(err){
        }


    };



}