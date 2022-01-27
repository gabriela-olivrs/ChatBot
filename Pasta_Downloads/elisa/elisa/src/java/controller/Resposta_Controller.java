package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Resposta;

@WebServlet("/Resposta_Controller")
public class Resposta_Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Resposta_Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("txt/html; charset=UTF-8");
        String resp = request.getParameter("resp");
        resp = resp.replaceAll("[^0-9]", "");
        int fraseId = Integer.parseInt(resp);
        Resposta resposta = new Resposta();
        resposta.salvar(fraseId);
    }
}
