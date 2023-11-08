package web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "ControllerServlet", value = "/controller-servlet")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestType = req.getParameter("request-type");
        String requestPath = getRequestPath(requestType);
        req.setAttribute("access", "granted");
        req.getRequestDispatcher(requestPath).forward(req, resp);
    }

    private String getRequestPath(String requestType) {
        return switch (requestType) {
            case "initial-request" -> "/initial-servlet";
            case "area-check-request" -> "/area-check-servlet";
            case "clear-request" -> "/clear-servlet";
            default -> throw new IllegalStateException("Unexpected value: " + requestType);
        };
    }
}
