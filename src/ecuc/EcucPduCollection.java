package ecuc;

import java.util.ArrayList;
import java.util.List;

public class EcucPduCollection {
    
    private List<EcucPdu> ecucPdus;

    public EcucPduCollection() {
        this.ecucPdus = new ArrayList<>();
    }

    public void addEcucPdu(EcucPdu pdu) {
        ecucPdus.add(pdu);
    }

    public List<EcucPdu> getEcucPdus() {
        return ecucPdus;
    }
}
