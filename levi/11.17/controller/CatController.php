<?php

include '../service/CatService.php';


class CatController{
    static function getCtasByGender(){
        

        try{
            $gender = $_GET['gender'];
            $response = CatService::getAllCats($gender);

            header("Content-Type: application/json");
            echo json_encode($response);
        } catch(Exception $e){
            echo $e -> getMessage();
        }
    }
    /*  
    static function getCatsByGender($gender){
        try{
            $response = CatService::getCatsByGender($gender);
            echo $response;
        } catch(Exception $e){
            echo $e -> getMessage();
        }
        echo json_encode($response);
    }
    */
}

/*
$gender = $_GET['gender];
CatController::getCatsByGender($gender);

header("Content-Type: application/json");

if (isset($_GET['gender'])) {
    CatController::getCatsByGender($_GET['gender']);
} else {
    CatController::getAllCats();    
}
*/