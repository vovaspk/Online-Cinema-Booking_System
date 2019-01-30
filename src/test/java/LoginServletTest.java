import controller.LoginServlet;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServletTest extends Mockito {
    @Test
    public void test() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("username")).thenReturn("usernameExample");
        when(request.getParameter("psw")).thenReturn("passwordExample");

        new LoginServlet().doPost(request, response);

        verify(request, atLeast(1)).getParameter("username");
        verify(request, atLeast(1)).getParameter("psw");



    }
}
