package pdur;
public class PduRRoutingPath {
    
    private final PduRSrcPdu pduRSrcPduRef;
    private final PduRDestPdu pduRDestPduRef;

    // Constructor
    public PduRRoutingPath(PduRSrcPdu pduRSrcPdu, PduRDestPdu pduRDestPdu) {
        this.pduRSrcPduRef = pduRSrcPdu;
        this.pduRDestPduRef = pduRDestPdu;
    }

    // Getters and Setters
    public PduRSrcPdu getPduRSrcPduRef() {
        return pduRSrcPduRef;
    }

    public PduRDestPdu getPduRDestPduRef() {
        return pduRDestPduRef;
    }
    
    @Override
    public String toString() {
        return "PduRRoutingPath{" +
                "pduRSrcPduRef=" + pduRSrcPduRef +
                ", pduRDestPduRef=" + pduRDestPduRef +
                '}';
    }
}
