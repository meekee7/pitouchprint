package pitouchprint.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 29.12.2014.
 */
public class NumberChooser extends JPanel {
    private int number = 1;
    private int minimum, maximum;
    private JLabel numberlabel;
    private JButton lessbtn, morebtn;


    public NumberChooser(String title, int minimum, int maximum) {
        super(new BorderLayout(10, 10));
        validate(minimum, maximum);
        this.maximum = maximum;
        this.minimum = minimum;
        this.numberlabel = new JLabel(Integer.toString(this.number));
        this.lessbtn = new JButton(Strings.backbtnlabel);
        this.morebtn = new JButton(Strings.forwardbtnlabel);


        this.lessbtn.addActionListener(l -> {
            this.morebtn.setEnabled(true);
            this.number--;                  //It is quite possible that we use this sloppily here and should put a NumberChooser. before every this
            this.numberlabel.setText(Integer.toString(this.number));
            if (this.number <= this.minimum)
                this.lessbtn.setEnabled(false);
        });
        this.morebtn.addActionListener(l -> {
            this.lessbtn.setEnabled(true);
            this.number++;
            this.numberlabel.setText(Integer.toString(this.number));
            if (this.number >= this.maximum)
                this.morebtn.setEnabled(false);
        });
        this.lessbtn.setEnabled(false);
        this.lessbtn.setPreferredSize(new Dimension(120, 180));
        this.morebtn.setPreferredSize(new Dimension(120, 180));
        this.lessbtn.setFont(new Font(Style.fontname, Font.BOLD, Style.largefont));
        this.morebtn.setFont(new Font(Style.fontname, Font.BOLD, Style.largefont));
        this.numberlabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.numberlabel.setFont(new Font(Style.fontname, Font.PLAIN, Style.largefont));
        JLabel titlelabel = new JLabel(title);
        titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlelabel.setFont(new Font(Style.fontname, Font.PLAIN, Style.mediumfont));
        JPanel middlepanel = new JPanel(new BorderLayout(10, 10));
        if (title != null)
            middlepanel.add(titlelabel, BorderLayout.NORTH);
        middlepanel.add(this.numberlabel, BorderLayout.CENTER);

        this.add(middlepanel, BorderLayout.CENTER);
        this.add(this.lessbtn, BorderLayout.WEST);
        this.add(this.morebtn, BorderLayout.EAST);
        this.number = this.minimum;
    }

    public int getNumber() {
        return this.number;
    }

    public void setMinimum(int minimum) {
        validate(minimum, this.maximum);
        this.minimum = minimum;
    }

    public void setMaximum(int maximum) {
        validate(this.minimum, maximum);
        this.maximum = maximum;
    }

    public static void validate(int minimum, int maximum) {
        if (minimum <= 0)
            throw new IllegalArgumentException("Minimum must be at least 1");
        if (maximum <= 0)
            throw new IllegalArgumentException("Maximum must be at least 1");
        if (minimum > maximum)
            throw new IllegalArgumentException("Minimum is more than maximum");
    }
}
