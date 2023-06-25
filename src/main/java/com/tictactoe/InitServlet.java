package com.tictactoe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //create new session
        HttpSession currentSession = req.getSession(true);

        //create game field
        Field field = new Field();
        Map<Integer, Sign> fieldData = field.getField();

        //getting values of game field
        List<Sign> data = field.getFieldData();

        //adding parameters to session
        currentSession.setAttribute("field", field);
        //adding values to session
        currentSession.setAttribute("data", data);
        //redirecting request to index.jsp page across server
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
