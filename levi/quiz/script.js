const quiestionP = document.getElementById('question');

const labelA = document.getElementById('label_A');
const labelB = document.getElementById('label_B');
const labelC = document.getElementById('label_C');
const labelD = document.getElementById('label_D');

const rightA = document.getElementById('rightA');
const rightAIndex = document.getElementById('rightAIndex');

const sendButton = document.getElementById('quiz_send');

let currentQuestionIndex = 0;
let rightAnswer = 0;
let score = 0;
let quizData = [];
let rightAnswerIndex = [];

document.addEventListener('DOMContentLoaded', () => {
    fetch("index.php", {
    })
        .then((response) => response.json())
        .then((jsonData) => {
            console.log(jsonData);
            quizData = jsonData;
            loadQuestion();

        });
})

function loadQuestion() {
    const currentQuestion = quizData[currentQuestionIndex];
    console.log(currentQuestion);
    quiestionP.innerText = currentQuestion.question;
    labelA.innerText = currentQuestion.options.A;
    labelB.innerText = currentQuestion.options.B;
    labelC.innerText = currentQuestion.options.C;
    labelD.innerText = currentQuestion.options.D;
}

sendButton.addEventListener('click', (e) => {
    e.preventDefault();
    currentQuestionIndex++;
    console.log(currentQuestionIndex);
    console.log(rightAnswer);
    if (currentQuestionIndex < quizData.length) {
        if (quizData[currentQuestionIndex].answer === document.querySelector('input[name="quiz_options"]:checked').value) {
            rightAnswer++;
        } else {
            rightAnswerIndex += quizData[currentQuestionIndex].question + ' ' + quizData[currentQuestionIndex].answer + '<br>';
        }
        loadQuestion();
    } else {
        quiestionP.innerText = 'Kvíz vége! 🎉';
        rightA.innerText = `Helyes válaszok száma: ${rightAnswer}`;

        rightAIndex.innerHTML += `Rosszul megadott válaszok: <br> ${rightAnswerIndex}`;

        sendButton.disabled = true;
    }
});