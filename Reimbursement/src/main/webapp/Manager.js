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
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })

    document.getElementById("getInfo").addEventListener("click", getInfo);
    document.getElementById("getEmployeeInfo").addEventListener("click", getEmployeeInfo);
    document.getElementById("getAllEmployees").addEventListener("click", getAllEmployees);
    document.getElementById("getAllPending").addEventListener("click", getAllPending);
    document.getElementById("getAllResolved").addEventListener("click", getAllResolved);
    document.getElementById("getAllApproveDeny").addEventListener("click", getAllApproveDeny);

}

let empUrl = 'http://localhost:8082/Reimbursement/employeeSession';
let reimUrl = 'http://localhost:8082/Reimbursement/reimbursementSession';
let getAllEmployeesUrl = 'http://localhost:8082/Reimbursement/getAllEmployees';
let getAllPendingUrl = 'http://localhost:8082/Reimbursement/getAllPending';
let getAllResolvedUrl = 'http://localhost:8082/Reimbursement/getAllResolved';
let manReimApproveDeny = 'http://localhost:8082/Reimbursement//manReimApproveDeny';

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
            while (document.getElementById("reimbursements-pending").firstChild) {
                document.getElementById("reimbursements-pending").removeChild(document.getElementById("reimbursements-pending").firstChild);
            }
            while (document.getElementById("reimbursements-done").firstChild) {
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

                var node3 = document.createElement("DIV");
                var empId = document.createTextNode("EmployeeId: " + data[i].employeeId);
                node3.appendChild(empId);
                
                var node4 = document.createElement("DIV");
                var empManId = document.createTextNode("EmployeeManagerId: " + data[i].employeeManagerId);
                node4.appendChild(empManId);
                
                var nodeBr = document.createElement("BR");
                
                main.appendChild(node);
                main.appendChild(node1);
                main.appendChild(node2);
                main.appendChild(node3);
                main.appendChild(node3);
                main.appendChild(node4);
                main.appendChild(nodeBr);

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

function getEmployeeInfo() {
    fetch(empUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            document.getElementById("info").innerText = "General user info-";
            document.getElementById("employeeId").innerText = "Employee ID: " + data.employeeId;
            document.getElementById("employeeEmail").innerText = "Email: " + data.employeeEmail;
            document.getElementById("employeeUsername").innerText = "Username: " + data.employeeUsername;
            document.getElementById("employeePassword").innerText = "Password: " + data.employeePassword;
            document.getElementById("employeeManager").innerText = "isManager: " + data.employeeManager;
            document.getElementById("employeeManagerId").innerText = "ManagerId: " + data.employeeManagerId;
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}

function getAllEmployees() {
    fetch(getAllEmployeesUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                var main = document.createElement("DIV");

                var node = document.createElement("DIV");
                var empId = document.createTextNode("Employee ID: " + data[i].employeeId);
                node.appendChild(empId);

                var node1 = document.createElement("DIV");
                var empUsername = document.createTextNode("Username: " + data[i].employeeUsername);
                node1.appendChild(empUsername);

                var node2 = document.createElement("DIV");
                var empPassword = document.createTextNode("Password: " + data[i].employeePassword);
                node2.appendChild(empPassword);
                
                var node3 = document.createElement("DIV");
                var empEmail = document.createTextNode("Email: " + data[i].employeeEmail);
                node3.appendChild(empEmail);

                var node4 = document.createElement("DIV");
                var empManager = document.createTextNode("isManager: " + data[i].employeeManager);
                node4.appendChild(empManager);
                
                var node5 = document.createElement("DIV");
                var empManagerId = document.createTextNode("Manager ID: " + data[i].employeeManagerId);
                node5.appendChild(empManagerId);
                
                var nodeBr = document.createElement("BR");
                
                main.appendChild(node);
                main.appendChild(node1);
                main.appendChild(node2);
                main.appendChild(node3);
                main.appendChild(node4);
                main.appendChild(node5);
                main.appendChild(nodeBr);
                
                document.getElementById("allEmployees").appendChild(main);
            }
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}

function getAllPending() {
    fetch(getAllPendingUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                var main = document.createElement("DIV");

                var node = document.createElement("DIV");
                var reimId = document.createTextNode("Reimbursement ID: " + data[i].reimbursementId);
                node.appendChild(reimId);

                var node1 = document.createElement("DIV");
                var reimBalance = document.createTextNode("Reimbursement Balance: " + data[i].reimbursementBalance);
                node1.appendChild(reimBalance);

                var node2 = document.createElement("DIV");
                var reimStatus = document.createTextNode("Reimbursement Status: " + data[i].reimbursementStatus);
                node2.appendChild(reimStatus);
                
                var node3 = document.createElement("DIV");
                var empId = document.createTextNode("Employee ID: " + data[i].employeeId);
                node3.appendChild(empId);
                
                var node4 = document.createElement("DIV");
                var empManagerId = document.createTextNode("Employee Manager ID: " + data[i].employeeManagerId);
                node4.appendChild(empManagerId);

                var nodeBr = document.createElement("BR");
                
                main.appendChild(node);
                main.appendChild(node1);
                main.appendChild(node2);
                main.appendChild(node3);
                main.appendChild(node4);
                main.appendChild(nodeBr);
                
                document.getElementById("allPending").appendChild(main);
            }
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}

function getAllResolved() {
    fetch(getAllResolvedUrl, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                var main = document.createElement("DIV");

                var node = document.createElement("DIV");
                var reimId = document.createTextNode("Reimbursement ID: " + data[i].reimbursementId);
                node.appendChild(reimId);

                var node1 = document.createElement("DIV");
                var reimBalance = document.createTextNode("Reimbursement Balance: " + data[i].reimbursementBalance);
                node1.appendChild(reimBalance);

                var node2 = document.createElement("DIV");
                var reimStatus = document.createTextNode("Reimbursement Status: " + data[i].reimbursementStatus);
                node2.appendChild(reimStatus);
                
                var node3 = document.createElement("DIV");
                var empId = document.createTextNode("Employee ID: " + data[i].employeeId);
                node3.appendChild(empId);
                
                var node4 = document.createElement("DIV");
                var empManagerId = document.createTextNode("Employee Manager ID: " + data[i].employeeManagerId);
                node4.appendChild(empManagerId);
                
                var nodeBr = document.createElement("BR");
                
                main.appendChild(node);
                main.appendChild(node1);
                main.appendChild(node2);
                main.appendChild(node3);
                main.appendChild(node4);
                main.appendChild(nodeBr);
                
                document.getElementById("allResolved").appendChild(main);
            }
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}

function getAllApproveDeny() {
    fetch(manReimApproveDeny, { method: "GET", headers: { "Accept": "application/json" } })
        // next is what occurs when the response returns
        .then((response) => {
            let data = response.json();
            return data;
        })
        // now the data is returned, time to use it
        .then((data) => {
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                var main = document.createElement("DIV");

                var node = document.createElement("DIV");
                var reimId = document.createTextNode("Reimbursement ID: " + data[i].reimbursementId);
                node.appendChild(reimId);

                var node1 = document.createElement("DIV");
                var reimBalance = document.createTextNode("Reimbursement Balance: " + data[i].reimbursementBalance);
                node1.appendChild(reimBalance);

                var node2 = document.createElement("DIV");
                var reimStatus = document.createTextNode("Reimbursement Status: " + data[i].reimbursementStatus);
                node2.appendChild(reimStatus);
                
                var node3 = document.createElement("DIV");
                var empId = document.createTextNode("Employee ID: " + data[i].employeeId);
                node3.appendChild(empId);
                
                var node4 = document.createElement("DIV");
                var empManagerId = document.createTextNode("Employee Manager ID: " + data[i].employeeManagerId);
                node4.appendChild(empManagerId);

                var formNode = document.createElement("FORM");
                formNode.setAttribute("action", "butt");
                formNode.setAttribute("method", "post");
                var inputNode = document.createElement("INPUT");
                inputNode.setAttribute("hidden","true");
                inputNode.setAttribute("type","text");
                inputNode.setAttribute("value","D");
                inputNode.setAttribute("name","verdict");
                formNode.appendChild(inputNode);
                var idNode = document.createElement("INPUT");
                idNode.setAttribute("hidden","true");
                idNode.setAttribute("type","text");
                idNode.setAttribute("value",data[i].reimbursementId);
                idNode.setAttribute("name","id");
                formNode.appendChild(idNode);
                var submitNode = document.createElement("INPUT");
                submitNode.setAttribute("type", "submit");
                submitNode.setAttribute("value", "DENY");
                formNode.appendChild(submitNode)

                var formNode2 = document.createElement("FORM");
                formNode2.setAttribute("action", "butt");
                formNode2.setAttribute("method", "post");
                var inputNode2 = document.createElement("INPUT");
                inputNode2.setAttribute("hidden","true");
                inputNode2.setAttribute("type","text");
                inputNode2.setAttribute("value","A");
                inputNode2.setAttribute("name","verdict");
                formNode2.appendChild(inputNode2);
                var idNode2 = document.createElement("INPUT");
                idNode2.setAttribute("hidden","true");
                idNode2.setAttribute("type","text");
                idNode2.setAttribute("value",data[i].reimbursementId);
                idNode2.setAttribute("name","id");
                formNode.appendChild(idNode2);
                var submitNode2 = document.createElement("INPUT");
                submitNode2.setAttribute("type", "submit");
                submitNode2.setAttribute("value", "APPROVE");
                formNode2.appendChild(submitNode2)
                
                var nodeBr = document.createElement("BR");
                
                main.appendChild(node);
                main.appendChild(node1);
                main.appendChild(node2);
                main.appendChild(node3);
                main.appendChild(node4);
                main.appendChild(formNode);
                main.appendChild(formNode2);
                main.appendChild(nodeBr);
                
                document.getElementById("allApproveDeny").appendChild(main);
            }
        })
        // catching an error
        .catch((error) => {
            alert('something went wrong with the hamsters');
            console.log(error);
        })
}
