import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class Figurinhas {
    void criarFigurinha(InputStream inputStream, String novaArquivo) throws IOException {
        //ler
        //InputStream inputStream = new FileInputStream(new File("img/filme.maior.jpg"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //criar uma nova imagem
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novAltura = altura + 200;

        var novaImagem = new BufferedImage(largura, novAltura,BufferedImage.TRANSLUCENT);

        //copiar a imagem original
        Graphics graphics = (Graphics2D)novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0,  null);

        //configura fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.CYAN);
        graphics.setFont(fonte);
        //escrever na imagem
        graphics.drawString("Filme bom x2", 200, novAltura-100);

        //escrever a nova imagem
        ImageIO.write(novaImagem, "png", new File(novaArquivo));
    }
}
