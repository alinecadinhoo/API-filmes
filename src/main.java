import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class main {
    public static <string> void main(String[] args) throws IOException, InterruptedException {

        // fazer uma conexão HTTP e buscar os tops 250 filmes

        string url = (string) "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create((String) url);
        var Client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = Client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // pegar os dados que interessam (titulo, poster, classificacao)
        jsonparser jsonparser = new jsonparser();
        List<Map<String, String>> listadefilmes = jsonparser.parse(body);

        // exibir e manipular os dados

        for (Map<String,String> filme : listadefilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }
}
