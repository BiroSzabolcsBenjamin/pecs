<?php 

class Cat{
    private $id;
    private $name;
    private $color;
    private $gender;
    private $birthDate;

    public function __construct($name,  $color,  $gender,  $birthDate)
    {
        $this->name = $name;
        $this->color = $color;
        $this->gender = $gender;
        $this->birthDate = $birthDate;
    }

    public function getId() {return $this->id;}
	public function getName() {return $this->name;}
	public function getColor() {return $this->color;}
	public function getGender() {return $this->gender;}
	public function getBirthDate() {return $this->birthDate;}

	public function setId( $id): void {$this->id = $id;}
	public function setName( $name): void {$this->name = $name;}
	public function setColor( $color): void {$this->color = $color;}
	public function setGender( $gender): void {$this->gender = $gender;}
	public function setBirthDate( $birthDate): void {$this->birthDate = $birthDate;}
	
    static function getAllCats(){
        return [
            new Cat('Sanyi','Vörös', 'Male', '2022-04-20'),
            new Cat('Bella', 'Fekete', 'Female', '2021-11-05'),
            new Cat('Morzsi', 'Szürke', 'Male', '2020-06-18'),
            new Cat('Luna', 'Cirmos', 'Female', '2023-02-12'),
            new Cat('Tigris', 'Barna', 'Male', '2019-09-30'),
            new Cat('Mici', 'Fehér', 'Female', '2022-12-01'),
        ];
    }

    static function getCatAgeFromBirthDate(Cat $cat){
        return date_diff(new Datetime(), new DateTime($cat->getBirthDate()))->y;
    }

    function getAgeFromBirthDate(){
        return date_diff(new Datetime(), new DateTime($this->getBirthDate()))->y;

    }

}

// echo Cat::getCatAgeFromBirthDate(Cat::getAllCats()[0]);


// $sanyi = Cat::getAllCats()[0];

// echo $sanyi->getAgeFromBirthDate();
