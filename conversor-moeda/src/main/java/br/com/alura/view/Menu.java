package br.com.alura.view;
import br.com.alura.models.Moeda; 

public class Menu {

    public void exibirMenuPrincipal() {
        System.out.print("""
            ************************************************
                        CONVERSOR DE MOEDAS            
            ************************************************
            BRL  - Real Brasileiro | Brasil
            USD  - Dólar Americano | Estados Unidos da América
            CAD  - Dólar Canadense | Canadá
            EUR  - Euro | União Europeia
            CHF	 - Franco Suíço | Suiça
            GBP  - Libra Esterlina | Reino Unido
            RUB	 - Rublo Russo | Russia 
            JPY  - Iene Japonês | Japão
            CNY  - Yuan Chinês | China
            ARS  - Peso Argentino | Argentina 
            BOB  - Boliviano | Bolívia
            CLP  - Peso Chileno | Chile
            COP	 - Peso Colombiano | Colombia
            UYU	 - Peso Uruguaio | Uruguai
            AUD	 - Dólar Australiano | Austrália
            BDT	 - Taka | Bangladesh
            INR	 - Rupia Indiana | India
            ________________________________________________
            - Digite sair a qualquer momento para encerrar o Sistema.
        """);
    }

    public void exibirResultados(double resultado, Moeda responseMoeda) { 
            System.out.println("Moeda Base: " + responseMoeda.base_code());
            System.out.println("Moeda Alvo: " + responseMoeda.target_code());
            System.out.println("Cotação: " + responseMoeda.conversion_rate());

            System.out.println("O valor resultante após conversão é de " + resultado);
    }
}
