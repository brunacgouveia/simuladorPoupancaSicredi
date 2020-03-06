# simuladorPoupancaSicredi
Este projeto tem o objetivo de testar automaticamente alguns cenários do simulador de poupanca do Sicredi, utilizando Selenium Webdriver 3.14 e Java 8 e Cucumber.
Dentre os cenários estão:
- Validar simulação com dados corretos e tempo aplicado em meses
- Validar simulação com dados corretos e tempo aplicado em anos
- Validar valor aplicado com um número menor do que 20
- Validar valor poupado com um número menor do que 20
- Validar campos obrigatórios


## Pré-requisitos

As especificações de máquina e ferramentas utilizadas para criar e executar a aplicação foram:
- Windows 10 64 bits
- Eclipse IDE 2018-12
- JRE 8u201
- Chrome v80


## Como executar

1. Fazer um clone do repositório para a máquina local.
2. Abrir o projeto no eclipse.
3. Executar o arquivo de teste "TestRunner.java" que está na pasta \src\test\java utilizando JUnit 4.
