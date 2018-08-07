function login () {
    var loginStuff = document.getElementById("loginInfoBox");
    loginStuff.classList.remove("hidden");

      /*var username = document.getElementsByName("username").value;
    var password = document.getElementsByName("password").value;
  
      if (!username || !password) {
        $('.alert').show();
      } else {
        document.getElementById("wrongpassword").innerHTML = "Thank u very much";
      }*/
   }

function hideBadPass () {
    document.getElementById("loginInfoBox").classList.add("hidden");
}
