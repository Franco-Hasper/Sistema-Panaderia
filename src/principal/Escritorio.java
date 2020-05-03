package principal;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author
 * //<a href="https://www.freepik.com/free-photos-vectors/background">Background
 * vector created by freepik - www.freepik.com</a>
 */
public class Escritorio extends JDesktopPane {

    Image IMG = new ImageIcon(getClass().getResource("/imagenes/fondoEs.jpg")).getImage();

    @Override
    public void paintChildren(Graphics g) {
        g.drawImage(IMG, 0, 0, getWidth(), getHeight(), this);
        super.paintChildren(g);
    }

}
