# Emere Pass (Versão de Gerenciamento)

Bem-vindo ao nosso projeto de desenvolvimento de um aplicativo de gerenciamento de estoque para negócios empresariais!

Este aplicativo foi concebido para oferecer uma solução moderna, eficiente e de fácil uso para empresas que lidam com estoques de produtos, alimentos, varejo e Etc.

É importante destacar que este projeto está sendo desenvolvido por alunos do curso técnico em informática do Instituto Federal de São Paulo, o que traz uma perspectiva fresca e inovadora para atender às necessidades das empresas.

## Objetivo

O objetivo da nossa empresa é criar um sistema de banco de dados, onde seja possivel cadastrar produtos, fichas, clientes e funcionários, no intuito de garantir um melhor e mais rápido atendimento, bem como uma plataforma de fácil manuntenção. Além de tudo, usamos interfaces gráficas de JavaFx para uma demonstração do site, e que compartilhe coisas com o banco de dados.

## Linguagens utilizadas

- Java
- JavaFX
- Banco de dados MySQL/estudojava
- Maven

## Como está montado o repositório

- src/main/java/com/example/javafxproject/DAO usado para a implementação dos Daos das classes, para conseguir guardar os dados fornecidos nas telas.

- src/main/java/com/example/javafxproject estão os Controllers, onde está o código das telas

- src/main/resources/com/example/javafxproject estão todas as telas que fizemos, em FXML.

## Como criar banco direto do VsCode

Utilizamos a seguinte estrutura:

- String url = "jdbc:mysql://localhost:3306/estudojava?user=root&password=estudante";

Essa estrutura serve para ligar o vscode ao banco de dados, é necessário baixar a extensão mysql e criar o Database de acordo com a url acima.

Depois disso você irá criar as tabelas:

- Cliente:
CREATE TABLE clientes (
    id int AUTO_INCREMENT PRIMARY KEY,
    nome varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    senha varchar(100) NOT NULL
);

- Funcionario:
CREATE TABLE funcionarios (
    id int AUTO_INCREMENT PRIMARY KEY,
    email varchar(100) NOT NULL,
    nome varchar(100) NOT NULL,
    senha varchar(100) NOT NULL
);

- Produto:
CREATE TABLE produtos (
    id int AUTO_INCREMENT PRIMARY KEY,
    nome varchar(50) NOT NULL,
    preco varchar(25) NOT NULL,
    categoria varchar(100) NOT NULL
);

- Ficha:
CREATE TABLE ficha (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data varchar(50) NOT NULL,
    quantidade varchar(25) NOT NULL
);

- Mudanca_Preco:
CREATE TABLE mudanca_preco (
    id int AUTO_INCREMENT PRIMARY KEY,
    nome varchar(100) NOT NULL,
    novo_preco varchar(100) NOT NULL
);


## Como executar

Fazer o clone do repositório.

Remover a pasta .git:
```bash
rm -rf .git
```

Iniciar um repositório git, fazer commits e enviar para o seu repositório remoto.


Nos laboratórios de informática do IFSP é necessário configurar o proxy para o funcionamento do maven:

```bash
export JAVA_TOOL_OPTIONS="-Djava.net.useSystemProxies=true"
```

No mesmo terminal que foi configurado o proxy executar o comando:
```bash
./mvnw javafx:run
```


## Colaboradores

- Anna Carolina
- Guilherme Henrique
- Guilherme Souza
- Pedro Guilherme