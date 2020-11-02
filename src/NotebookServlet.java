import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class NotebookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Notebook notebook;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            notebook = new Notebook("/home/artem/tplabs/apache-tomcat-9.0.39/webapps/lab15/src/notebook.txt");
            notebook.readUsers("/home/artem/tplabs/apache-tomcat-9.0.39/webapps/lab15/src/users.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String uri = request.getRequestURI();
        //PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        //String password = (String)session.getAttribute("password");
        if (uri.equals("/lab15/notebook")) {
            if (name != null) 
                getServletContext().getRequestDispatcher("/jsps/addMain.jsp").forward(request, response);
            else 
                getServletContext().getRequestDispatcher("/jsps/main.jsp").forward(request, response);
        }
        else if (uri.contains("add")) {
            notebook.add(request.getParameter("name"), request.getParameter("number"), "@" + request.getParameter("group"));
            getServletContext().getRequestDispatcher("/jsps/addMain.jsp").forward(request, response);
        }
        else {
            String[] data = uri.split("/");
            request.setAttribute("group", data[3]);
            request.setAttribute("map", notebook.getMap());
            request.setAttribute("groups", notebook.getGroups());
            getServletContext().getRequestDispatcher("/jsps/somebody.jsp").forward(request, response);
        }
    }
}