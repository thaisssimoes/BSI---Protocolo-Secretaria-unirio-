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
import model.requerimento.Requerimento;

/**
 *
 * @author RafaelSalazarStavale
 */
public class ConexaoBancoDeDados {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

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

    public static ArrayList<Aluno> obterAluno(String cpf, String senha) {
        ArrayList<Aluno> lista = new ArrayList<>();
        Aluno aluno = new Aluno();
        try {

            PreparedStatement query = con.prepareStatement(
           "SELECT * FROM SGR.USUARIOS U, SGR.ALUNO A, SGR.ENDERECO E "
                   + "WHERE U.CPF = ? AND SENHA = ? and U.id_endereco = E.id_endereco;"
            );
            query.setString(1, cpf);
            query.setString(2, senha);
            rs = query.executeQuery();
            while (rs.next()) {
                aluno.setCpf(rs.getString("cpf"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setPeriodo(rs.getString("periodo"));
                aluno.setNome(rs.getString("nome"));
                aluno.setDataNascimeto(rs.getDate("data_nascimento").toLocalDate());
                aluno.setSenha(rs.getString("senha"));
                aluno.setEmail(rs.getString("email"));
                aluno.setEstadoCivil(rs.getString("estado_civil"));
                aluno.setNacionalidade(rs.getString("nacionalidade"));
                aluno.setNomeDoPai(rs.getString("nome_pai"));
                aluno.setNomeDaMae(rs.getString("nome_mae"));
                aluno.setDeficiencia(rs.getString("deficiencia"));
                aluno.setSexo(rs.getString("sexo"));
                aluno.setDataIngresso(rs.getDate("data_ingresso").toLocalDate());
                aluno.setTelefoneCelular(rs.getString("telefone_celular"));
                aluno.setTelefoneResidencial(rs.getString("telefone_residencial"));
                aluno.setEstaTrancado(rs.getBoolean("esta_trancado"));
                aluno.setQtdeTrancamento(rs.getInt("qtde_trancamento"));
                aluno.setLogradouro(rs.getString("logradouro"));
                aluno.setTipoDeEndereco(rs.getString("tipo_endereco"));
                aluno.setTipoLogradouro(rs.getString("tipo_logradouro"));
                aluno.setComplemento(rs.getString("complemento"));
                aluno.setEstado(rs.getString("estado"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setCep(rs.getString("cep"));
                aluno.setPais(rs.getString("pais"));                
                
                lista.add(aluno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

    public static ArrayList<Requerimento> obterRequerimentosPorCPF(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
