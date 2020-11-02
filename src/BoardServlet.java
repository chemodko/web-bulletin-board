import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static Board board;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            board = new Board("/home/artem/tplabs/apache-tomcat-9.0.39/webapps/lab15/src/users.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        request.setAttribute("adverts", board.getAdverts());
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        board.addAdvert(name, request.getParameter("advert"));
        getServletContext().getRequestDispatcher("/jsps/board.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("delete")) {
            String[] data = uri.split("/");
            board.deleteAdvert(data[4]);
        }
        request.setAttribute("adverts", board.getAdverts());
        getServletContext().getRequestDispatcher("/jsps/board.jsp").forward(request, response);
    }
}