package pitouchprint.gui.panels;

import pitouchprint.gui.NumberChooser;
import pitouchprint.gui.Strings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 29.12.2014.
 */
public class RangePanel extends AbstractPanel {

    public RangePanel() {
        super(Strings.rangetitle);
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(new NumberChooser(Strings.rangefrom, 1, 99), BorderLayout.NORTH);
        panel.add(new NumberChooser(Strings.rangeto, 1, 99), BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void addToPrintJob() {
        //TODO
    }
}
