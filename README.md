# Sistema de Estacionamento

Um sistema completo de gerenciamento de estacionamento desenvolvido em Java, que permite controlar vagas, veículos, tickets e pagamentos de forma integrada.

## 📋 Índice

- [Características](#características)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura do Sistema](#arquitetura-do-sistema)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Como Executar](#como-executar)
- [Funcionalidades](#funcionalidades)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tipos de Veículos](#tipos-de-veículos)
- [Formas de Pagamento](#formas-de-pagamento)
- [Status do Sistema](#status-do-sistema)
- [Logs](#logs)
- [Contribuição](#contribuição)

## 🚀 Características

- ✅ Gerenciamento completo de estacionamento
- ✅ Controle de veículos (carros e motos)
- ✅ Sistema de vagas com diferentes status
- ✅ Geração e controle de tickets
- ✅ Múltiplas formas de pagamento
- ✅ Persistência de dados
- ✅ Sistema de logs para auditoria
- ✅ Interface de linha de comando intuitiva
- ✅ Arquitetura MVC (Model-View-Controller)

## 🛠 Tecnologias Utilizadas

- **Java 21** - Linguagem de programação principal
- **Maven** - Gerenciamento de dependências e build
- **Serialização Java** - Persistência de dados
- **Padrão DAO** - Acesso a dados
- **Padrão Factory** - Criação de objetos
- **Arquitetura MVC** - Separação de responsabilidades

## 🏗 Arquitetura do Sistema

O sistema segue uma arquitetura em camadas bem definida:

```
┌─────────────────┐
│      View       │  ← Interface do usuário
├─────────────────┤
│   Controller    │  ← Lógica de negócio
├─────────────────┤
│      Model      │  ← Entidades do domínio
├─────────────────┤
│       DAO       │  ← Acesso a dados
├─────────────────┤
│    Factory      │  ← Criação de objetos
└─────────────────┘
```

## 📋 Pré-requisitos

- **Java 21** ou superior
- **Maven 3.6+**
- **Sistema Operacional**: Windows, Linux ou macOS

## 🔧 Instalação

1. Clone o repositório:
```bash
git clone https://github.com/joaopedro-dev-cwb/SistemaEstacionamento.git
cd SistemaEstacionamento
```

2. Compile o projeto:
```bash
cd SistemaEstacionamento
mvn clean compile
```

## ▶ Como Executar

### Via Maven:
```bash
mvn exec:java -Dexec.mainClass="org.example.Main"
```

### Via Java (após compilação):
```bash
java -cp target/classes org.example.Main
```

## 🎯 Funcionalidades

### 1. Gerenciamento de Estacionamento
- Criar e configurar estacionamento
- Definir capacidade de vagas
- Gerenciar informações básicas (nome, endereço, telefone, email)

### 2. Gerenciamento de Veículos
- Cadastro de carros e motos
- Controle de entrada e saída
- Registro de informações (placa, modelo, cor)
- Cálculo automático de valores por tipo de veículo

### 3. Gerenciamento de Vagas
- Criação de vagas numeradas
- Controle de status (LIVRE, OCUPADA, LIVREMOTO)
- Vagas específicas para motos
- Ocupação e liberação automática

### 4. Sistema de Tickets
- Geração automática de tickets
- Status de controle (GERADO, PAGO, EXPIRADO)
- Vinculação com veículos e vagas
- Controle de tempo de permanência

### 5. Sistema de Pagamentos
- Múltiplas formas de pagamento
- Cálculo automático de valores
- Registro de transações
- Liberação de vagas após pagamento

## 📁 Estrutura do Projeto

```
SistemaEstacionamento/
├── src/main/java/org/example/
│   ├── Main.java                    # Classe principal
│   ├── controllers/                 # Controladores MVC
│   │   ├── EstacionamentoController.java
│   │   ├── PagamentoController.java
│   │   ├── TicketController.java
│   │   ├── VagaController.java
│   │   └── VeiculoController.java
│   ├── dal/                        # Data Access Layer
│   │   ├── EstacionamentoDAO.java
│   │   ├── PagamentoDAO.java
│   │   ├── TicketDAO.java
│   │   ├── VagaDAO.java
│   │   └── VeiculoDAO.java
│   ├── Enum/                       # Enumerações
│   │   ├── FormaDePagamento.java
│   │   ├── StatusTicket.java
│   │   └── StatusVaga.java
│   ├── factory/                    # Padrão Factory
│   │   ├── EstacionamentoFactory.java
│   │   ├── PagamentoFactory.java
│   │   ├── TicketFactory.java
│   │   ├── VagaFactory.java
│   │   └── VeiculoFactory.java
│   ├── interfaces/                 # Interfaces
│   │   └── Disponibilidade.java
│   ├── model/                      # Modelos de dados
│   │   ├── Carro.java
│   │   ├── Estacionamento.java
│   │   ├── Moto.java
│   │   ├── Pagamento.java
│   │   ├── Ticket.java
│   │   ├── Vaga.java
│   │   └── Veiculo.java
│   ├── util/                       # Utilitários
│   │   └── Log.java
│   └── view/                       # Camada de apresentação
│       ├── EstacionamentoView.java
│       ├── PagamentoView.java
│       ├── TicketView.java
│       ├── VagaView.java
│       └── VeiculoView.java
├── src/dados/                      # Arquivos de persistência
│   ├── vagas.ser
│   └── veiculos.ser
├── logs/                           # Arquivos de log
│   └── erro.txt
└── pom.xml                         # Configuração Maven
```

## 🚗 Tipos de Veículos

### Carro
- Valor por hora: Configurável
- Ocupação: Vagas normais

### Moto
- Valor por hora: Configurável (geralmente menor que carros)
- Ocupação: Vagas específicas ou normais

## 💳 Formas de Pagamento

- **DINHEIRO** - Pagamento em espécie
- **DEBITO** - Cartão de débito
- **CREDITO** - Cartão de crédito
- **PIX** - Transferência instantânea

## 📊 Status do Sistema

### Status de Vagas
- **LIVRE** - Vaga disponível para carros
- **OCUPADA** - Vaga em uso
- **LIVREMOTO** - Vaga específica para motos

### Status de Tickets
- **GERADO** - Ticket criado, aguardando pagamento
- **PAGO** - Ticket quitado
- **EXPIRADO** - Ticket vencido

## 📝 Logs

O sistema mantém logs detalhados em `logs/erro.txt` para:
- Erros de sistema
- Exceções não tratadas
- Problemas de entrada de dados
- Auditoria de operações

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👨‍💻 Autor

**João Pedro** - [@joaopedro-dev-cwb](https://github.com/joaopedro-dev-cwb)

---

*Sistema desenvolvido como projeto acadêmico para demonstrar conceitos de programação orientada a objetos, padrões de design e arquitetura de software.*