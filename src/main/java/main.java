import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // conexao
        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String > response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        //System.out.println(body);
        //extracao dos dados, usando expressoes regulares
        var parser = new JsonParser();
        List<Map<String, String>> listaDFilmes = parser.parse(body);

        //Exibir
        var geradora = new Figurinhas();
        for(Map<String, String> filme : listaDFilmes){
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.criarFigurinha(inputStream, nomeArquivo);
        }

    }
}
