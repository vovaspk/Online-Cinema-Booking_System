import controller.LoginServlet;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServletTest extends Mockito {
    @Test
    public void test() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("username")).thenReturn("test");
        when(request.getParameter("psw")).thenReturn("test");

       // new LoginServlet().doPost(request, response);

        verify(request, atLeast(1)).getParameter("username");
        verify(request, atLeast(1)).getParameter("psw");



    }
}
