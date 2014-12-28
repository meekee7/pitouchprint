package pitouchprint.gui;

import pitouchprint.configuration.Settings;
import pitouchprint.gui.panels.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 21.12.2014.
 */
public class MainWindow extends JFrame {

    private static final AbstractPanel[] middlepanels = {new FileChoicePanel(), new CopiesPanel(), new OrientationPanel(), new StartPrintingPanel()};
    private int currentpanelnumber;
    private JPanel middlepanel;
    private JButton forwardbtn, backbtn;
    private CardLayout middlepanellayout;

    public static final Font defaultfont = new Font("Dialog", Font.PLAIN, 48);

    public MainWindow() {
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 480));
        this.setMinimumSize(new Dimension(400, 240)); //TODO find optimal values
        this.setLocationRelativeTo(null);  //Middle of screen
        this.setTitle(Strings.windowtitle);
        if (Settings.currentsettings.getFullscreen())
            this.setExtendedState(Frame.MAXIMIZED_BOTH);

        JPanel mainpanel = new JPanel(new BorderLayout(10, 10));

        this.currentpanelnumber = 0;
        this.middlepanellayout = new CardLayout();
        this.middlepanel = new JPanel(this.middlepanellayout);
        for (AbstractPanel panel : middlepanels)
            this.middlepanel.add(panel, panel.title);

        mainpanel.add(this.middlepanel, BorderLayout.CENTER);

        this.backbtn = new JButton(Strings.backbtnlabel);
        this.backbtn.setPreferredSize(new Dimension(100, 480));
        this.backbtn.setFont(defaultfont);
        this.backbtn.addActionListener(l -> MainWindow.this.goBack());
        this.backbtn.setEnabled(false);
        mainpanel.add(this.backbtn, BorderLayout.WEST);

        this.forwardbtn = new JButton(Strings.forwardbtnlabel);
        this.forwardbtn.setPreferredSize(new Dimension(100, 480));
        this.forwardbtn.setFont(defaultfont);
        this.forwardbtn.addActionListener(l -> MainWindow.this.goForward());
        mainpanel.add(this.forwardbtn, BorderLayout.EAST);

        this.add(mainpanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void goBack() {
        if (this.currentpanelnumber == 0)
            throw new IllegalStateException("Already on the first panel");
        this.currentpanelnumber--;
        this.middlepanellayout.previous(this.middlepanel);
        this.forwardbtn.setEnabled(true);
        if (this.currentpanelnumber == 0)
            this.backbtn.setEnabled(false);
    }

    private void goForward() {
        if (this.currentpanelnumber == middlepanels.length - 1)
            throw new IllegalStateException("Already on last panel");
        this.middlepanellayout.next(this.middlepanel);
        this.currentpanelnumber++;
        this.backbtn.setEnabled(true);
        if (this.currentpanelnumber == middlepanels.length - 1)
            this.forwardbtn.setEnabled(false);
    }
}
