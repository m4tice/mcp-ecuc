package pdur;
import ecuc.EcucPdu;

public class PduRDestPdu {

    private final String pduName;
    private final EcucPdu ecucPduRef;

    // Constructor
    public PduRDestPdu(EcucPdu ecucPduRef) {
        this.pduName = "PduRDestPdu_" + ecucPduRef.getPduName();
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
        return "PduRDestPdu{" +
                "pduName='" + pduName + '\'' +
                ", ecucPduRef=" + ecucPduRef +
                '}';
    }

}
