package pitouchprint.configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Michael on 21.12.2014.
 */
@XmlRootElement
public class Settings {
    public static Settings currentsettings = null;
    private static Unmarshaller unmarshaller = null;
    private static final String settingsfilename = "settings.xml";


    public static void readFromFile() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Settings.class);
        if (unmarshaller == null)
            unmarshaller = context.createUnmarshaller();
        Path path = Paths.get(settingsfilename);
        if (Files.exists(path))
            currentsettings = (Settings) unmarshaller.unmarshal(Files.newInputStream(Paths.get(settingsfilename), StandardOpenOption.READ));
        else {
            currentsettings = new Settings();
            context.createMarshaller().marshal(currentsettings, Files.newOutputStream(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE));
        }
    }


    private boolean fullscreen = false;

    @XmlElement
    public boolean getFullscreen() {
        return this.fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    //@XmlElement
    private String mediadirectory = null;

    @XmlElement
    public String getMediadirectory() {
        return this.mediadirectory;
    }

    //@XmlElement
    public void setMediadirectory(String mediadirectory) {
        this.mediadirectory = mediadirectory;
    }


}
