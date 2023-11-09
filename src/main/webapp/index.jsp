<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                        <td>Время</td>
                        <td>Затраты, ns</td>
                        <td>R</td>
                        <td>X</td>
                        <td>Y</td>
                        <td>Результат</td>
                    </tr>
                </thead>
                <tbody id="results-table-body">
                    <jsp:useBean id="results" class="area.model.ResultsTable" scope="session" />
                    <c:forEach var="record" items="${results.records}">
                        <tr>
                            <td>
                                <c:out value="${record.startTime}" />
                            </td>
                            <td>
                                <c:out value="${record.executionTimeNano}" />
                            </td>
                            <td>
                                <c:out value="${record.r}" />
                            </td>
                            <td>
                                <c:out value="${record.x}" />
                            </td>
                            <td>
                                <c:out value="${record.y}" />
                            </td>
                            <td>
                                <c:out value="${record.result}" />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </td>
    </tr>

</table>
</body>

</html>


