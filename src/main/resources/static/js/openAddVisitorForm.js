
function openAddVisitorForm() {

  document.getElementById("addVisitorForm").style.display = "block";
  $('html, body').animate({
    scrollTop: $("#addVisitorForm").offset().top
  }, 1000);

}
function closeAddVisitorForm() {
  $("#addVisitorForm").hide();

  $('html, body').animate({
    scrollTop: $("#myTable").offset().top
  }, 1000);

}


