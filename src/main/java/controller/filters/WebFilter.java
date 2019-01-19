package controller.filters;

import javax.servlet.*;
import java.io.IOException;
//import javax.servlet.annotation.WebFilter;

//@javax.servlet.annotation.WebFilter(servletNames = {"servlet1", "servlet2"})
public class WebFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

    }
}
