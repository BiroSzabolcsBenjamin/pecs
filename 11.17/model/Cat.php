<?php
class Cat{
    private $id;
    private $name;
    private $color;
    private $gender;
    private $birthDate;
    
    public function __constructor($name, $color, $gender, $birthDate) {
        $this->name = $name;
        $this->color = $color;
        $this->gender = $gender;
        $this->birthDate = $birthDate;
    }

    public function getId(){return $this->id;}
    public function getName(){return $this->name;}
    public function getColor(){return $this->color;}
    public function getGender(){return $this->gender;}
    public function getBirthDate(){return $this->birthDate;}

    public function setId($id): void {$this->id = $id;}
    public function setName($name): void {$this->name = $name;}
    public function setColor($color): void {$this->color = $color;}
    public function setGender($gender): void {$this->gender = $gender;}
    public function setBirthDate($birthDate): void {$this->birthDate = $birthDate;}

    static function getAllCats(){
        return [
            new Cat(
                'Sanyi',
                'Vörös',
                'male',
                '2022-04-20'
            ),
            new Cat(
                'János',
                'Fekete',
                'male',
                '2020-08-10'
            ),
            new Cat(
                'Géza',
                'Vörös',
                'female',
                '2021-01-28'
            ),
            new Cat(
                'Béla',
                'Barna',
                'male',
                '2015-05-20'
            ),
        ];
    }

    static function getCatAgeFromBirthDate(Cat $cat){
        return date_diff(new DateTime() , new DateTime($cat->getBirthDate()))->y;
    }

    function getAgeFromBirthDate(){
        return date_diff(new DateTime() , new DateTime($this->birthDate))->y;
    }
}
/*
echo Cat::getCatAgeFromBirthDate(Cat::getAllCats()[0]);


$sanyi = Cat::getAllCats()[0];
$janos = Cat::getAllCats()[1];

echo $janos->getAgeFromBirthDate();
*/

?>