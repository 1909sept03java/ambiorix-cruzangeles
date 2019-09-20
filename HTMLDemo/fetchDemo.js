window.onload = function() {
    document.getElementById("fetchJoke").addEventListener("click", getJokeWithFetch);
}

let apiUrl = "https://icanhazdadjoke.com";
let state = {joke:''};

let updateContent = function() {
    document.getElementById('joke').innerText = state.joke;
}

async function getJokeWithFetchAndAsync() {
    // little bit cleaner
    try {
        let response = await fetch(apiUrl, {method:"GET", headers:{"Accept":"application/json"}});
        let data = await response.json();
        state.joke = data.joke;
        updateContent();
    } catch (error) {
        console.log(error);
    }
}

function getJokeWithFetch() {
    fetch(apiUrl, {method:"GET", headers:{"Accept":"application/json"}})
        // define behaviour for when response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // utilize the unwrapped promise as a JS object
        .then((data) => {
            console.log(data);
            state.joke = data.joke;
            updateContent();
        })
        // what if there is a problem?
        .catch((error) =>  {
            alert('oh no :(');
            console.log(error);
        })

}