package web.filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebFilter;

import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "RequestTypeFilter", servletNames = {"ControllerServlet"})
public class RequestTypeFilter extends CheckFilter {
    private List<String> allowedRequestTypes;

    @Override
    public void init() {
        allowedRequestTypes = new ArrayList<>();
        allowedRequestTypes.add("initial-request");
        allowedRequestTypes.add("area-check-request");
        allowedRequestTypes.add("clear-request");
    }

    @Override
    protected String getErrMsg() {
        return "Некорректный тип запроса";
    }

    @Override
    protected boolean check(ServletRequest servletRequest) {
        String requestType = servletRequest.getParameter("request-type");
        return requestType != null && allowedRequestTypes.contains(requestType);
    }
}
