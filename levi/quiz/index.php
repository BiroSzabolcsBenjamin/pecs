<?php

$question = json_decode(file_get_contents('question.json'), true);


header('Content-Type: application/json');

$responseJSON = [
    'question' => $question[0]['question'],
    'options' => $question[0]['options'],
];
echo json_encode($responseJSON);

