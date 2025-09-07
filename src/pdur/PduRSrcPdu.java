package pdur;
import ecuc.EcucPdu;

public class PduRSrcPdu {

    private final String pduName;
    private final EcucPdu ecucPduRef;

    // Constructor
    public PduRSrcPdu(EcucPdu ecucPduRef) {
        this.pduName = "PduRSrcPdu_" + ecucPduRef.getPduName();
        this.ecucPduRef = ecucPduRef;
    }

    // Getters and Setters
    public String getPduName() {
        return pduName;
    }

    public EcucPdu getEcucPduRef() {
        return ecucPduRef;
    }

    @Override
    public String toString() {
        return "PduRSrcPdu{" +
                "pduName='" + pduName + '\'' +
                ", ecucPduRef=" + ecucPduRef +
                '}';
    }
}