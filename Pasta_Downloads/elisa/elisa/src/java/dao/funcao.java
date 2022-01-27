package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Significado;

public class funcao {

    private MySqlConection conexao;
    private Connection conn;

    public funcao() {
        this.conexao = new MySqlConection();
        this.conn = this.conexao.getConnection();
    }

    public void inserirSignificado(Significado significado) {
        String sql = "INSERT INTO SIGNIFICADO VALUES (null,?)";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, significado.getSignificado());
            pStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir Significado" + e.getMessage());
        }
    }

    /*   public void editarSignificado(){
        String sql ="UPDATE SIGNIFICADO SET SIGNIFICADO = ?";
        try {
            PreparedStatement pStatement =  this.conn.prepareStatement(sql);
            pStatement.setString(1, Significado.getSignificado());
        } catch (Exception e) {
            System.out.println("Erro ao editar significado!" + e.getMessage());
        }
    }
     */
    public void excluir(int id) {
        String sql = "DELETE FROM SIGNIFICADO WHERE ID = ?";
        try {
            PreparedStatement pStatement = this.conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            pStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir" + e.getMessage());
        }
    }

    public List<Significado> getSignificado() {
        String sql = "SELECT * FROM SIGNIFICADO";
        try {
            PreparedStatement pStatement = this.conn.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();
            List<Significado> listaSignificado = new ArrayList<>();
            while (rs.next()) {
                Significado significado = new Significado();
                significado.setId(rs.getInt("id"));
                significado.setSignificado(rs.getString("significado"));
                listaSignificado.add(significado);
            }
            return listaSignificado;
        } catch (Exception e) {
            return null;
        }
    }

    public Significado getSignificado(String s) {
        String sql = "SELECT * FROM SIGNIFICADO WHERE Significado = ?";
        try {
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, s);
            ResultSet rs = pStatement.executeQuery();
            Significado significado = new Significado();
            rs.first(); ///Primeira posicao
            significado.setSignificado(s);
            significado.setId(rs.getInt("id"));
            return significado;
        } catch (Exception e) {
            return null;
        }
    }
}
