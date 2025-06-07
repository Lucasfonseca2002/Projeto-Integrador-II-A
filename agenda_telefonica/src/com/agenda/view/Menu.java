package com.agenda.view;

import com.agenda.dao.ContatoDAO;
import com.agenda.model.Contato;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private ContatoDAO contatoDAO;
    private Scanner scanner;

    public Menu() {
        this.contatoDAO = new ContatoDAO();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== AGENDA TELEFÔNICA ===");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contato");
            System.out.println("3. Buscar contato");
            System.out.println("4. Listar todos os contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1:
                        adicionarContato();
                        break;
                    case 2:
                        removerContato();
                        break;
                    case 3:
                        buscarContato();
                        break;
                    case 4:
                        listarContatos();
                        break;
                    case 5:
                        System.out.println("Encerrando...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar buffer em caso de erro
            }
        }
    }

    // Implementar os métodos de menu
    private void adicionarContato() throws Exception {
        System.out.println("\n=== ADICIONAR CONTATO ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        Contato contato = new Contato(nome, telefone, email);
        // CORREÇÃO: Usar inserir() em vez de adicionar()
        boolean sucesso = contatoDAO.inserir(contato);

        if (sucesso) {
            System.out.println("Contato adicionado com sucesso!");
        } else {
            System.out.println("Não foi possível adicionar o contato.");
        }
    }

    private void removerContato() throws Exception {
        System.out.println("\n=== REMOVER CONTATO ===");

        System.out.print("Digite o ID do contato a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        // CORREÇÃO: Usar removerPorId() em vez de remover()
        if (contatoDAO.removerPorId(id)) {
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private void buscarContato() throws Exception {
        System.out.println("\n=== BUSCAR CONTATO ===");

        System.out.print("Digite o nome do contato a ser buscado: ");
        String nome = scanner.nextLine();

        List<Contato> contatos = contatoDAO.buscarPorNome(nome);

        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado com esse nome.");
        } else {
            System.out.println("\nContatos encontrados:");
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    private void listarContatos() throws Exception {
        System.out.println("\n=== LISTA DE CONTATOS ===");

        List<Contato> contatos = contatoDAO.listarTodos();

        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
            System.out.println("\nTotal de contatos: " + contatos.size());
        }
    }
}
