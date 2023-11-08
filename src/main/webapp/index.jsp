<%@ page import="area.model.ResultsTable" %>
<%@ page import="area.model.TableRecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    private String tableBody(ResultsTable resultsTable) {
        List<TableRecord> resultsList = resultsTable.getTable();
        Collections.reverse(resultsList);
        String tableBody = "";
        for (TableRecord record : resultsList) {
            tableBody += tableLine(record);
        }
        Collections.reverse(resultsList);
        return tableBody;
    }

    private String tableLine(TableRecord record) {
        String tableLine = "";
        tableLine += wrap("td", record.getStartTime());
        tableLine += wrap("td", record.getExecutionTimeNano());
        tableLine += wrap("td", record.getX());
        tableLine += wrap("td", record.getX());
        tableLine += wrap("td", record.getY());
        tableLine += wrap("td", record.getResult());
        return wrap("tr", tableLine);
    }

    private String wrap(String tag, String content) {
        return "<" + tag + ">" + content + "</" + tag + ">";
    }
%>

<%
    ResultsTable resultsTable = (ResultsTable) session.getAttribute("results");
    String tableBody = "";
    if (resultsTable != null)
        tableBody = tableBody(resultsTable);
%>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Web2</title>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
    <script type="module" defer src="js/area.js"></script>
    <script type="module" defer src="js/table.js"></script>
    <script type="module" defer src="js/configuration.js"></script>
    <script type="module" defer src="js/requests.js"></script>
    <script type="module" defer src="js/validators.js"></script>

    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>

<body>
<table class="container">

    <tr>
        <td class="header block" colspan="2">
            Кирилл Кравцов P3211 - Web2
        </td>
    </tr>

    <tr>
        <td class="left-block block">
            <jsp:include page="html/area.html" flush="true" />
        </td>

        <td class="right-block block">
            <jsp:include page="html/form.html" flush="true" />
        </td>
    </tr>

    <tr>
        <td class="results-block block" colspan="2">
            <table id="results-table">
                <thead>
                    <tr>
                        <td>Время</td><td>Затраты, ns</td><td>R</td><td>X</td><td>Y</td><td>Результат</td>
                    </tr>
                </thead>
                <tbody id="results-table-body">
                    <%= tableBody %>
                </tbody>
            </table>
        </td>
    </tr>

</table>
</body>

</html>


