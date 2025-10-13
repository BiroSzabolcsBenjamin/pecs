<?php
session_start();
if(isset($_SESSION['randomSzam'])) {
    $_SESSION['randomSzam'] = random_int(1,10);
}

    $number = $_SESSION['randomSzam'];
    $userInt = $_POST['userInput'];

        if ($userInt < $number) {
            echo  "A szám nagyobb!";
        } elseif ($userInt > $number) {
            echo "A szám kisebb!";
        } else {
            echo  "Gratulálok, eltaláltad a számot: " . $number;
            session_destroy();
        }

?>
