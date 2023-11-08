import requests from "./requests.js";
import validators from "./validators.js";


//requests.initialRequest();


$("#clear").on("click", function () {
    requests.clearRequest();
})

const areaCheckRequestForm = $("#area-check-request-form");

$("#submit").on("click", function() {
    if (validators.isFormInputValid())
        requests.areaCheckRequest(areaCheckRequestForm.serialize());
});

$("#area-svg").on("click",  function(event) {
    let data = getAreaClickData(event);
    if (validators.isRInputValid())
        requests.areaCheckRequest(data)
});


const center = document.getElementById("dot-center").getBoundingClientRect();
const area = document.getElementById("area-svg").getBoundingClientRect();
const scale = area.width / 3;

function getAreaClickData(clickEvent) {
    let r = $("#r").val();
    let x = (clickEvent.pageX - center.x) / scale * r;
    let y = (center.y - clickEvent.pageY) / scale * r;
    return createAreaClickDataObject(r, x, y);
}

function createAreaClickDataObject(r, x, y) {
    return {
        "request-type" : "area-check-request",
        "r" : r,
        "x" : x,
        "y" : y
    }
}
