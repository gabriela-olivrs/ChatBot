package controller;

import dao.funcao;
import java.io.IOException;
import model.Frase;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Significado;
import model.Resposta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Frase;
import model.Significado;

@WebServlet("/Frase")
public class Frase_Controller extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 1L;

    public Frase_Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("txt/html; charset=UTF-8");
        String fras = request.getParameter("frase");
        String sig = request.getParameter("Sig");
        sig = sig.replaceAll("[^0-9]", "");
        int SignificadoId = Integer.parseInt(sig);
        Frase frase = new Frase();
        frase.salvar(fras, SignificadoId);
    }
}
