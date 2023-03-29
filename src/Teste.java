import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.io.File;

public class Teste extends JFrame {

    public void JustifyExample() throws Exception {

        InputStream inputStream = new URL(
                "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_2.jpg").openStream();
        // ler imagem original
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();

        Font font = Font.getFont("Helvetica-bold-italic");
        FontRenderContext frc = graphics.getFontRenderContext();
        TextLayout layout = new TextLayout("This is a string", font, frc);
        layout.draw(graphics, 0, 0);

        Rectangle2D bounds = layout.getBounds();
        bounds.setRect(bounds.getX() + 0,
                bounds.getY() + 0,
                bounds.getWidth(),
                bounds.getHeight());
        graphics.draw(bounds);

        ImageIO.write(novaImagem, "png", new File("saida/teste001.png"));
    }

    public static void main(String[] args) throws Exception {
        var Teste = new Teste();
        Teste.JustifyExample();
    }
}
