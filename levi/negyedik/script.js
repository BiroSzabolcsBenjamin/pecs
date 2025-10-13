const question = document.getElementById('question');
const A = document.getElementById('A');
const B = document.getElementById('B');
const C = document.getElementById('C');
const D = document.getElementById('D');

const baseUrl = 'index.php';

document.addEventListener("DOMContentLoaded", () => {
    fetch(baseUrl)
        .then(response => response.json())
        .then(result => {
            console.log(result)
            result.forEach((q, index) => {
                question.innerHTML = result[index].question;
                A.innerHTML = result[index].options["A"];
                B.innerHTML = result[index].options["B"];
                C.innerHTML = result[index].options["C"];
                D.innerHTML = result[index].options["D"];
            });
        });

})