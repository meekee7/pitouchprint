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
    private Mode mode;
    private NumberChooser correspondant;

    public NumberChooser(Mode mode, String title, int minimum, int maximum) {
        super(new BorderLayout(10, 10));
        validate(minimum, maximum);
        this.mode = mode;
        this.maximum = maximum;
        this.minimum = minimum;
        this.numberlabel = new JLabel(Integer.toString(this.number));
        this.lessbtn = new JButton(Strings.backbtnlabel);
        this.morebtn = new JButton(Strings.forwardbtnlabel);

        this.lessbtn.addActionListener(l -> {
            this.setNumber(--this.number);
            this.correspond();
        });
        this.morebtn.addActionListener(l -> {
            this.setNumber(++this.number);
            this.correspond();
        });

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

    public static void validate(int minimum, int maximum) {
        if (minimum <= 0)
            throw new IllegalArgumentException("Minimum must be at least 1");
        if (maximum <= 0)
            throw new IllegalArgumentException("Maximum must be at least 1");
        if (minimum > maximum)
            throw new IllegalArgumentException("Minimum is more than maximum");
    }

    public void setCorrespondant(NumberChooser correspondant) {
        this.correspondant = correspondant;
        switch (this.mode) {
            case LOWER:
                this.setMaximum(correspondant.getNumber());
                break;
            case UPPER:
                this.setMinimum(correspondant.getNumber());
        }
    }

    public int getNumber() {
        return this.number;
    }

    private void setNumber(int number) {
        this.number = number;
        this.numberlabel.setText(Integer.toString(number));
    }

    public void setMinimum(int minimum) {
        validate(minimum, this.maximum);
        this.minimum = minimum;
        this.setButtonState();
        if (minimum >= this.number)
            this.setNumber(minimum);
    }

    public void setMaximum(int maximum) {
        validate(this.minimum, maximum);
        this.maximum = maximum;
        this.setButtonState();
        if (maximum <= this.number)
            this.setNumber(maximum);
    }

    private void setButtonState() {
        this.lessbtn.setEnabled(this.number > this.minimum);
        this.morebtn.setEnabled(this.number < this.maximum);
    }

    private void correspond() {
        switch (this.mode) {
            case UPPER:
                this.correspondant.setMaximum(this.number);
                break;
            case LOWER:
                this.correspondant.setMinimum(this.number);
                break;
        }
        this.setButtonState();
    }

    public static enum Mode {ALONE, LOWER, UPPER}
}
