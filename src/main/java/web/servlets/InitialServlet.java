package web.servlets;

import area.model.ResultsTable;
import area.model.TableRecord;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


@WebServlet(name = "InitialServlet", value = "initial-servlet")
public class InitialServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultsTable resultsTable = (ResultsTable) request.getSession().getAttribute("results");
        if (resultsTable == null)
            return;
        response.getWriter().write(tableBody(resultsTable));
    }

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
}
