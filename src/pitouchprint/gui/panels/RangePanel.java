package pitouchprint.gui.panels;

import pitouchprint.gui.NumberChooser;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 29.12.2014.
 */
public class RangePanel extends AbstractPanel {

    public RangePanel() {
        super("Druckbereich");
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(new NumberChooser("Von Seite", 99), BorderLayout.NORTH);
        panel.add(new NumberChooser("Bis Seite", 99), BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void addToPrintJob() {
        //TODO
    }
}
