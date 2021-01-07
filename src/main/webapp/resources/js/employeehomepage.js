//console.log("separation of concerns");

myUserInformation = {};
window.onload = function () {
    // No event listener, THIS is the event
    getAllReimb();
}

function getAllReimb() {
    fetch('http://localhost:9001/Project1/api/ajax/allReimbursements')
        .then(
            function (theResponse) {
                const convertedResponse = theResponse.json();
                return convertedResponse;
            }
        ).then(
            function (theSecondResponse) {
                //console.log('secondresponse' + theSecondResponse);
                myUserInformation = theSecondResponse;
                ourDOMManipulation(theSecondResponse);
            }
        )
}

function sendAllReimb() {
    fetch('http://localhost:9001/Project1/api/ajax/sendPending')
        .then(
            function (theResponse) {
                const convertedResponse = theResponse.json();
                return convertedResponse;
            }
        ).then(
            function (theSecondResponse) {
                //console.log('secondresponse' + theSecondResponse);
                myUserInformation = theSecondResponse;
                ourDOMManipulationTable(theSecondResponse);
            }
        )
}

//function myButtonClickFunc(){
//sendAllReimb();
//}

function ourDOMManipulation(ourJSON) {

    for (let i = 0; i < ourJSON.length; i++) {
        if (ourJSON[i].reimbStatusID != 1) {
            // step 1: creating a new element
            let newDiv = document.createElement("li");

            // step 2: create a text node, then append to the new element
            let divText = document.createTextNode("ReimbursementID: " + ourJSON[i].reimb_id + ", " + ourJSON.reimb_amount);
            newDiv.appendChild(divText);

            // step 3: appending the new div element onto an existing element that is 
            let newSelection = document.querySelector("#myReimbList");
            //newSelection.appendChild(newDiv);

            // all creation
            let newTR = document.createElement("tr");
            let newTH = document.createElement("th");

            let newTD1 = document.createElement("td");
            let newTD2 = document.createElement("td");
            let newTD3 = document.createElement("td");
            let newTD4 = document.createElement("td");
            let newTD5 = document.createElement("td");
            let newTD6 = document.createElement("td");
            let newTD7 = document.createElement("td");
            let newTD8 = document.createElement("td");
            let newTD9 = document.createElement("td");
            let newTD10 = document.createElement("td");
            let newTD11 = document.createElement("td");


            // population creations
            newTH.setAttribute("scope", "row");
            let myText1 = document.createTextNode(ourJSON[i].reimbID);
            let myText2 = document.createTextNode('$' + ourJSON[i].reimbAmount);
            let myText3 = document.createTextNode(ourJSON[i].reimbSubmitted);
            let myText4 = document.createTextNode(ourJSON[i].reimbResolved);
            let myText5 = document.createTextNode(ourJSON[i].reimDescription);
            let myText6 = document.createTextNode(ourJSON[i].reimbReciept);
            let myText7 = document.createTextNode(ourJSON[i].reimbAuthor);
            let myText8 = document.createTextNode(ourJSON[i].reimbResolver);
            let myText9 = document.createTextNode(ourJSON[i].reimbStatusID);
            let myText10 = document.createTextNode(ourJSON[i].reimbTypeID);
            let myText11 = document.createElement('input');
            myText11.type = "button";
            myText11.id = "approve" + (i + 1);

            myText11.onclick = function () {
                console.log(this.id);
                ourJSON[i].reimbStatusID = 2;
                console.log(ourJSON[i].reimbStatusID);
            }

            let myText12 = document.createElement('input');
            myText12.type = "button";
            myText12.id = "deny" + (i + 1);

            if (ourJSON[i].reimbStatusID != 1) {
                myText11 = document.createTextNode("Resolved");
                myText11.type = "checkbox";
                myText12 = document.createTextNode("Resolved");
                myText12.type = "checkbox";
            }

            newDiv.appendChild(divText);


            // all appendings
            newTH.appendChild(myText1);
            newTD1.appendChild(myText2);
            newTD2.appendChild(myText3);
            newTD3.appendChild(myText4);
            newTD4.appendChild(myText5);
            newTD5.appendChild(myText6);
            newTD6.appendChild(myText7);
            newTD7.appendChild(myText8);
            newTD8.appendChild(myText9);
            newTD9.appendChild(myText10);
            newTD10.appendChild(myText11);
            newTD11.appendChild(myText12);

            newTR.appendChild(newTH);
            newTR.appendChild(newTD1);
            newTR.appendChild(newTD2);
            newTR.appendChild(newTD3);
            newTR.appendChild(newTD4);
            newTR.appendChild(newTD5);
            newTR.appendChild(newTD6);
            newTR.appendChild(newTD7);
            newTR.appendChild(newTD8);
            newTR.appendChild(newTD9);
            newTR.appendChild(newTD10);
            newTR.appendChild(newTD11);
            let newSelectionTwo = document.querySelector("#reimbTableBody");
            newSelectionTwo.appendChild(newTR);
        }
    }
}