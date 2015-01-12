package pitouchprint.printing;

import pitouchprint.configuration.Settings;

import java.io.IOException;

/**
 * Created by Michael on 27.12.2014.
 */
public class LPCommandGenerator implements CommandGenerator {
    @Override
    public String makeCommand(PrintJob job) {
        StringBuilder sb = new StringBuilder();
        sb.append("lp ");
        //TODO the rest of the command building
        sb.append("-d ");
        sb.append(Settings.currentsettings.getPrinter()).append(' ');
        sb.append("-o fitplot ");
        //sb.append("-o");
        sb.append("-P ").append(job.getFrompage()).append(';').append(job.getTopage()).append(' ');

        sb.append(job.getFilepath());

        return sb.toString();
    }

    @Override
    public void executeJob(PrintJob job) {
        try {
            Process process = Runtime.getRuntime().exec(this.makeCommand(job));
            //TODO handle the process
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
