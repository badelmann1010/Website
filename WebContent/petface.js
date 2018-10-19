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
	
	if (cookie == "") {
		//nothing happens, first load of the page
	} else if (cookie == "Auth=True") {
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
    	document.getElementById("SignUp_btn").classList.add("hide");
    	alert ("your passwords don't match! Please re-type");
    } else if (x == "" || y == "") {
    	//one or both password fields is empty
		//alert("x " + x + " y " + y + " a " + a)
		document.getElementById("SignUp_btn").classList.add("hide");
	} else {
    	//passwords match, enable the sign up button
    	document.getElementById("SignUp_btn").classList.remove("hide");
    }
}