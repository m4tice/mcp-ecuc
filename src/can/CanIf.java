package can;
import java.util.*;

public class CanIf {
    
    // Attributes
    private HashMap<String, CanIfChannel> canIfChannels;

    public CanIf() {
        this.canIfChannels = new HashMap<>();
    }

    // Getters and Setters
    public HashMap<String, CanIfChannel> getCanIfChannels() {
        return canIfChannels;
    }

    public CanIfChannel getCanIfChannel(String channelName) {
        return canIfChannels.get(channelName);
    }

    public void addCanIfChannel(String channelName, CanIfChannel channel) {
        this.canIfChannels.put(channelName, channel);
    }

    @Override
    public String toString() {
        return "CanIf{" +
                "canIfChannels=" + canIfChannels +
                '}';
    }
}
