package can;
import java.util.ArrayList;

public class CanIfChannel {
    
    private final String canIfChannelName;
    private ArrayList<CanIfPduCfg> canIfPdus = new ArrayList<>();

    // Constructor
    public CanIfChannel(String canIfChannelName) {
        this.canIfChannelName = "CanIf_" + canIfChannelName;
    }

    // Getters and Setters
    public String getCanIfChannelName() {
        return canIfChannelName;
    }

    public ArrayList<CanIfPduCfg> getCanIfPdus() {
        return canIfPdus;
    }

    public void addCanIfPdu(CanIfPduCfg canIfPduCfg) {
        canIfPdus.add(canIfPduCfg);
    }

    @Override
    public String toString() {
        return "CanIfChannel{" +
                "canIfChannelName='" + canIfChannelName + '\'' +
                ", canIfPdus=" + canIfPdus +
                '}';
    }
}
