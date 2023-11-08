const table = {
    writeResult : function (dataJson) {
        let tableRow = convertJsonToTablaRow(dataJson);
        $("#results-table-body").prepend(tableRow);
    }
}

export default table;

function convertJsonToTablaRow(json) {
    let tableRow = "";
    for (let key in json) {
        tableRow += ("<td>" + json[key] + "</td>");
    }
    tableRow = "<tr>" + tableRow + "</tr>";
    return tableRow;
}
