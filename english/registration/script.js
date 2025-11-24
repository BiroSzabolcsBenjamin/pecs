const form = document.getElementById("registration-form");
const username = document.getElementById("username");
const email = document.getElementById("email");
const password = document.getElementById("password");
const passwordAgain = document.getElementById("password-again");

let user = {};

form.addEventListener("submit", (e) => {
    registerUser();
    e.preventDefault();
});


function registerUser() {
    if (inputValidation() !== true) {
        console.log("Input validation failed");
    } else {
        user = {
            username: username.value,
            email: email.value,
            password: password.value
        };

        console.log(user);
    }

}

//Abcdef123!

function passwordValidation() {
    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()\-+.]).{6,20}$/;
    return regex.test(password.value);

}

function inputValidation() {

    if (username.value == "" && email.value == "" && password.value == "" && passwordAgain.value == "") {
        if (username.value == "") {
            username.classList.add("emptyInput");
        } else {
            username.classList.remove("emptyInput");
            username.classList.add("validInput");
        }
        if (email.value == "") {
            email.classList.add("emptyInput");

        } else {
            email.classList.remove("emptyInput");
            email.classList.add("validInput");
        }
        if (password.value == "") {
            password.classList.add("emptyInput");

        } else {
            password.classList.remove("emptyInput");
            password.classList.add("validInput");
        }
        if (passwordAgain.value == "") {
            passwordAgain.classList.add("emptyInput");

        } else {
            passwordAgain.classList.remove("emptyInput");
            passwordAgain.classList.add("validInput");
        }
        return false;
    } else {
        return true;
    }

    /*
        else if {
            if (username.value !== "") {
                username.classList.remove("emptyInput");
                username.classList.add("validInput");
    
            }
            if (email.value !== "") {
                email.classList.remove("emptyInput");
                email.classList.add("validInput");
    
            }
            if (password.value !== "" && passwordValidation()) {
                password.classList.remove("emptyInput");
                password.classList.add("validInput");
    
            }
            if (passwordAgain.value !== "" && password.value === passwordAgain.value) {
                passwordAgain.classList.remove("emptyInput");
                passwordAgain.classList.add("validInput");
    
            }
            return true;
        }
    */

}


