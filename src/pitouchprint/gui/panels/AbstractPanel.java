package pitouchprint.gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 22.12.2014.
 */
public abstract class AbstractPanel extends JPanel {
    public String title;

    public AbstractPanel(String title) {
        super(new BorderLayout());
        JLabel titlelabel = new JLabel(title);
        titlelabel.setFont(new Font("Dialog", Font.PLAIN, 24));
        titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlelabel.setPreferredSize(new Dimension(600, 50));
        this.add(titlelabel, BorderLayout.NORTH);
        this.title = title;
    }

    public abstract void addToPrintJob();
}
