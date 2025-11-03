const listContainer = document.getElementById('list-container');

document.addEventListener('DOMContentLoaded', () => {
    getTodoList();
})

async function getTodoList() {
    const response = await fetch('index.php');
    const data  = await response.json();

    data.forEach(element => {
        listContainer.innerHTML += `<li> ${element.title} ${element.description} ${element.deadline} <button onclick="toggleTaskDone(${element.id})">Mark as done</button> </li>`;
    });

}

async function toggleTaskDone(id){
    let response = await fetch('index.php', {
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json'
        },
        body : JSON.stringify({
            "id": id
        })
    });
}

function listTodoItems(todoitems){

}