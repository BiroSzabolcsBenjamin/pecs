<?php
include '../service/CatService.php';

class CatController{
/*
    static function getCatsByGender($gender){
        http_response_code(200);
        header('Content-Type: application/json; charset=utf-8');

        $serviceResult = CatService::getCatsByGender($gender);
        echo json_encode($serviceResult);
    }
*/
    static function postCat(){

        $json_data =file_get_contents('php://input');
        $newCatData = json_decode($json_data, true);

        http_response_code(200);
        header('Content-Type: application/json; charset=utf-8');

        $serviceResult = CatService::postCat($newCatData);
        echo json_encode($serviceResult);
    }

    static function deleteCatByName($name){
        $serviceResult = CatService::deleteCatByName($name);
        
        http_response_code($serviceResult['success'] ? 200 : 404);
        header('Content-Type: application/json; charset=utf-8');
        echo json_encode($serviceResult);
    }
}


/*
$gender = $_GET['gender'];
CatController::getCatsByGender($gender);
*/
$name = $_GET['name'];
CatController::deleteCatByName($name);