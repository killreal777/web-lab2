package web.filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName = "AccessFilter", servletNames = {"AreaCheckServlet", "ClearServlet", "InitialServlet"})
public class AccessFilter extends CheckFilter {

    @Override
    protected String getErrMsg() {
        return "Вызов доступен только через ControllerServlet";
    }

    @Override
    protected boolean check(ServletRequest servletRequest) {
        String access = servletRequest.getParameter("access");
        return access != null && access.equals("granted");
    }
}
