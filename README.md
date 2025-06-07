# Projeto-Integrador-II-A
---

# Agenda Telefônica (CRUD em Java)

Este projeto consiste em uma aplicação de linha de comando para gerenciamento de contatos telefônicos, implementando as operações básicas de CRUD (Criar, Ler, Atualizar, Deletar) utilizando Java e JDBC para persistência em banco de dados.

## Sumário

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar](#como-executar)
- [Dependências](#dependências)
- [Exemplo de Uso](#exemplo-de-uso)
- [Autores](#autores)

---

## Sobre o Projeto

O objetivo desta aplicação é demonstrar o uso de conceitos fundamentais de programação orientada a objetos, manipulação de banco de dados com JDBC e implementação de um menu interativo para CRUD de contatos.

## Funcionalidades

- **Adicionar contato**: Insere um novo contato na agenda.
- **Remover contato**: Remove um contato pelo seu ID.
- **Buscar contato**: Busca contatos pelo nome (parcial ou completo).
- **Listar todos os contatos**: Exibe todos os contatos cadastrados.
- **Contar contatos**: (Opcional) Mostra o total de contatos cadastrados.

## Estrutura do Projeto

```
src/
├── com.agenda
│   └── Main.java                // Classe principal para executar o programa
├── com.agenda.dao
│   └── ContatoDAO.java          // Classe de acesso a dados (CRUD)
├── com.agenda.model
│   └── Contato.java             // Classe de modelo (Contato)
├── com.agenda.util
│   └── ConexaoDB.java           // Gerenciamento da conexão com o banco de dados
└── com.agenda.view
    └── Menu.java                // Interface de menu para interação com o usuário
```

- **Main.java**: Ponto de entrada da aplicação.
- **Contato.java**: Modelo representando um contato.
- **ContatoDAO.java**: Responsável pelas operações CRUD no banco de dados.
- **Menu.java**: Interface de texto para interação com o usuário.
- **ConexaoDB.java**: Gerencia a conexão com o banco de dados (não incluído nos arquivos enviados, mas necessário).

## Como Executar

1. **Clone o repositório**  
   ```bash
   git clone https://github.com/seu-usuario/agenda-telefonica-java.git
   cd agenda-telefonica-java
   ```

2. **Configure o banco de dados**  
   - Crie um banco de dados relacional (ex: MySQL, PostgreSQL ou SQLite).
   - Execute o script SQL para criar a tabela `contatos`:
     ```sql
     CREATE TABLE contatos (
       id INT PRIMARY KEY AUTO_INCREMENT,
       nome VARCHAR(100) NOT NULL,
       telefone VARCHAR(20),
       email VARCHAR(100)
     );
     ```
   - Atualize a classe `ConexaoDB.java` com as informações de conexão do seu banco.

3. **Compile o projeto**  
   Compile os arquivos Java:
   ```bash
   javac -d bin src/com/agenda/**/*.java
   ```

4. **Execute a aplicação**  
   ```bash
   java -cp bin com.agenda.Main
   ```

## Dependências

- Java 8 ou superior
- JDBC Driver do seu banco de dados (MySQL, PostgreSQL, SQLite, etc.)

## Exemplo de Uso

```plaintext
=== AGENDA TELEFÔNICA ===
1. Adicionar contato
2. Remover contato
3. Buscar contato
4. Listar todos os contatos
5. Sair
Escolha uma opção: 1

=== ADICIONAR CONTATO ===
Nome: Maria Silva
Telefone: (11) 91234-5678
E-mail: maria@email.com
Contato adicionado com sucesso!
```



- Projeto desenvolvido para a disciplina de [Projeto Integrador II-A] - [PUC GOIÁS]

---
