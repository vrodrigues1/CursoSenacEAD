package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Adm
 */
import modelos.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.ProdutosDTO;

public class ProdutosDAO {

    public boolean cadastrarProduto(ProdutosDTO produto) {
        int id = 0;

        Connection conn = null;
        PreparedStatement st = null;

        try {

            conn = conectaDAO.connectDB();
            st = conn.prepareStatement("INSERT INTO produtos VALUES (?,?,?,?)");
            st.setInt(1, id++);
            st.setString(2, produto.getNome());
            st.setInt(3, produto.getValor());
            st.setString(4, produto.getStatus());
            st.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        ArrayList<ProdutosDTO> listagem = new ArrayList<>();

        String sql = "SELECT * FROM produtos";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {

            conn = conectaDAO.connectDB();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {

                ProdutosDTO p = new ProdutosDTO();

                p.setId(rset.getInt("id"));
                p.setNome(rset.getString("nome"));
                p.setStatus(rset.getString("status"));
                p.setValor(rset.getInt("valor"));

                listagem.add(p);

            }

        } catch (SQLException e) {
            System.out.println("Erro de conexão " + e.getMessage());
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return listagem;
    }

    public boolean venderProduto(int id) {

        Connection conn = null;
        PreparedStatement pstm = null;

        String sql = "UPDATE produtos SET status = \"Vendido\" WHERE id = ?";

        try {

            conn = conectaDAO.connectDB();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            return true;

        } catch (SQLException e) {

            System.out.println("Erro de conexão " + e.getMessage());
            return false;

        }finally{
            try{
            if(pstm != null){ pstm.close();}
            if(conn != null){ conn.close();}
            
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    
    }

    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        
        ArrayList<ProdutosDTO> listagemVendas = new ArrayList<>();
        
        String sql = "SELECT * FROM produtos WHERE status = \"Vendido\"";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {

            conn = conectaDAO.connectDB();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {

                ProdutosDTO p = new ProdutosDTO();

                p.setId(rset.getInt("id"));
                p.setNome(rset.getString("nome"));
                p.setStatus(rset.getString("status"));
                p.setValor(rset.getInt("valor"));

                listagemVendas.add(p);

            }

        } catch (SQLException e) {
            System.out.println("Erro de conexão " + e.getMessage());
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return listagemVendas;
    }
}
