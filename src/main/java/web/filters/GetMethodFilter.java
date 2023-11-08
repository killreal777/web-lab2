package web.filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(filterName = "GetMethodFilter", servletNames = {"*"})
public class GetMethodFilter extends CheckFilter {
    @Override
    protected String getErrMsg() {
        return "Разрешен только метод GET";
    }

    @Override
    protected boolean check(ServletRequest servletRequest) {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        return req.getMethod().equals("GET");
    }
}
