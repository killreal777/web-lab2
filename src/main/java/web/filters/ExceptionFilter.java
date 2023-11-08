package web.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName = "ExceptionFilter", servletNames = {"*"})
public class ExceptionFilter extends BadRequestFilter {

    @Override
    protected String getErrMsg() {
        return "";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            blockRequestIgnoreExceptions(servletRequest, servletResponse);
        }
    }

    private void blockRequestIgnoreExceptions(ServletRequest servletRequest, ServletResponse servletResponse) {
        try {
            blockBadRequest(servletRequest, servletResponse);
        } catch (Exception ignored) {}
    }
}
