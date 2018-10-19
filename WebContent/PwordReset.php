<?php
// the message
$reset = "Here is your new password:\nSecond line of text";

// use wordwrap() if lines are longer than 70 characters
$reset = wordwrap($reset,70);

// send email
mail("someone@example.com","My subject",$reset);
?>