package can;
import ecuc.EcucPdu;

public class CanIfPduCfg {
    
    private final String canIfPduName;
    private final EcucPdu ecucPduRef;
    private final String pduDirection; // "Rx" or "Tx"

    // Constructor
    public CanIfPduCfg(EcucPdu ecucPduRef, String direction) {
        this.canIfPduName = "CanIfPdu_" + direction + "_" + ecucPduRef.getPduName();
        this.ecucPduRef = ecucPduRef;
        this.pduDirection = direction;
    }

    // Getters and Setters
    public String getCanIfPduName() {
        return canIfPduName;
    }
    public EcucPdu getEcucPduRef() {
        return ecucPduRef;
    }
    public String getPduDirection() {
        return pduDirection;
    }

    @Override
    public String toString() {
        return "CanIfPduCfg{" +
                "canIfPduName='" + canIfPduName + '\'' +
                ", ecucPduRef=" + ecucPduRef +
                ", pduDirection='" + pduDirection + '\'' +
                '}';
    }
}
