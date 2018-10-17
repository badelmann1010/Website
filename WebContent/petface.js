function login () {
    document.getElementById("loginInfoBox").classList.remove("hidden");
   }

function hideBadPass () {
    document.getElementById("loginInfoBox").classList.add("hidden");
}

function PetfaceloadingPage () {
	var cookie = document.cookie;
	if (cookie == "Auth=True") {
		//go to the forgot password page
		//alert("Going to the forgot password page: "+cookie);
		document.getElementById("wrongPassword").click();
	} else {
		//go to the sign up page
		//alert("Going to the signup page: "+cookie);
		document.getElementById("noAccount").click();
	}
}


/*var username = document.getElementsByName("username").value;
var password = document.getElementsByName("password").value;

if (!username || !password) {
  $('.alert').show();
} else {
  document.getElementById("wrongpassword").innerHTML = "Thank u very much";
}*/