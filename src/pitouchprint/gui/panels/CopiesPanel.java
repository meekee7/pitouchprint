package pitouchprint.gui.panels;

import pitouchprint.gui.NumberChooser;
import pitouchprint.gui.Strings;
import pitouchprint.printing.PrintJob;

import java.awt.*;

/**
 * Created by Michael on 22.12.2014.
 */
public class CopiesPanel extends AbstractPanel {

    private NumberChooser numberChooser;
    public CopiesPanel() {
        super(Strings.copiestitle);
        this.numberChooser = new NumberChooser(NumberChooser.Mode.ALONE, null, 1, 99);
        this.add(this.numberChooser, BorderLayout.CENTER);
    }

    @Override
    public void addToPrintJob() {
        PrintJob.currentJob.setCopies(this.numberChooser.getNumber());
    }
}
