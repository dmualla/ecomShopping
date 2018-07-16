package services;

import utilities.ApplicationParams;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/checkout", "/account"})
public class authenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginPath = request.getContextPath() + ApplicationParams.LOGIN_PAGE_SHORT_LINK;

        boolean isUserLoggedIn = (session != null && session.getAttribute(ApplicationParams.USERNAME_PARAM) != null);

        if (isUserLoggedIn) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginPath);
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