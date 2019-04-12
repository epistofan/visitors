function login(username, password){
let token;
let a = username.value;
let b = password.value;

console.log(a);
console.log(b);

let obj = { username: a, password: b };

let loginRequest = new XMLHttpRequest();
    loginRequest.open('POST', 'http://192.168.40.100:8888/login','charset=utf-8', true);
    loginRequest.setRequestHeader("Content-Type", "application/json");
    loginRequest.setRequestHeader('Authorization', username.value);

    loginRequest.setRequestHeader('Authorization', password.value);
let data = JSON.stringify(obj);

    loginRequest.send(data);

    loginRequest.onload = function () {
        try {
            // Begin accessing JSON data here
            token = JSON.parse(this.response);
            console.log(token);
                console.log(token.token);



        }catch(err){
        }


    };



}