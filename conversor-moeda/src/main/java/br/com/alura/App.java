package br.com.alura;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import java.util.Scanner;

import com.google.gson.Gson;

import br.com.alura.models.Moeda;
import br.com.alura.services.Configuracao;
import br.com.alura.services.Conversor;
import br.com.alura.view.Menu;

public class App {
    private static Scanner entrada = new Scanner(System.in);

    public static void main( String[] args ) {
        Conversor conversor = new Conversor();
        Menu menus = new Menu();

        Properties config = Configuracao.getProperties();
        String apiKey = config.getProperty("api.key");
        String urlBase = config.getProperty("api.url");

        while (true) {
            menus.exibirMenuPrincipal();

            String moedaOrigem = leituraMoeda("Insira a sigla da moeda que deseja converter: ");
            String novaMoeda = leituraMoeda("Insira a sigla da nova moeda para qual será convertida: ");
            double valorParaConverter = leituraValor("Insira o valor para concluir a conversão: ");

            String endereco = urlBase + apiKey + "/pair/" + moedaOrigem + "/" + novaMoeda;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                if (json.contains("\"result\":\"error\"")) {
                    System.out.println("Erro. Moeda não encontrada. Verifique e tente novamente");
                    continue;
                }

                Gson gson = new Gson();
                Moeda responseMoeda = gson.fromJson(json, Moeda.class);
                double resultado = conversor.converteMoeda(valorParaConverter, responseMoeda);
                menus.exibirResultados(resultado, responseMoeda);
            } catch (RuntimeException e) {
                System.out.println("\nEncerrando o sistema...");
                break;
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocorreu um erro. Tente novamente.");
            }
        }
    }

    private static String leituraMoeda(String mensagem) {
        while (true) {
            System.out.print("\n" + mensagem);
            String entradaUsuario = entrada.nextLine().trim().toUpperCase();

            if (entradaUsuario.equals("SAIR")) {
                encerraSistema();
            } else if (entradaUsuario.length() != 3) {
                System.out.println("A sigla deve conter 3 letras (ex: USD). Tente novamente.");
                continue; 
            } else if (!entradaUsuario.matches("[A-Z]+")) {
                System.out.println("A sigla não pode conter números. Tente novamente.");
                continue;
            }
            return entradaUsuario;
        }
    }

    private static double leituraValor(String mensagem) {
        while (true) {
            System.out.print("\n" + mensagem);
            String texto = entrada.nextLine().trim().replace(",", ".");

            if (texto.toUpperCase().equals("SAIR")) {
                encerraSistema();
            }

            try {
                double valor = Double.parseDouble(texto);
                if (valor <= 0) {
                    System.out.println("O valor deve ser maior que zero.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static void encerraSistema() {
        System.out.println("Encerrando o sistema...");
        entrada.close();
        System.exit(0);
    }
}
