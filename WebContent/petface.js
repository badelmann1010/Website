var a = false;
document.getElementById("p2").onchange = function() {CheckPassword()};

function login () {
    document.getElementById("loginInfoBox").classList.remove("hidden");
   }

function hideBadPass () {
    document.getElementById("loginInfoBox").classList.add("hidden");
}

function PetfaceloadingPage () {
	var cookie = document.cookie;
	if (cookie == "Auth=True") {
		//go to the forgot password page after 3 attempts
		//call login function to show that you forgot password
		//alert("Going to the forgot password page: "+cookie);
		document.getElementById("wrongPassword").click();
	} else {
		//go to the sign up page
		//alert("Going to the sign up page: "+cookie);
		document.getElementById("StartLogin").click();
		document.getElementById("noAccount").click();
	}
}

function PasswordCheck () {
	var x = document.getElementById("p1").value;
	var y = document.getElementById("p2").value;
	//alert("x " + x + " y " + y + " a " + a)
	if (a == false) {
    	a = true;
    } else if (x!=y) {
    	alert ("your passwords don't match! Please re-type");
    } else {
    	//passwords match, do nothing
    }
}