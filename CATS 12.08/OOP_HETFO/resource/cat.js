const nameInput = document.getElementById("name_filter");
const requestButton = document.getElementById("get_cats");

const nameIn = document.getElementById("name");
const color = document.getElementById("color");
const gender = document.getElementById("gender");
const birthday = document.getElementById("birthday");




function deleteCat() {
    let name = nameInput.value;
    fetch(`../controller/catController.php?name=${name}`);
}

function addNewCat() {

    const newCatData = {
        name: nameIn.value,
        color: color.value,
        gender: gender.value,
        birthday: birthday.value
    };

    fetch('../controller/catController.php', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newCatData)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Hozzáadás válasz:', data);
        })
        .catch(error => console.error('Hiba a hozzáadás során:', error));
}