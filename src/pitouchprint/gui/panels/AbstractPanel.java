package pitouchprint.gui.panels;

import pitouchprint.gui.MainWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 22.12.2014.
 */
public class AbstractPanel extends JPanel {
    public String title;

    public AbstractPanel(String title) {
        super(new BorderLayout());
        JLabel titlelabel = new JLabel(title);
        titlelabel.setFont(MainWindow.defaultfont);
        titlelabel.setPreferredSize(new Dimension(600, 50));
        this.add(titlelabel, BorderLayout.NORTH);
        this.title = title;
    }
}
