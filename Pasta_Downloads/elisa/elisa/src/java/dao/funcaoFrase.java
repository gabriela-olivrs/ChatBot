package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Frase;
import static model.Frase_.significadoid;
import model.Significado;

public class funcaoFrase {

    private MySqlConection conexao;
    private Connection conn;

    public funcaoFrase() {
        this.conexao = new MySqlConection();
        this.conn = this.conexao.getConnection();
    }

    public void inserirFrase(Frase frase) {
        String sql = "INSERT INTO Frase VALUES (null,?,?)";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, frase.getFrase());
            pStatement.setInt(2, frase.getSignificadoid().getId());
            pStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir Frase" + e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM Frase WHERE ID = ?";
        try {
            PreparedStatement pStatement = this.conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            pStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir" + e.getMessage());
        }
    }

    public void inserirFrase(String fras, int SignificadoId) {
        String sql = "INSERT INTO Frase VALUES (null,?,?)";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, fras);
            pStatement.setInt(2, SignificadoId);
            pStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir Frase" + e.getMessage());
        }
    }

    public List<Frase> getFrase() {
        String sql = "SELECT * FROM FRASE";
        try {
            PreparedStatement pStatement = this.conn.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();
            List<Frase> listaFrase = new ArrayList<>();

            while (rs.next()) {
                Frase frase = new Frase();
                frase.setId(rs.getInt("id"));
                frase.setFrase(rs.getString("frase"));
                listaFrase.add(frase);
            }
            return listaFrase;
        } catch (Exception e) {
            return null;
        }
    }
}
