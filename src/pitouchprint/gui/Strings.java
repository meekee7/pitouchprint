package pitouchprint.gui;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Michael on 21.12.2014.
 */
@XmlRootElement
public class Strings {
    //TODO read the strings from an xml file

    @XmlElement
    public static String windowtitle = "PiTouchPrint 1.0";
    @XmlElement
    public static String backbtnlabel = "<";//"Zurück";
    @XmlElement
    public static String forwardbtnlabel = ">";//"Vor";
    public static String orientationtitle = "Ausrichtung";
    public static String copiestitle = "Anzahl Kopien";
    public static String filechoicetitle = "Datei auswählen";
    public static String startprintingtitle = "Druck starten";
}
