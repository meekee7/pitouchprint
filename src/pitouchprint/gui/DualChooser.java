package pitouchprint.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michael on 11.01.2015.
 */
public class DualChooser extends JPanel {
    private NumberChooser lower, upper;
    private int minimum, maximum;

    public DualChooser(String lowertitle, String uppertitle, int minimum, int maximum) {
        super(new BorderLayout(10, 10));
        validate(minimum, maximum);
        this.minimum = minimum;
        this.maximum = maximum;
        this.lower = new NumberChooser(NumberChooser.Mode.LOWER, lowertitle, minimum, maximum);
        this.upper = new NumberChooser(NumberChooser.Mode.UPPER, uppertitle, minimum, maximum);
        this.lower.setCorrespondant(this.upper);
        this.upper.setCorrespondant(this.lower);
        this.add(lower, BorderLayout.NORTH);
        this.add(upper, BorderLayout.SOUTH);
    }

    public void setMinimum(int minimum) {
        validate(minimum, this.maximum);
        this.minimum = minimum;
        this.lower.setMinimum(minimum);
        this.upper.setMinimum(minimum);
    }

    public void setMaximum(int maximum) {
        validate(this.minimum, maximum);
        this.maximum = maximum;
        this.lower.setMaximum(maximum);
        this.upper.setMaximum(maximum);
    }

    public int getLowerValue() {
        return this.lower.getNumber();
    }

    public int getUpperValue() {
        return this.upper.getNumber();
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
