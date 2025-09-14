package pdur;

import java.util.List;

/**
 * Static utility class for PduR operations.
 * This class provides common functionality for PduR extraction and manipulation
 * without requiring instantiation.
 */
public final class PdurExtractorUtil {
    
    // Private constructor to prevent instantiation
    private PdurExtractorUtil() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    /**
     * Finds a PduRSrcPdu by name in a list
     * Tags: Copilot
     * @param srcPdus List of source PDUs to search
     * @param pduName Name of the PDU to find
     * @return The found PduRSrcPdu or null if not found
     */
    public static PduRSrcPdu findSrcPduByName(List<PduRSrcPdu> srcPdus, String pduName) {
        if (srcPdus == null || pduName == null) {
            return null;
        }
        return srcPdus.stream()
                .filter(pdu -> pduName.equals(pdu.getPduName()))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Finds a PduRDestPdu by name in a list
     * Tags: Copilot
     * @param destPdus List of destination PDUs to search
     * @param pduName Name of the PDU to find
     * @return The found PduRDestPdu or null if not found
     */
    public static PduRDestPdu findDestPduByName(List<PduRDestPdu> destPdus, String pduName) {
        if (destPdus == null || pduName == null) {
            return null;
        }
        return destPdus.stream()
                .filter(pdu -> pduName.equals(pdu.getPduName()))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Gets the total count of PDUs in a PduR module
     * Tags: Copilot
     * @param pduR The PduR instance
     * @return Total PDU count (source + destination)
     */
    public static int getTotalPduCount(PduR pduR) {
        if (pduR == null) {
            return 0;
        }
        return pduR.getPduRSrcPdus().size() + pduR.getPduRDestPdus().size();
    }
}
