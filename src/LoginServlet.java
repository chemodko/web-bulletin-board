import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login/*")
public class LoginServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Board board = BoardServlet.board;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsps/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (board.getUsers().get(name).equals(password)) {
            request.setAttribute("adverts", board.getAdverts());
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            getServletContext().getRequestDispatcher("/jsps/board.jsp").forward(request, response);
        }
        else {
            request.setAttribute("Error", "Sorry, username or password error!");
            request.getRequestDispatcher("/jsps/login.jsp").include(request, response);
        }
    }
}
