package web.filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName = "NullParameterFilter", servletNames = {"area-check-servlet"})
public class NullParameterFilter extends CheckFilter {

    @Override
    protected String getErrMsg() {
        return "Параметры r, x, y не могут быть null";
    }

    @Override
    protected boolean check(ServletRequest servletRequest) {
        String r = servletRequest.getParameter("r");
        String x = servletRequest.getParameter("x");
        String y = servletRequest.getParameter("y");
        return (r != null && x != null && y != null);
    }
}
