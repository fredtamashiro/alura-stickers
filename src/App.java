import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();

        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();

        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClienteHttp();
        String dadosJson = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extrairConteudo(dadosJson);

        String estrela = "⭐";

        for(int i = 0; i < 3; i++){
            Conteudo conteudo = conteudos.get(i);

            String imagemUrl = conteudo.getUrlImagem();
            String titulo = conteudo.getTitulo();

            InputStream inputStream = new URL(imagemUrl).openStream();
            var gerador = new GeradorDeSticker();
            gerador.criar(inputStream,titulo);

            System.out.println("\u001b[34;1m \u001b[1m"+(i+1)+". "+titulo+"\u001b[m "+estrela+" 5 ");
            System.out.println("\u001b[3m "+imagemUrl+"\u001b[m");
            System.out.println();
        }

    }
}
