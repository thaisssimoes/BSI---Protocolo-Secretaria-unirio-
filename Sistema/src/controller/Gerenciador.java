package controller;

import dao.ConexaoBancoDeDados;
import dao.ManipuladorXML;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entity.Aluno;

import model.entity.Professor;
import model.entity.Tecnico;

import model.requerimento.Requerimento;

public class Gerenciador {

    private static final String REQUERIMENTO = "Requerimentos.xml";
    private static final String PROFESSOR = "Professors.xml";
    private static final String TECNICO = "Tecnicos.xml";
    private static final String ALUNO = "Alunos.xml";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/SGR";
    private static final String USER = "postgres";
    private static final String PASS = "";
    private static final ConexaoBancoDeDados dbconnection = new ConexaoBancoDeDados();

    public static void analisaRequerimento(Requerimento requerimento) {

        switch (requerimento.getStatus()) {
            case "TRIAGEM":
                try {
                    ConexaoBancoDeDados.openConnection(URL, USER, PASS);
                    ArrayList<Requerimento> listaInicial = null;
                    ArrayList<Requerimento> listaVazia = new ArrayList<>();

                    for (int i = 0; i < listaInicial.size(); i++) {
                        if (listaInicial.get(i).getNumeroProtocolo().equals(requerimento.getNumeroProtocolo())) {
                            listaInicial.remove(i);
                        }
                    }

//                    xml.setLista(listaInicial);
//                    xml.adiciona(requerimento);
//                    xml.escreveXML();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "DESIGNADO": {
                ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
                xml.leXML();
                ArrayList<Requerimento> listaInicial = xml.getLista();
                ArrayList<Requerimento> listaVazia = new ArrayList<>();
                xml.setLista(listaVazia);
                xml.escreveXML();
                for (int i = 0; i < listaInicial.size(); i++) {
                    if (listaInicial.get(i).getNumeroProtocolo().equals(requerimento.getNumeroProtocolo())) {
                        listaInicial.remove(i);
                    }
                }
                xml.setLista(listaInicial);
                xml.adiciona(requerimento);
                xml.escreveXML();
                break;
            }
            case "CONCLUIDO": {
                ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
                xml.leXML();
                ArrayList<Requerimento> listaInicial = xml.getLista();
                ArrayList<Requerimento> listaVazia = new ArrayList<>();
                xml.setLista(listaVazia);
                xml.escreveXML();
                for (int i = 0; i < listaInicial.size(); i++) {
                    if (listaInicial.get(i).getNumeroProtocolo().equals(requerimento.getNumeroProtocolo())) {
                        listaInicial.remove(i);
                    }
                }
                xml.setLista(listaInicial);
                xml.adiciona(requerimento);
                xml.escreveXML();
                break;
            }
            case "REJEITADO": {
                ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
                xml.leXML();
                ArrayList<Requerimento> listaInicial = xml.getLista();
                ArrayList<Requerimento> listaVazia = new ArrayList<>();
                xml.setLista(listaVazia);
                xml.escreveXML();
                for (int i = 0; i < listaInicial.size(); i++) {
                    if (listaInicial.get(i).getNumeroProtocolo().equals(requerimento.getNumeroProtocolo())) {
                        listaInicial.remove(i);
                    }
                }
                xml.setLista(listaInicial);
                xml.adiciona(requerimento);
                xml.escreveXML();
                break;
            }
            case "PENDENTE": {
                ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
                xml.leXML();
                ArrayList<Requerimento> listaInicial = xml.getLista();
                ArrayList<Requerimento> listaVazia = new ArrayList<>();
                xml.setLista(listaVazia);
                xml.escreveXML();
                for (int i = 0; i < listaInicial.size(); i++) {
                    if (listaInicial.get(i).getNumeroProtocolo().equals(requerimento.getNumeroProtocolo())) {
                        listaInicial.remove(i);
                    }
                }
                xml.setLista(listaInicial);
                xml.adiciona(requerimento);
                xml.escreveXML();
                break;
            }
            default:
                break;
        }
    }

    public static Aluno obterAluno(String cpf, String senha) throws ClassNotFoundException, SQLException {
        ArrayList<Aluno> lista;
        Aluno alunoObtido;
        alunoObtido = null;
        //ManipuladorXML manipulador = new ManipuladorXML(ALUNO);
        //manipulador.leXML();
        ConexaoBancoDeDados.openConnection(URL, USER, PASS);
        lista = ConexaoBancoDeDados.obterAluno(cpf, senha);
        ConexaoBancoDeDados.closeConnection();
        return alunoObtido;
    }

    public static Tecnico obterTecnico(String cpf, String senha) {
        try {
            ArrayList<Tecnico> lista;
            Tecnico tecnicoObtido;
            tecnicoObtido = null;
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            lista = dbconnection.obterTecnico(cpf, senha);
            ConexaoBancoDeDados.closeConnection();

            return tecnicoObtido;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Professor obterProfessorDisciplina(String disciplina) {
        ArrayList<Professor> lista;
        Professor professorObtido;
        professorObtido = null;
        ManipuladorXML manipulador = new ManipuladorXML(PROFESSOR);
        manipulador.leXML();
        lista = manipulador.getLista();
        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i).getGrade().get(i));
//
            if ((lista.get(i).getGrade().contains(disciplina))) {

                professorObtido = lista.get(i);
                return professorObtido;
            }
        }
        return professorObtido;
    }

    public static Professor obterProfessorCargo(String cargo) {

        ArrayList<Professor> lista;
        Professor professorObtido;
        professorObtido = null;
        ManipuladorXML manipulador = new ManipuladorXML(PROFESSOR);
        manipulador.leXML();
        lista = manipulador.getLista();
        for (int i = 0; i < lista.size(); i++) {
            if ((lista.get(i).getCargo().equals(cargo))) {
                professorObtido = lista.get(i);
                return professorObtido;
            }
        }
        return professorObtido;
    }

    public static Tecnico criarTecnicoGenerico() {
        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Tecnico Generico");
        tecnico.setCpf("0000");
        return tecnico;
    }

    public static Professor obterProfessorCPF(String cpf, String senha) {
        try {
            ArrayList<Professor> lista;
            Professor professorObtido;
            professorObtido = null;
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            lista = dbconnection.obterProfessor(cpf, senha);
            ConexaoBancoDeDados.closeConnection();
            for (int i = 0; i < lista.size(); i++) {
                if ((lista.get(i).getCpf().equals(cpf)) && lista.get(i).getSenha().equals(senha)) {
                    professorObtido = lista.get(i);
                    return professorObtido;
                }
            }
            return professorObtido;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Requerimento> buscarTriagem() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        ArrayList<Requerimento> lista = xml.getLista();
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getStatus().equals("TRIAGEM")) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoProtocolo(String numeroProtocolo) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        ArrayList<Requerimento> lista = xml.getLista();
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNumeroProtocolo().equals(numeroProtocolo)) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoCPF(String cpf) {
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        try {
            ConexaoBancoDeDados.openConnection(URL, USER, PASS);
            listaRetorno = ConexaoBancoDeDados.obterRequerimentosPorCPF(cpf);
            ConexaoBancoDeDados.closeConnection();
            return listaRetorno;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Gerenciador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Requerimento> buscarRequerimentoRequerenteAluno() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        ArrayList<Requerimento> lista = xml.getLista();
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getRequerente() instanceof model.entity.Aluno) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoRequerenteProfessor() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        ArrayList<Requerimento> lista = xml.getLista();
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getRequerente() instanceof model.entity.Professor) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoAreaResponsavelProfessor() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        ArrayList<Requerimento> lista = xml.getLista();
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAreaResponsavel() instanceof model.entity.Professor) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoAreaResponsavelTecnico() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        ArrayList<Requerimento> lista = xml.getLista();
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAreaResponsavel() instanceof model.entity.Tecnico && lista.get(i).getStatus().equals("DESIGNADO")) {
                listaRetorno.add(lista.get(i));
            }
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoFinalizado() {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        ArrayList<Requerimento> lista = xml.getLista();
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getStatus().equals("REJEITADO") || lista.get(i).getStatus().equals("CONCLUIDO")) {

                listaRetorno.add(lista.get(i));

            }
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoAreaResponsavelProfessorDesignado(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        ArrayList<Requerimento> lista = xml.getLista();
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getStatus().equals("DESIGNADO")) {

                if (lista.get(i).getAreaResponsavel().getCpf().equals(cpf)) {
                    listaRetorno.add(lista.get(i));
                }
            }
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoAreaResponsavelProfessorDesignadoPendente(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        ArrayList<Requerimento> lista = xml.getLista();
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getStatus().equals("PENDENTE")) {

                if (lista.get(i).getAreaResponsavel().getCpf().equals(cpf)) {
                    listaRetorno.add(lista.get(i));
                }
            }
        }
        return listaRetorno;
    }

    public static ArrayList<Requerimento> buscarRequerimentoAreaResponsavelProfessorFinalizado(String cpf) {
        ManipuladorXML xml = new ManipuladorXML(REQUERIMENTO);
        xml.leXML();
        ArrayList<Requerimento> lista = xml.getLista();
        ArrayList<Requerimento> listaRetorno = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {

            if ((lista.get(i).getStatus().equals("CONCLUIDO")) || (lista.get(i).getStatus().equals("REJEITADO"))) {

                if (lista.get(i).getAreaResponsavel().getCpf().equals(cpf)) {
                    listaRetorno.add(lista.get(i));
                }
            }
        }
        return listaRetorno;
    }

}
