package pitouchprint.printing;

/**
 * Created by Michael on 22.12.2014.
 */
public class PrintJob {
    public static PrintJob currentJob = new PrintJob();
    private boolean landscape = false;
    private int copies = 1;
    private String filepath = null;
    private int frompage = 1;
    private int topage = 1;

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

    public int getFrompage() {
        return frompage;
    }

    public void setFrompage(int frompage) {
        this.frompage = frompage;
    }

    public int getTopage() {
        return topage;
    }

    public void setTopage(int topage) {
        this.topage = topage;
    }
}
