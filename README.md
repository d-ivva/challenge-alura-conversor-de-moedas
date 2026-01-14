<div align="center">

  <h1>💱 <b>Conversor de Moedas</b></h1>

  <p>
    Uma aplicação de console em Java que realiza conversões de moedas em tempo real, consumindo uma API de taxas de câmbio. 
    Este projeto foi desenvolvido como parte do desafio de programação <b>Challenge Alura/Oracle Next Education</b>, 
    focando no tratamento de exceções, consumo de API HTTP e orientação a objetos.
  </p>

  <p>
    <img src="https://github.com/user-attachments/assets/c6518cb9-7efb-4a17-8e94-28211e26accf" alt="Demo do Projeto" width="600">
  </p>

  <p>
    <img src="https://img.shields.io/badge/Java-17%2B-orange" alt="Java">
    <img src="https://img.shields.io/badge/Build-Maven-C71A36" alt="Maven">
    <img src="https://img.shields.io/badge/Status-Concluído-brightgreen" alt="Status">
  </p>

</div>

---

## 📋 Funcionalidades

* **Cotação em Tempo Real:** Conecta-se a uma API externa para buscar as taxas de câmbio mais recentes.
* **Interatividade:** Menu de console interativo ao usuário.
* **Segurança:** Gerenciamento de chaves de API via arquivos de configuração (`config.properties`).
* **Validação:** Tratamento de entradas inválidas e erros de conexão.

## 🗂️ Estrutura do Projeto

O projeto segue a arquitetura padrão do Maven.


## 🛠️ Tecnologias Utilizadas
Java (JDK 11+) | Gson (Google) | ExchangeRate-API (API Externa)


Configuração e Instalação | Pré-requisitos: 
1. Java JDK instalado (versão 11 ou superior).
2. Maven instalado e configurado.
3. Uma chave de API (API Key) da ExchangeRate-API (gratuita).

Passo a Passo
1. Clone o repositório

  
  git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/d-ivva/challenge-alura-conversor-de-moedas)

  
  cd conversor-moeda

  
2. Navegue até a pasta src/main/resources e renomeie o arquivo onfig.example.properties para config.properties
3. Adicione sua própria chave API



api.key=COLE_SUA_CHAVE_API_AQUI


api.url=[https://v6.exchangerate-api.com/v6/](https://v6.exchangerate-api.com/v6/)


4. Compile e rode
## Via VS Code:
1. Abra o arquivo App.java.
2. Aguarde o carregamento do projeto Maven.
3. Clique em "Run" ou pressione F5.

## Via Terminal (Maven):
1. Baixe as dependências e compile


mvn clean install

2. Execute a aplicação


mvn exec:java -Dexec.mainClass="br.com.alura.App"


📦 As principais dependências utilizadas no pom.xml são:
```xml
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies> 
