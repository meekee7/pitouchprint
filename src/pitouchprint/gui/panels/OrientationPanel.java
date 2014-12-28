package pitouchprint.gui.panels;

import pitouchprint.gui.MainWindow;
import pitouchprint.gui.Strings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 22.12.2014.
 */
public class OrientationPanel extends AbstractPanel {
    public OrientationPanel() {
        super(Strings.orientationtitle);
        JPanel buttonpanel = new JPanel(new BorderLayout());
        ButtonGroup group = new ButtonGroup();
        JRadioButton portrait = new JRadioButton("Hoch", true);
        JRadioButton landscape = new JRadioButton("Quer");
        group.add(portrait);
        group.add(landscape);

        portrait.setFont(MainWindow.defaultfont);
        landscape.setFont(MainWindow.defaultfont);
        portrait.setPreferredSize(new Dimension(200, 200));
        portrait.setSize(new Dimension(200, 200));
        portrait.setMinimumSize(new Dimension(200, 200));
        landscape.setPreferredSize(new Dimension(200, 200));
        landscape.setSize(new Dimension(200, 200));
        landscape.setMinimumSize(new Dimension(200, 200));
        buttonpanel.add(portrait, BorderLayout.NORTH);
        buttonpanel.add(landscape, BorderLayout.SOUTH);
        this.add(buttonpanel, BorderLayout.CENTER);
    }
}
