package ua.com.me;

import ua.com.me.dbConect.DBConect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String userName = request.getParameter("userName");
        String lastName = request.getParameter("lastName");
        System.out.println("seve user " + userName + lastName);
        DBConect dbConect = new DBConect();
        dbConect.saveUser(userName, lastName);
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("key", "value");
        request.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(request, response);
    }
}
