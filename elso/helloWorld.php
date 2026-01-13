<?php

$egy = 1;
$ketto = 4;
$operation = "+";

if ($operation == "+") {
    echo $egy + $ketto;

} elseif ($operation == "-") {
    echo $egy - $ketto;

} elseif ($operation == "*") {
    echo $egy * $ketto;

} elseif ($operation == "/") {
    echo $egy / $ketto;

} else {
    echo "Error: Invalid operation.";
}
?>