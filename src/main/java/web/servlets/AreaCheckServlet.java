package web.servlets;

import area.model.ResultsTable;
import area.model.TableRecord;
import area.script.AreaCheckScript;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


@WebServlet(name = "AreaCheckServlet", value = "/area-check-servlet")
public class AreaCheckServlet extends HttpServlet {
    private AreaCheckScript script;
    private ObjectMapper objectMapper;

    @Override
    public void init() {
        this.script = new AreaCheckScript();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        TableRecord record = executeScript(request);
        saveScriptResult(record, request);
        sendScriptResult(record, response);
    }

    private TableRecord executeScript(HttpServletRequest request) {
        String r = request.getParameter("r");
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        return script.execute(r, x, y);
    }

    private void saveScriptResult(TableRecord record, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ResultsTable results = (ResultsTable) session.getAttribute("results");

        if (results == null)
            results = new ResultsTable();
        results.getTable().add(record);
        session.setAttribute("results", results);
    }

    private void sendScriptResult(TableRecord record, HttpServletResponse response) {
        try {
            String recordJson = objectMapper.writeValueAsString(record);
            response.getWriter().write(recordJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
