package library.servlet.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;

        HttpSession session = httpServletRequest.getSession();

        String username = (String) session.getAttribute("username");
        String requestUri = httpServletRequest.getRequestURI();

        if (username != null || requestUri.contains("login") || requestUri.contains("register") || requestUri.contains("assets") || requestUri.contains("css")) {
            chain.doFilter(req, res);
        } else {
            httpServletResponse.sendRedirect(httpServletResponse.encodeRedirectURL("login.jsp"));
        }
    }
}
