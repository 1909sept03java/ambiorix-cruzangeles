window.onload = function () {

    document.getElementById("getInfo").addEventListener("click", getInfo);

}

let apiUrl = 'http://localhost:8082/Reimbursement/session';

function getInfo() {
    fetch(apiUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
        	document.getElementById('id').innerText = "ID: " + data.id;
        	document.getElementById('firstname').innerText = "firstname: " + data.firstname;
        	document.getElementById('lastname').innerText = "lastname: " + data.lastname;
            console.log(data);
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}