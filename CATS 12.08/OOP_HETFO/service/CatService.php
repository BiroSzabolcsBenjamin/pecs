    <?php
    require_once '../model/Cat.php';

    class CatService{
        static function getCatsByGender($genderFilter){

            $modelResult = Cat::getAllCats();
            $result = [];
            foreach($modelResult as $cat){
                if($cat->getGender() == $genderFilter){
                    $result[] = [
                        'name' => $cat->getName(),
                        'color' => $cat->getColor(),
                        'birthDate' => $cat->getBirthDate()
                    ];
                }
            }
            return $result;
        }

        static function postCat(){
            $modelResult = Cat::getAllCats();
            $currentCats = [];
            foreach ($modelResult as $cat) {
                $currentCats[] = [
                    "name" => $cat->getName(),
                    "color" => $cat->getColor(),
                    "gender" => $cat->getGender(),
                    "birthday" => $cat->getBirthDate()
                ];
            }
            $currentCats[] = $newCatData;

            $isSuccess = Cat::writeAllCats($currentCats);

            if($isSuccess){
                return ["success" => true, "message" => "Sikeresen hozzáadva"];
            } else {
                return ["success" => false, "message" => "Hiba a mentés során"];
            }
        }

        static function deleteCatByName($name){
            $modelResult = Cat::getAllCats();
            $result =[];
            $isDeleted = false;

            foreach($modelResult as $cat){
                if($cat -> getName() == $name){
                    $isDeleted = true;
                } else {
                $catsAfterDeletion[] = $cat;
                }
                
            }
            if ($isDeleted) {
            $isSuccess = Cat::writeAllCats($catsAfterDeletion);
            
            if ($isSuccess) {
                return ["success" => true, "message" => "Sikeres törlés: {$name}."];
            } else {
                return ["success" => false, "message" => "Hiba a törlés utáni mentés során."];
            }
            } else {
             return ["success" => false, "message" => "A cica ({$name}) nem található."];
            }
        }
    }


