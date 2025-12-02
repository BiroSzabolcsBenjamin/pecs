<?php 

require_once '../model/Cat.php';

class CatService {
    static function getAllCats(){
        $modelResult = Cat::getAllCats();
        return $modelResult;
        $result = [];
        foreach($modelResult as $cat){
            if($cat->getGender() == $gender){
                $result[] = [
                    "name" => $cat->getName(),
                    "color" => $cat->getColor(),
                    "birthDate" => $cat->getBirthDate(),
                ]; 
            }
        }
        return $result;
    }
    /*
    static function getCatsByGender(string $gender){
        $cats = Cat::getAllCats();

        $catsByGender = [];

        foreach($cats as $cat){
            if($cat->getGender() == $gender){
                $catsByGender[] = $cat;
            }
        }
        return $catsByGender;
    }
    */
}