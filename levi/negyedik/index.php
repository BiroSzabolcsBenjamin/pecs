<?php

$json = file_get_contents('question.json');
$data = json_decode($json, true);
echo json_encode($data);

if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $userChoice = $_POST['answer'];
        
    }

?>