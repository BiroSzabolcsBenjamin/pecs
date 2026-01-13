<?php
if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    header('Content-Type: application/json'); //A küldött információ típusát adjuk meg. Jelen esetben JSON
    $todoFileContent = file_get_contents('source.json');
    $todoJson = json_decode($todoFileContent);

    echo json_encode($todoJson);
}


if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    header('Content-Type: application/json');

    $todoFileContent = file_get_contents('source.json');
    $requestData = json_decode(file_get_contents('php://input'));

    $id = $requestData -> id;

    $todoArray = json_decode($todoFileContent);
    
    $todoArray[$id - 1] -> done = true;
    file_put_contents('source.json', json_encode($todoArray, JSON_PRETTY_PRINT));

}