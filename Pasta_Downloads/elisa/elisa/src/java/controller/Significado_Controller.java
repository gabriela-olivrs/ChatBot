package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Significado;

@WebServlet("/Significado_Controller")
public class Significado_Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Significado_Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("txt/html; charset=UTF-8");
        String sig = request.getParameter("significado");
        Significado significado = new Significado();
        if (sig != null && !sig.isEmpty()) {
            significado.setSignificado(sig);
            significado.salvar();
        }
    }
}
