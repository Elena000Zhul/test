package ua.com.me;

import ua.com.me.dbConect.DBConect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DBConect dbConect = new DBConect();
        List<String> users = dbConect.select();
        request.setAttribute("user", users);
        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);

    }
}
