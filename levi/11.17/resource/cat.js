document.addEventListener('DOMContentLoaded', () => {
    let gender = document.querySelector('#gender').value;
    fetch(`../controller/catController.php?gender=${gender}`)
});
