package pitouchprint.printing;

/**
 * Created by Michael on 27.12.2014.
 */
public interface CommandGenerator {
    public String makeCommand(PrintJob job);

    public void executeJob(PrintJob job);
}
