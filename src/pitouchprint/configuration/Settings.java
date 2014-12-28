package pitouchprint.configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;

/**
 * Created by Michael on 21.12.2014.
 */
@XmlRootElement
public class Settings {
    public static Settings currentsettings = null;
    private static Unmarshaller unmarshaller = null;


    public static void readFromFile() throws JAXBException, IOException {
        if (unmarshaller == null)
            unmarshaller = JAXBContext.newInstance(Settings.class).createUnmarshaller();
        //currentsettings = (Settings) unmarshaller.unmarshal(Files.newInputStream(Paths.get("settings.xml"), StandardOpenOption.READ));
    }

    //@XmlElement
    private String mediadirectory = null;

    //@XmlElement
    public String getMediadirectory() {
        return this.mediadirectory;
    }

    //@XmlElement
    public void setMediadirectory(String mediadirectory) {
        this.mediadirectory = mediadirectory;
    }
}
