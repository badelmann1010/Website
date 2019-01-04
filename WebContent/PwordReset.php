<?php
// the message
$reset = "Here is your new password:\nSecond line of text";

// use wordwrap() if lines are longer than 70 characters
$reset = wordwrap($reset,70);

// send email
mail("someone@example.com","My subject",$reset);
?>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Untitled Document</title>
</head>

<body>

<?php

if(isset($_POST['submit'])) {
$subject = "Password Reset for PetFace";
$UserEmail = $_POST['email'];
 
$body = "Here is the link for resetting your password: ";
 
//echo "Data has been submitted to $to!";

mail($UserEmail, $subject, $body);
} else {
//echo "no work";
}
?>

        <script type="text/javascript">
            window.location.href = "Home.jsp"
            alert("password reset sent to <?php $UserEmail ?>");
         </script>

</body>
</html>