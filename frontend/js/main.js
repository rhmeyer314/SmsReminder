// get all personal items
async function getItems()
{
    let response = await fetch(`http://localhost:8080/api/v1/personal`);
    let data = await response.json();
    return data;
}

document.getElementById('results').innerHTML = "";
getItems()
    .then(data =>
    {for (var i = 0; i < data.length; i ++) {
        results.innerHTML += "<p><strong>" + data[i].item + "</strong></p>" +
            "<button class='btn btn-primary move' id = '" + data[i].id + "' value='" + data[i].item + "' onclick='update(this)'>Update</button> " +
            "<button class='btn btn-danger move' value = '" + data[i].id + "' onclick='del(this)'>Delete</button>"
    }});

// add a new personal item
async function addItem() {
    var add = document.getElementById("add").value;
    let response = await fetch("http://localhost:8080/api/v1/personal", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({item: add})
    })
        .then(function (res) {
            console.log(res)
        })
        .catch(function (res) {
            console.log(res)
        });

    window.location.reload()
}

// delete a personal item
function del(e) {
    return fetch("http://localhost:8080/api/v1/personal/" + e.value, {
        method: 'delete'
    })
        .then(function (res) {
            console.log(res);
            window.location.reload();
        })
        .catch(function (res) {
            console.log(res)
        });
}

// update a personal item
async function update(e) {
    var newValue = prompt("New Value:", e.value);

    let response = await fetch("http://localhost:8080/api/v1/personal/" + e.id, {
        method: 'put',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({id: e.id, item: newValue})
    })
        .then(function (res) {
            console.log(res)
        })
        .catch(function (res) {
            console.log(res)
        });

    window.location.reload()
}

