/**
 * mybooksmgmtwebapp.js
 */
"use strict";

// IIFE - Immediate-Invoked Function Expression - Module Pattern
(function() {
    
    function getStudents() {
        fetch("http://localhost:8079/eregistrar/api/student/list")
            .then((response) => {
                if(response.ok) {
                    return response.json();
                } else {
                    console.log({status: response.status, statusText: response.statusText});
                    return Promise.reject({status: response.status, statusText: response.statusText});
                }
            })
            .then(students => {
                let content = "";
                students.forEach((student, i) => {
                    if(student.middleName!= null) {
                        content += `
                            <tr>
                                <th scope="row">${i+1}.</th>
                                <td>${student.studentNumber}</td>
                                <td>${student.firstName}</td>
                                <td>${student.middleName}</td>
                                <td>${student.lastName}</td>
                                <td>${student.cpga}</td>
                                <td>${student.dateOfEnrollment}</td>
                                <td>${student.isInternational}</td>
                        `;
                    } else {
                        content += `
                        <tr>
                            <td>${student.studentNumber}</td>
                                <td>${student.firstName}</td>
                                <td></td>
                                <td>${student.lastName}</td>
                                <td>${student.cpga}</td>
                                <td>${student.dateOfEnrollment}</td>
                                <td>${student.isInternational}</td>
                    `;
                    }
                });
                document.querySelector("#tbodyStudentList").innerHTML = content;
            })
            .catch(err => {
                console.log(err);
                const errorMsg = "<tr><td align='center' colspan='3'><p style='color: red;'>We are sorry. The eRegistrar is unavailable. Please try again later</p></td></tr>";
                document.querySelector("#tbodyStudentList").innerHTML = errorMsg;
            })
    }
    getStudents();

})();