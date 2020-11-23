var addModal = document.getElementById("AddUser");
var editModal = document.getElementById("EditUser");
var modalCont = document.getElementById("modalContainer");

function add() {
    addModal.parentNode.style.display = "block";
}
;

function edit(email) {
    editModal.parentNode.style.display = "block";
    let columns = document.getElementById(email).getElementsByTagName("td");
    document.getElementById('editUserEmail').value = columns[0].innerHTML;
    document.getElementById('editUserFirstName').value = columns[1].innerHTML;
    document.getElementById('editUserLastName').value = columns[2].innerHTML;
    document.getElementById('editUserPassword').value = columns[3].innerHTML;
    let active = (columns[5].innerHTML == "true");
    document.getElementById('editUserActive').checked = active;
    document.getElementById('editUserRole').value = columns[4].id;
}
;

function closeModalButton() {
    this.parentNode.parentNode.parentNode.style.display = "none";
}
;

function closeModalLink() {
    this.parentNode.style.display = "none";
}

function scrollUp() {
    window.scrollBy(0, -100);
}

function scrollDown() {
    window.scrollBy(0, 100);
}

document.getElementById('addUserCloseButton').onclick = closeModalButton;
document.getElementById('editUserCloseButton').onclick = closeModalButton;
document.getElementById('addUserCloseLink').onclick = closeModalLink;
document.getElementById('editUserCloseLink').onclick = closeModalLink;
document.getElementById('scrollUp').onclick = scrollUp;
document.getElementById('scrollDown').onclick = scrollDown;

