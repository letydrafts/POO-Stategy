[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/D2LDXTSE)
# Projeto Orientado a Objetos – Aplicação com Javalin, Maven e JDBC  

## 📌 Descrição  
Este projeto foi desenvolvido como atividade prática da disciplina **Projeto Orientado a Objetos**, com o objetivo de aplicar conceitos de **arquitetura, design patterns e boas práticas de programação**.  

A aplicação foi estruturada com **Java no backend** e integração via **Javalin** para comunicação entre frontend e backend. A persistência dos dados foi implementada utilizando **JDBC** com dependências gerenciadas pelo **Maven**.  

**APLICAR TODOS OS CONCEITOS RAPOSITORY, DAO E SINGLETON no projeto base do E-commerce para TODAS AS ENTIDADES**

## 🏗️ Tecnologias Utilizadas  
- **Java 17+**  
- **Javalin** (framework web leve para REST APIs)  
- **Maven** (gerenciamento de dependências e build)  
- **JDBC** (integração com banco de dados relacional)  

## 🎯 Objetivos do Projeto  
- Consolidar os conceitos de **Programação Orientada a Objetos (POO)**.  
- Estruturar a aplicação em **camadas**.  
- Aplicar **design patterns** adequados para cada parte do sistema.  
- Garantir uma arquitetura limpa e de fácil manutenção.  

## 🧩 Padrões de Projeto Aplicados  

### 🔹 DAO (Data Access Object)  
- Responsável pelo acesso e manipulação dos dados no banco.  
- Cada entidade do projeto possui sua respectiva classe DAO, garantindo separação de responsabilidades.  

### 🔹 Repository  
- Atua como intermediário entre a camada de negócio (serviços) e os DAOs.  
- Fornece uma interface mais abstrata para consultas e operações.  

### 🔹 Singleton (Conexão com o Banco)  
- O gerenciamento da **conexão com o banco de dados** foi implementado utilizando o padrão Singleton.  
- Garante que apenas uma instância de conexão seja criada e reutilizada em toda a aplicação.  

## 📂 Estrutura do Projeto (Visão Geral)  

```bash
src/
├── main/
│ ├── java/
│ │ ├── controller/ # Lida com as rotas e regras de controle
│ │ ├── model/ # Entidades do domínio
│ │ ├── dao/ # Implementações DAO
│ │ ├── repository/ # Camada de repositório
│ │ ├── service/ # Regras de negócio
│ │ └── util/ # Classe de conexão Singleton
│ └── resources/
```

## 🚀 Execução  
1. Clonar o repositório.  
2. Importar o projeto.  
3. Configurar o banco de dados no arquivo.  
4. Executar a aplicação pela classe principal que inicializa o **Javalin**.  

## 📖 Conceitos Trabalhados  
- Programação Orientada a Objetos (POO).  
- Separação de responsabilidades.  
- Boas práticas de design.  
- Integração de frontend e backend em Java.  
- Uso de padrões de projeto para manter **organização, reutilização e manutenção** do código.  

## 👥 Autores  
Projeto desenvolvido como parte da disciplina **Projeto Orientado a Objetos**.  
