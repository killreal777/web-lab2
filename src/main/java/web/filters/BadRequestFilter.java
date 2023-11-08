package web.filters;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Abstract filter for blocking bad requests using specific error messages.
 */
public abstract class BadRequestFilter extends HttpFilter {

    /**
     * Returns error message, specific for each child class.
     * This method is used for getting error message in blockBadRequest method of this class.
     */
    abstract protected String getErrMsg();

    /**
     * Sets HTTP status "Bad request", sets error message attribute, redirects to error page bad-request.jsp.
     * This method gets error message from getErrMsg method of this class.
     */
    protected void blockBadRequest(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        setBadRequestStatus(servletResponse);
        setErrMsgAttribute(servletRequest);
        redirectToBadRequestJsp(servletRequest, servletResponse);
    }

    private void setBadRequestStatus(ServletResponse servletResponse) {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    private void setErrMsgAttribute(ServletRequest servletRequest) {
        servletRequest.setAttribute("err-msg", getErrMsg());
    }

    private void redirectToBadRequestJsp(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletRequest.getRequestDispatcher("bad-request.jsp").forward(servletRequest, servletResponse);
    }
}
