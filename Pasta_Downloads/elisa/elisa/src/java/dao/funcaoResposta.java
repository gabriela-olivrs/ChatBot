package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Frase;
import model.Resposta;

public class funcaoResposta {

    private MySqlConection conexao;
    private Connection conn;

    public funcaoResposta() {
        this.conexao = new MySqlConection();
        this.conn = this.conexao.getConnection();
    }

    public void inserirResposta(int FraseId) {
        String sql = "INSERT INTO RESPOSTAS VALUES (?,?)";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, 89);
            pStatement.setInt(2, FraseId);
            pStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir Resposta" + e.getMessage());
        }
    }

     public List<Frase> getResposta() {
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
