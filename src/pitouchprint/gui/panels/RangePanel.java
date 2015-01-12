package pitouchprint.gui.panels;

import pitouchprint.gui.DualChooser;
import pitouchprint.gui.Strings;
import pitouchprint.gui.Style;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 29.12.2014.
 */
public class RangePanel extends AbstractPanel {

    public RangePanel() {
        super(Strings.rangetitle);
        JPanel panel = new JPanel(new BorderLayout(Style.normalbordersize, Style.normalbordersize));
        panel.add(new DualChooser(Strings.rangefrom, Strings.rangeto, 1, 99), BorderLayout.CENTER);
        this.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void addToPrintJob() {
        //TODO
    }
}
