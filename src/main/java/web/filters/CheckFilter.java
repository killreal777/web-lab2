package web.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

/**
 * Abstract filter for blocking bad requests depending on check result.
 */
public abstract class CheckFilter extends BadRequestFilter {

    /**
     * Condition for pass, request will be blocked if false.
     */
    abstract protected boolean check(ServletRequest servletRequest);

    @Override
    public final void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (check(servletRequest))
            filterChain.doFilter(servletRequest, servletResponse);
        else
            blockBadRequest(servletRequest, servletResponse);
    }

    @Override
    protected final void blockBadRequest(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        super.blockBadRequest(servletRequest, servletResponse);
    }
}
