package pitouchprint.printing;

/**
 * Created by Michael on 22.12.2014.
 */
public class PrintJob {
    public static PrintJob currentJob = new PrintJob();
    private boolean landscape = false;
    private int copies = 1;
    private String filepath = null;

    public boolean isLandscape() {
        return landscape;
    }

    public int getCopies() {
        return copies;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setLandscape(boolean landscape) {
        this.landscape = landscape;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
