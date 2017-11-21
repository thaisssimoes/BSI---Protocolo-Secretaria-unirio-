/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.entity.Aluno;
import model.entity.Professor;
import model.entity.Tecnico;
import model.entity.Usuario;

/**
 *
 * @author RafaelSalazarStavale
 */
public class ConexaoBancoDeDados {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    protected static Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public static void openConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {

        con = null;

        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(url, user, password);

    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "ERROR to close database");
            }
        }
    }

    public ArrayList<Aluno> obterAluno(String cpf, String senha) {
        ArrayList<Aluno> lista = new ArrayList<>();
        Aluno aluno = new Aluno();
        try {

            PreparedStatement query = con.prepareStatement("SELECT * FROM USUARIO WHERE CPF= ? AND SENHA= ? ");
            query.setString(1, cpf);
            query.setString(2, senha);
            rs = query.executeQuery();
            while (rs.next()) {
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setEmail(rs.getString("email"));
                aluno.setNacionalidade(rs.getString("nacionalidade"));
                aluno.setEstadoCivil(rs.getString("estado_civil"));
                aluno.setNomeDoPai(rs.getString("nome_pai"));
                aluno.setNomeDaMae(rs.getString("nome_mae"));
                aluno.setDeficiencia(rs.getString("deficiencia"));
                aluno.setSexo(rs.getString("sexo"));
                aluno.setDataIngresso(rs.getDate("data_ingresso").toLocalDate());
                lista.add(aluno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    public ArrayList<Professor> obterProfessor(String cpf, String senha) {
        ArrayList<Professor> lista = new ArrayList<>();
        Professor professor = new Professor();
        try {

            PreparedStatement query = con.prepareStatement("SELECT * FROM USUARIO WHERE CPF= ? AND SENHA= ? ");
            query.setString(1, cpf);
            query.setString(2, senha);
            rs = query.executeQuery();
            while (rs.next()) {
                professor.setCpf(rs.getString("cpf"));
                professor.setNome(rs.getString("nome"));
                professor.setSenha(rs.getString("senha"));
                professor.setEmail(rs.getString("email"));
                professor.setNacionalidade(rs.getString("nacionalidade"));
                professor.setEstadoCivil(rs.getString("estado_civil"));
                professor.setNomeDoPai(rs.getString("nome_pai"));
                professor.setNomeDaMae(rs.getString("nome_mae"));
                professor.setDeficiencia(rs.getString("deficiencia"));
                professor.setSexo(rs.getString("sexo"));
                professor.setDataIngresso(rs.getDate("data_ingresso").toLocalDate());
                lista.add(professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
    
    public ArrayList<Tecnico> obterTecnico(String cpf, String senha) {
        ArrayList<Tecnico> lista = new ArrayList<>();
        Tecnico tecnico = new Tecnico();
        try {

            PreparedStatement query = con.prepareStatement("SELECT * FROM USUARIO WHERE CPF= ? AND SENHA= ? ");
            query.setString(1, cpf);
            query.setString(2, senha);
            rs = query.executeQuery();
            while (rs.next()) {
                tecnico.setCpf(rs.getString("cpf"));
                tecnico.setNome(rs.getString("nome"));
                tecnico.setSenha(rs.getString("senha"));
                tecnico.setEmail(rs.getString("email"));
                tecnico.setNacionalidade(rs.getString("nacionalidade"));
                tecnico.setEstadoCivil(rs.getString("estado_civil"));
                tecnico.setNomeDoPai(rs.getString("nome_pai"));
                tecnico.setNomeDaMae(rs.getString("nome_mae"));
                tecnico.setDeficiencia(rs.getString("deficiencia"));
                tecnico.setSexo(rs.getString("sexo"));
                tecnico.setDataIngresso(rs.getDate("data_ingresso").toLocalDate());
                lista.add(tecnico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }
}
