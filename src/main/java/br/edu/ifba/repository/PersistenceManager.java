package br.edu.ifba.repository;

import br.edu.ifba.models.Emprestimo;
import br.edu.ifba.models.*;
import br.edu.ifba.repository.dao.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenceManager {

    private static final String PASTA_DADOS_LIVROS = "resources/data/livros.txt";
    private static final String PASTA_DADOS_RESERVAS = "resources/data/reservas.txt";
    private static final String PASTA_DADOS_EMPRESTIMOS = "resources/data/emprestimos.txt";
    private static final String PASTA_DADOS_USUARIOS = "resources/data/usuarios.txt";
    private static final String PASTA_DADOS_IDS = "resources/data/ids.txt";

    public static LivroDAOLista carregarLivros() {
        return null;
    }

    public static UsuarioDAOLista carregarUsuarios() {
        return null;
    }

    public static EmprestimoDAOLista carregarEmprestimos() {
        return null;
    }

    public static ReservaDAOLista carregarReservas() {
        return null;
    }

    public static ArrayList<String> carregarIds() {
        return null;
    }

    public static void salvarLivro(Livro livro) {
        try {
            FileWriter fw = new FileWriter(PASTA_DADOS_LIVROS, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(
                    livro.getId() + "|" +
                            livro.getNome() + "|" +
                            livro.getAutor() + "|" +
                            livro.getIsbn() + "|" +
                            livro.getGenero() + "|" +
                            livro.getDescricao() + "|" +
                            livro.getDataPublicacao() + "|" +
                            livro.isDisponivel()
            );

            bw.newLine();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar livro.", e);
        }
    }

    public static void salvarUsuario(Usuario u) {
        try {
            FileWriter fw = new FileWriter(PASTA_DADOS_USUARIOS, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(
                    u.getId() + "|" +
                            u.getNome() + "|" +
                            u.getEmail() + "|" +
                            u.getSenha() + "|" +
                            u.getTipo()
            );

            bw.newLine();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar usuário.", e);
        }
    }

    public static void salvarEmprestimo(Emprestimo e) {
        try {
            FileWriter fw = new FileWriter(PASTA_DADOS_EMPRESTIMOS, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(
                    e.getId() + "|" +
                            e.getDataEmprestimo() + "|" +
                            e.getDataDevolucao() + "|" +
                            e.isAtrasado() + "|" +
                            e.getUsuario().getId() + "|" +
                            e.getLivro().getId()
            );

            bw.newLine();
            bw.close();

        } catch (IOException e1) {
            throw new RuntimeException("Erro ao salvar empréstimo.", e1);
        }
    }

    public static void salvarReserva(Reserva r) {
        try {
            FileWriter fw = new FileWriter(PASTA_DADOS_RESERVAS, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(
                    r.getId() + "|" +
                            r.getUsuario().getId() + "|" +
                            r.getTitulo().getIsbn() + "|" +
                            r.getDataReserva()
            );

            bw.newLine();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar reserva.", e);
        }
    }

    public static void sobrescreverEmprestimos(EmprestimoDAOLista listaDeEmprestimos) {

        try {
            FileWriter fw = new FileWriter(PASTA_DADOS_EMPRESTIMOS);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < listaDeEmprestimos.tamanho(); i++) {

                Emprestimo e = listaDeEmprestimos.selecionar(i);

                bw.write(
                        e.getId() + "|" +
                                e.getDataEmprestimo() + "|" +
                                e.getDataDevolucao() + "|" +
                                e.isAtrasado() + "|" +
                                e.getUsuario().getId() + "|" +
                                e.getLivro().getId()
                );

                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao sobrescrever empréstimos.", e);
        }
    }

    public static void sobrescreverReservas(ReservaDAOLista listaDeReservas) {

        try {
            FileWriter fw = new FileWriter(PASTA_DADOS_RESERVAS);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Reserva r : listaDeReservas.listar()) {

                bw.write(
                        r.getId() + "|" +
                                r.getUsuario().getId() + "|" +
                                r.getTitulo().getIsbn() + "|" +
                                r.getDataReserva()
                );

                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao sobrescrever reservas.", e);
        }
    }

    public static void sobrescreverUsuarios(UsuarioDAOLista listaDeUsuarios) {

        try {
            FileWriter fw = new FileWriter(PASTA_DADOS_USUARIOS);
            BufferedWriter bw = new BufferedWriter(fw);

            ArrayList<Usuario> usuarios = listaDeUsuarios.listar();

            for (Usuario u : usuarios) {

                bw.write(
                        u.getId() + "|" +
                                u.getNome() + "|" +
                                u.getEmail() + "|" +
                                u.getSenha() + "|" +
                                u.getTipo()
                );

                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao sobrescrever usuários.", e);
        }
    }

    public static void sobrescreverLivros(LivroDAOLista listaDeLivros) {

        try {
            FileWriter fw = new FileWriter(PASTA_DADOS_LIVROS);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < listaDeLivros.tamanho(); i++) {

                Livro livro = listaDeLivros.selecionar(i);

                bw.write(
                        livro.getId() + "|" +
                                livro.getNome() + "|" +
                                livro.getAutor() + "|" +
                                livro.getIsbn() + "|" +
                                livro.getGenero() + "|" +
                                livro.getDescricao() + "|" +
                                livro.getDataPublicacao() + "|" +
                                livro.isDisponivel()
                );

                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao sobrescrever livros.", e);
        }
    }
}
