import br.com.alura.omnistream.service.json.JsonParser;
import br.com.alura.omnistream.service.json.TerminalCustomizado;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

//Aprender o HttpClient

public class App {
    public static void main(String[] args) throws Exception {
        //Fazer um conexão HTTP e buscar os top 250 filmes
        String url = "https://imdb-api.com/en/API/Top250Movies/k_c98bior3";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        TerminalCustomizado t = new TerminalCustomizado();

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.print( t.negrito + "\u001b[37m \u001b[44m Titulo: ") ;
            System.out.println(filme.get("title")+ t.reset);

            System.out.print(t.negrito + " Poster: " + t.reset);
            System.out.println( filme.get("image"));

            System.out.print(t.negrito + " Notas: " + t.reset);
            System.out.println(filme.get("imDbRating"));

            System.out.println(" ");
        }
    }
}