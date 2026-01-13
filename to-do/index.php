<?php
header('Content-Type: application/json');
$file = 'todo.json';


$tasks = json_decode(file_get_contents($file), true);

foreach ($tasks as &$t) {
    if (!isset($t['done'])){
        $t['done'] = false;
    }
}


if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    echo json_encode($tasks);
    exit;
}


if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $data = json_decode(file_get_contents('php://input'), true);

    foreach ($tasks as &$t) {
        if ($t['id'] == $data['id']) {
            $t['done'] = true;
        }
    }

    file_put_contents($file, json_encode($tasks, JSON_PRETTY_PRINT));
    echo json_encode(['ok' => true]);
    exit;
}