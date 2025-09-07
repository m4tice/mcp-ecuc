package ecuc;
public class EcucPdu {
    
    // Attributes
    private String pduName;
    private int pduId;
    private int pduLength;

    // Constructor
    public EcucPdu(String pduName, int pduId, int pduLength) {
        this.pduName = pduName;
        this.pduId = pduId;
        this.pduLength = pduLength;
    }

    // Getters and Setters
    public String getPduName() {
        return pduName;
    }

    public int getPduId() {
        return pduId;
    }

    public int getPduLength() {
        return pduLength;
    }

    @Override
    public String toString() {
        return "EcucPdu{" +
                "pduName='" + pduName + '\'' +
                ", pduId=" + pduId +
                ", pduLength=" + pduLength +
                '}';
    }
}
