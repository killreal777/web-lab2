const errMsg = $("#err-msg");


const requests = {
    initialRequest : function () {
        $.ajax({
            type: "GET",
            url: "./controller-servlet",
            data: {"request-type" : "initial-request"},
            success: function(data) {
                $("#results-table-body").prepend(data);
            }
        });
    },

    clearRequest : function () {
        $.ajax({
            type: "GET",
            url: "./controller-servlet",
            data: {"request-type" : "clear-request"},
            success: function() {
                $("#results-table-body").replaceWith("");
                location.reload();
            },
            error: function (response) {
                errMsg.html(response.getAttribute("err-msg"));
            }
        });
    },

    areaCheckRequest : function (data) {
        $.ajax({
            type: "GET",
            url: "./controller-servlet",
            data: data,
            success: function(response) {
                let dataJson = JSON.parse(response);
                writeResult(dataJson);
                printDot(dataJson);
            }
        });
    }
}


export default requests;


function writeResult(dataJson) {
    let tableRow = convertJsonToTablaRow(dataJson);
    $("#results-table-body").prepend(tableRow);
}

function convertJsonToTablaRow(json) {
    let tableRow = "";
    for (let key in json) {
        tableRow += ("<td>" + json[key] + "</td>");
    }
    tableRow = "<tr>" + tableRow + "</tr>";
    return tableRow;
}

function printDot(dataJson) {
    let rValue = dataJson["r"];
    let xValue = dataJson["x"];
    let yValue = dataJson["y"];
    let hitDot = $("#hit-dot");

    let centerCoordinate = 150;

    let dotOffsetX = getDotOffset(xValue, rValue);
    let dotOffsetY = getDotOffset(yValue, rValue);

    let dotCoordinateX = centerCoordinate + dotOffsetX;
    let dotCoordinateY = centerCoordinate - dotOffsetY;

    hitDot.attr("cx", dotCoordinateX);
    hitDot.attr("cy", dotCoordinateY);
}

function getDotOffset(coordinateValue, rValue) {
    let radiusOffset = 100;
    let maxOffset = 149.5;
    let minOffset = -149.5;

    let dotOffset = coordinateValue / rValue * radiusOffset;

    if (dotOffset > maxOffset)
        dotOffset = maxOffset;
    if (dotOffset < minOffset)
        dotOffset = minOffset;

    return dotOffset;
}