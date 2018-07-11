package services;

import utilities.ApplicationParams;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = { ApplicationParams.APP_WELCOME_PAGE, ApplicationParams.APP_PAGE1, ApplicationParams.APP_PAGE2})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/";

        boolean loggedIn = session != null && session.getAttribute(ApplicationParams.USERNAME_PARAM) != null;

        if (loggedIn) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init method ...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy method ...");
    }
}
