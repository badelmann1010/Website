function login () {

	document.getElementById("infoBox").innerHTML = "It's working";
	document.getElementById("loginInfoBox").className= "hidden";

	var username = document.getElementsByName("username").value;
  	var password = document.getElementsByName("password").value;
  
  		if (!username || !password) {
  			$('.alert').show();
  		} else {
    		document.getElementById("wrongpassword").innerHTML = "Thank u very much";
  		}
	}
