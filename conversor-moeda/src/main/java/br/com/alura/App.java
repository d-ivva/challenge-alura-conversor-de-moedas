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
    public static void main( String[] args ) {
        Scanner entrada = new Scanner(System.in);
        Conversor conversor = new Conversor();
        Menu menus = new Menu();
        menus.exibirMenuPrincipal();

        Properties config = Configuracao.getProperties();
        String apiKey = config.getProperty("api.key");
        String urlBase = config.getProperty("api.url");

        System.out.print("\nInsira a sigla da moeda que deseja converter: ");
        String moeda = entrada.nextLine().toUpperCase();
        System.out.print("\nInsira a sigla da nova moeda para qual será convertida: ");
        String novaMoeda = entrada.nextLine().toUpperCase();
        
        System.out.print("\nInsira o valor para concluir a conversão: ");
        double valorParaConverter = entrada.nextDouble();
        entrada.nextLine();

        String endereco = urlBase + apiKey + "/pair/" + moeda + "/" + novaMoeda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println("JSON Puro: " + json);

            Gson gson = new Gson();
            Moeda responseMoeda = gson.fromJson(json, Moeda.class);
            double resultado = conversor.converteMoeda(valorParaConverter, responseMoeda);
            menus.exibirResultados(resultado, responseMoeda);
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro. Tente novamente.");
        } finally {
            entrada.close();
        }
    }
}

