import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout/*")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();
        
        request.setAttribute("adverts", BoardServlet.board.getAdverts());
        getServletContext().getRequestDispatcher("/jsps/board.jsp").forward(request, response);
    }
}