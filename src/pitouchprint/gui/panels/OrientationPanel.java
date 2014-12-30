package pitouchprint.gui.panels;

import pitouchprint.gui.Strings;
import pitouchprint.gui.Style;
import pitouchprint.printing.PrintJob;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 22.12.2014.
 */
public class OrientationPanel extends AbstractPanel {
    private JRadioButton portrait, landscape;

    public OrientationPanel() {
        super(Strings.orientationtitle);
        JPanel buttonpanel = new JPanel(new BorderLayout());
        ButtonGroup group = new ButtonGroup();
        this.portrait = new JRadioButton("Hoch", true);
        this.landscape = new JRadioButton("Quer");
        group.add(portrait);
        group.add(landscape);

        this.portrait.setFont(new Font(Style.fontname, Font.PLAIN, Style.largefont));
        this.landscape.setFont(new Font(Style.fontname, Font.PLAIN, Style.largefont));
        this.portrait.setPreferredSize(new Dimension(200, 200));
        this.landscape.setPreferredSize(new Dimension(200, 200));
        this.landscape.putClientProperty("JComponent.sizeVariant", "large");
        this.portrait.putClientProperty("JComponent.sizeVariant", "large");
        buttonpanel.add(this.portrait, BorderLayout.NORTH);
        buttonpanel.add(this.landscape, BorderLayout.SOUTH);
        this.add(buttonpanel, BorderLayout.CENTER);
    }

    @Override
    public void addToPrintJob() {
        PrintJob.currentJob.setLandscape(this.landscape.isSelected());
    }
}
