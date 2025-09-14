package ecuc;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EcucPduExtractorUtil {
        // Private constructor to prevent instantiation
    private EcucPduExtractorUtil() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
    
    /**
     * Finds a PduRSrcPdu by name in a list
     * Tags: Copilot
     * @param ecuPdus List of source PDUs to search
     * @param pduName Name of the PDU to find
     * @return The found EcucPdu or null if not found
     */
    public static EcucPdu findEcuPduByName(List<EcucPdu> ecucPdus, String pduName) {
        if (ecucPdus == null || pduName == null) {
            return null;
        }
        return ecucPdus.stream()
                .filter(pdu -> pduName.equals(pdu.getPduName()))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Gets the total count of PDUs in a EcucPduCollection module
     * Tags: Copilot
     * @param ecucPduCollection The EcucPduCollection instance
     * @return Total EcucPDU count
     */
    public static int getTotalPduCount(EcucPduCollection ecucPduCollection) {
        if (ecucPduCollection == null) {
            return 0;
        }
        return ecucPduCollection.getEcucPdus().size();
    }

    /**
     * Get all the EcucPdus from a EcucPduCollection module
     * Tags: Copilot
     * @param ecucPduCollection The EcucPduCollection instance
     * @return List of EcucPdus
     */
    public static List<EcucPdu> getAllEcucPdus(EcucPduCollection ecucPduCollection) {
        if (ecucPduCollection == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(ecucPduCollection.getEcucPdus());
    }
}
