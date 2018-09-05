<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>PetFace</title>
	<link rel="stylesheet" type="text/css" href="Bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="petfaceStyling.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="petface.js"></script>
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<div>
				<!-- Button to open the modal login form -->
				<button type="button" class="btn btn-primary sticky-top logon" data-toggle="modal" data-target="#loginModal">Login</button>
			</div>
			<h1>PetFace</h1>
		</div>
				
	</div>


	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog">
  		<div class="modal-dialog">
  
    		<!-- Modal content-->
    		<div class="modal-content">
      			<div class="modal-header">
        			<h3 class="modal-title text-center" style="color:#333366;"><strong>Login to PetFace</strong></h3>      				
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body">
        			<form action= "UserLogin" method="post">
        				<div class="form-group">
          					<input type="text" placeholder="Username" name="username" class="form-control" style="height:40px;" required>
        				</div>
        				<div class="form-group">
          					<input type="password" placeholder="Password" name="password" class="form-control" style="height:40px;" required>
        				</div>
        				<div class="text-center">
          					<input type="submit" value="LOGIN" id="login_btn" class="btn btn-primary" style="background-color:#333366;height:40px;color:#ffffff"/>
        				</div>
        			</form>
        			<div id="loginInfoBox" class="alert alert-danger alert-dismissable fade in mt-2 hidden">
          				<button type="button" class="close" id="loginInfoButton"><span aria-hidden="true" onclick="hideBadPass()">&times;</span></button>
          				<p id="infoBox"> Invalid Password.</p>
        			</div>

        			<p id="wrongpassword"></p>
        			<h4 class="text-center"><a href="#modal2" data-toggle="modal">Forgot Password?</a></h4>
      			</div>
      			<div class="modal-footer">
        				<h4 class="text-center">Don't have Account yet? <a href="#modal3" data-toggle="modal">Sign up</a> its fun and easy!</h4>
        			<div class="text-center">
        				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        			</div>
      			</div>
    		</div>

  		</div>
	</div>

	<!-- The Modal -->
	<div class="modal fade" id="modal3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  		<div class="modal-dialog" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<h3 class="modal-title" id="exampleModalLabel"><strong>Petface Sign Up</strong></h3>
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body">
      				<div class="container-fluid">
        				<form action=".php" class="" method="post">
 							<div class="form-group">
          						<input type="text" placeholder="Email Address" name="email" class="form-control" style="height:40px;" required>
        					</div>
        					<div class="form-group">
          						<input type="tel" placeholder="Phone Number" name="Phone" class="form-control" style="height:40px;" required>
        					</div>
 							<div class="form-group">
          						<input type="text" placeholder="Username" name="username" class="form-control" style="height:40px;" required>
        					</div>
        					<div class="form-group">
          						<input type="text" placeholder="Password" name="password" class="form-control" style="height:40px;" required>
        					</div>
        					<div class="form-group">
          						<input type="text" placeholder="Re-type Password" name="password" class="form-control" style="height:40px;" required>
        					</div>
  							<div class="form-group">
  								<div class="checkbox form-group">
    								<label>  <input class="" type="checkbox"> Remember Me</label>
  								</div>
  							</div>
  							<div class="form-group">
  								<button type="button" class="btn btn-secondary col-sm-4 mt-3" data-dismiss="modal">Close</button>
        						<button type="button" class="btn btn-primary col-sm-4 float-right mt-3">Login</button>
        					</div>
						</form>
					</div>	
      			</div>
      			<div class="modal-footer">
      			</div>
    		</div>
  		</div>
	</div>

		<!-- The Modal -->
	<div class="modal fade" id="modal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  		<div class="modal-dialog" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<h3 class="modal-title"><Strong>Reset your password</Strong></h3>
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				<span aria-hidden="true">&times;</span>
        			</button>
      			</div>
      			<div class="modal-body">
      				<div class="container-fluid">
        				<form action=".php" class="" method="post">
 							<div class="form-group">
          						<input type="text" placeholder="Email Address" name="email" class="form-control" style="height:40px;" required>
        					</div>
  							<div class="form-group">
  								<button type="button" class="btn btn-secondary col-sm-5 mt-3" data-dismiss="modal">Close</button>
        						<button type="button" class="btn btn-primary col-sm-5 float-right mt-3">Send Password change</button>
        					</div>
						</form>
					</div>	
      			</div>
      			<div class="modal-footer">
      			</div>
    		</div>
  		</div>
	</div>
	
</body>
</HTML>