package pdur;
import java.util.*;

public class PduR {

    // Attributes
    private final String moduleName;
    private ArrayList<PduRRoutingPath> pduRRoutingPaths = new ArrayList<>();
    private ArrayList<PduRSrcPdu> pduRSrcPdus = new ArrayList<>();
    private ArrayList<PduRDestPdu> pduRDestPdus = new ArrayList<>();

    // Constructor
    public PduR() {
        this.moduleName = "PduR";
    }

    // Getters and Setters
    public String getModuleName() {
        return moduleName;
    }

    public void addPduRSrcPdu(PduRSrcPdu pduRSrcPdu) {
        this.pduRSrcPdus.add(pduRSrcPdu);
    }

    public ArrayList<PduRSrcPdu> getPduRSrcPdus() {
        return pduRSrcPdus;
    }

    public void addPduRDestPdu(PduRDestPdu pduRDestPdu) {
        this.pduRDestPdus.add(pduRDestPdu);
    }

    public ArrayList<PduRDestPdu> getPduRDestPdus() {
        return pduRDestPdus;
    }

    public void addPduRRoutingPath(PduRRoutingPath pduRRoutingPath) {
        this.pduRRoutingPaths.add(pduRRoutingPath);
    }

    public ArrayList<PduRRoutingPath> getPduRRoutingPaths() {
        return pduRRoutingPaths;
    }

    @Override
    public String toString() {
        return "PduR{" +
                "moduleName='" + moduleName + '\'' +
                ", pduRRoutingPaths=" + pduRRoutingPaths +
                ", pduRSrcPdus=" + pduRSrcPdus +
                ", pduRDestPdus=" + pduRDestPdus +
                '}';
    }
}
