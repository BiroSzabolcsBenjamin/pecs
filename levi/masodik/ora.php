
<?php 
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $userChoice = $_POST['choice'];
        $choices = ['rock', 'paper', 'scissors'];
        $computerChoice = $choices[array_rand($choices)];

        echo "You chose: " . $userChoice . "<br>";
        echo "Computer chose: " . $computerChoice . "<br>";

        if ($userChoice === $computerChoice) {
            echo "It's a tie!";
        } elseif (
            ($userChoice === 'rock' && $computerChoice === 'scissors') ||
            ($userChoice === 'paper' && $computerChoice === 'rock') ||
            ($userChoice === 'scissors' && $computerChoice === 'paper')
        ) {
            echo "You win!";
        } else {
            echo "Computer wins!";
        }
    } else {
        echo "Please select rock, paper, or scissors.";
    }
?>
