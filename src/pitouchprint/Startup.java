package pitouchprint;

import pitouchprint.gui.MainWindow;

import javax.swing.*;

/**
 * Created by Michael on 21.12.2014.
 */
public class Startup {
    public static void main(String[] args) {
        //TODO
        try {                             //Set look-and-feel to system standard
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("An error occured when configuring the the look-and-feel.");
            e.printStackTrace();
        }

        /*try {
            Settings.readFromFile();
        } catch (JAXBException | IOException e) {
            //TODO handling
            e.printStackTrace();
        } */

        new MainWindow();
    }
}
