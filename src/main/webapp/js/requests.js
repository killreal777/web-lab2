import table from "./table.js";
import area from "./area.js";

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
                table.writeResult(dataJson);
                area.addDot(dataJson);
            }
        });
    }
}

export default requests;
