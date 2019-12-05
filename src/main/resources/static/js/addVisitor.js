function addVisitor(){

    let token2 = $("#token").text();
    let firstName = $("#firstName").val();
    let lastName = $("#lastName").val();
    let cardNumber = $("#cardNumber").val();
    let company = $("#company").val();
    let responsiblePerson = $("#responsiblePerson").val();
    let roomName = $("#roomName").val();

let obj = {firstName, lastName, cardNumber, company, responsiblePerson, roomName };

let addVisitorRequest = new XMLHttpRequest();
addVisitorRequest.open('POST', 'http://10.10.10.100:8888/addVisitor',true);
addVisitorRequest.setRequestHeader("Content-Type", "application/json");
    addVisitorRequest.setRequestHeader('Authorization', token2);

let data = JSON.stringify(obj);

addVisitorRequest.send(data);

    addVisitorRequest.onload = function() {


            let newVisitor = JSON.parse(this.response);
let visitorObject = {
    orderNumber: newVisitor.orderNumber,
    inDate: newVisitor.inDateString,
    inTime: newVisitor.inTimeString,
    outDate: newVisitor.outDateString,
    outTime: newVisitor.outTimeString,
    firstName: newVisitor.firstName,
    lastName: newVisitor.lastName,
    cardNumber: newVisitor.cardNumber,
    company: newVisitor.company,
    responsiblePerson: newVisitor.responsiblePerson,
    roomName: newVisitor.roomName,
    responsiblePersonIdentity: newVisitor.responsiblePersonIdentity
};



        let row = $("<div>").attr("class","row").attr("id",newVisitor.visitorId).click(async function () {

            let visitorId = $(this).attr("id");

            let psw = prompt("Please enter your pass");
            let obj = {visitorId: visitorId, password: psw};

            const response = await fetch("http://10.10.10.100:8888/addVisitorOutTime", {
                headers: {"Authorization": $("#token").text(), "Content-Type": "application/json"},
                method: "POST",
                body: JSON.stringify(obj)
            });

            let data = await response.json();

            JSON.stringify(data);

            visitorObject.outDate = data.outDateString;
            visitorObject.outTime = data.outTimeString;
            visitorObject.responsiblePersonIdentity = data.responsiblePersonIdentity;

            $(this).children().remove();
            //let row = $("<div>").attr("class","row").attr("id",newVisitor.visitorId);
            $.each(Object.values(visitorObject), function (index, value) {

               let cell = $("<div>").attr("class", "cell").attr("id", newVisitor.visitorId).text(value);

                row.append(cell);



            });
           // $("#blocks").append(row);
        });
            $.each(Object.values(visitorObject), function (index, value) {
                let cell = $("<div>").attr("class", "cell").attr("id", newVisitor.visitorId).text(value);

                row.append(cell);
            });


            $("#blocks").append(row);





 document.getElementById("addVisitorForm").style.display = "none";
    $('html, body').animate({
        scrollTop: $("#blocks").offset().top
    }, 1000);

    $("#firstName").val("");
    $("#lastName").val("");
    $("#company").val("");
    $("#cardNumber").val("");
    $("#roomName").val("");
    $("#responsiblePerson").val("");
}



}
function addHeader() {

    let th = $("<div>").attr("class", "cell").text("Nr.p.k.");
    let th1 =  $("<div>").attr("class", "cell").text("Ienākšanas datums");
    let th2 =  $("<div>").attr("class", "cell").text("Ienākšanas laiks");
    let th3 = $("<div>").attr("class", "cell").text("Iziešanas datums");
    let th4 =$("<div>").attr("class", "cell").text("Iziešanas laiks");
    let th5 =  $("<div>").attr("class", "cell").text("Vārds");
    let th6 = $("<div>").attr("class", "cell").text("Uzvārds");
    let th7 = $("<div>").attr("class", "cell").text("Caurlaides nr.");
    let th8 = $("<div>").attr("class", "cell").text("Firma");
    let th9 = $("<div>").attr("class", "cell").text("Atbildīga persona");
    let th10 = $("<div>").attr("class", "cell").text("Telpas nr.");
    let th11 = $("<div>").attr("class", "cell").text("Paraksts");

    let row = $("<div>").attr("class", "header");

    row.append().append(th).append(th1).append(th2).append(th3).append(th4).append(th5).append(th6).append(th7).append(th8).append(th9).append(th10).append(th11);

    $("#blocks").append(row);

}