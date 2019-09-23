window.onload = function () {

    /*
    console.log(`${users.length}`)
    */
    document.getElementById("randomUserButton").addEventListener("click", getRandomUser25);

}

let apiUrl = 'https://randomuser.me/api/';

/* creating an array of 25 - each row containing an array with blank user info */
let user = { name: "", location: "", email: "", dob: "", thumbnailUrl: "" };
var users = new Array(25);
for (var i = 0; i < users.length; i++) {
    users[i] = new Array(5);
}

/* age variable */
var ageSum = 0;

function getRandomUser25() {
    for (var i = 1; i <= 25; i++) {
        getRandomUser(i)
    }
    document.getElementById("avgAge").innerText = (ageSum);
}

function getRandomUser(param1) {
    fetch(apiUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            document.getElementById('name'+param1).innerText = "Name: " + data.results[0].name.title + " " + data.results[0].name.last;
            document.getElementById('location'+param1).innerText = "Street: " + data.results[0].location.street + ", City: " + data.results[0].location.city;
            document.getElementById('email'+param1).innerText = "Email: " + data.results[0].email;
            document.getElementById('dob'+param1).innerText = "Age: " + data.results[0].dob.age + ", Date of Birth: " + data.results[0].dob.date;
            document.getElementById('thumbnail'+param1).src = data.results[0].picture.thumbnail;
            var age = Number(data.results[0].dob.age, 10);
            ageSum = ageSum + age;
            document.getElementById("avgAge").innerText = ageSum/param1;
            console.log(parseInt(data.results[0].dob.age, 10));
            console.log(data);
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}
