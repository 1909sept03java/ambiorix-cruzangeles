window.onload = function () {

    fetch(empUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            document.getElementById("welcome").innerText = "Welcome " + data.employeeUsername + "!";
            document.getElementById("email").innerText = "Email: " + data.employeeEmail;
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })

    document.getElementById("getInfo").addEventListener("click", getInfo);

}

let empUrl = 'http://localhost:8082/Reimbursement/session';
let reimUrl = 'http://localhost:8082/Reimbursement/reimsession';

function getInfo() {
    fetch(reimUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            while (document.getElementById("reimbursements-pending").hasChildNodes()) {
                document.getElementById("reimbursements-pending").removeChild(document.getElementById("reimbursements-pending").firstChild);
            }
            while (document.getElementById("reimbursements-done").hasChildNodes()) {
                document.getElementById("reimbursements-done").removeChild(document.getElementById("reimbursements-done").firstChild);
            }
            var headPen = document.createElement("H3");
            var headNote = document.createTextNode("Pending: ")
            headPen.appendChild(headNote);
            document.getElementById("reimbursements-pending").appendChild(headPen);
            var headDone = document.createElement("H3");
            var headResolved = document.createTextNode("Resolved: ")
            headDone.appendChild(headResolved);
            document.getElementById("reimbursements-done").appendChild(headDone);
            for (let i = 0; i < data.length; i++) {
                var main = document.createElement("DIV");

                var node = document.createElement("DIV");
                var reimId = document.createTextNode("Reimbursement ID: " + data[i].reimbursementId)
                node.appendChild(reimId);

                var node1 = document.createElement("DIV");
                var reimBal = document.createTextNode("Reimbursement Balace: " + data[i].reimbursementBalance)
                node1.appendChild(reimBal);

                var node2 = document.createElement("DIV");
                var reimStat = document.createTextNode("Reimbursement Status: " + data[i].reimbursementStatus)
                node2.appendChild(reimStat);

                main.appendChild(node);
                main.appendChild(node1);
                main.appendChild(node2);

                if (data[i].reimbursementStatus == 'P') {
                    document.getElementById("reimbursements-pending").appendChild(main);
                } else {
                    document.getElementById("reimbursements-done").appendChild(main);
                }
            }
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}
