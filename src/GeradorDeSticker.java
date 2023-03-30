import java.awt.Graphics2D;
// import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.File;
// import java.io.FileInputStream;
import java.io.InputStream;
// import java.net.URL;
import java.time.LocalDateTime;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradorDeSticker {

    public void criar(InputStream inputStream, String nomeArquivo) throws Exception
    // public void criar() throws Exception
    {
        // String nomeArquivo = "figura";
        // InputStream inputStream = new FileInputStream(new File("entrada/filme001.jpg"));
        // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_2.jpg").openStream();
        // ler imagem original
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar uma nova imagem com transparencia
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0,null);

        // Configuracao do texto
        // Font font = Font.getFont("Helvetica-bold-italic");
        // FontRenderContext frc = graphics.getFontRenderContext();
        // TextLayout layout = new TextLayout("This is a string", font, frc);

        // Escrever uma frase na imagem
        // System.out.println("Largura: "+largura);
        String texto = "Bom Diaaa!!!";

        int larguraTexto = graphics.getFontMetrics().stringWidth(texto);
        // System.out.println("Largura Texto: "+larguraTexto);
        int posicaoX = (largura - larguraTexto) / 2;

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 62);
        graphics.setFont(fonte);
        graphics.drawString(texto, posicaoX, altura+55);



        // gravar em arquivo
        LocalDateTime tempo = LocalDateTime.now();
        nomeArquivo = nomeArquivo.replaceAll("[^a-zA-Z0-9]", "-");
        String HoraMinutoSegundo = tempo.getHour()+"h"+tempo.getMinute()+"m"+tempo.getSecond()+"s";
        ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo+"_"+HoraMinutoSegundo+".png"));
    }

    // public static void main(String[] args) throws Exception {
    //     // System.out.println("oie ");
    //     var gerador = new GeradorDeSticker();
    //     gerador.criar();
    // }
}
