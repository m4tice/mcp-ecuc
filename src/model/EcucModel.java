package model;

import can.CanIf;
import can.CanIfChannel;
import can.CanIfPduCfg;
import com.Com;
import com.ComIPdu;
import ecuc.EcucPdu;
import pdur.PduR;
import pdur.PduRDestPdu;
import pdur.PduRRoutingPath;
import pdur.PduRSrcPdu;

public class EcucModel {

    // Attributes
    private final Com com;
    private final CanIf canIf;
    private final PduR pduR;

    // Constructor
    public EcucModel() {
        this.com = new Com();
        this.canIf = new CanIf();
        this.pduR = new PduR();
    }

    public Com getCom() {
        return com;
    }

    public CanIf getCanIf() {
        return canIf;
    }

    public PduR getPduR() {
        return pduR;
    }

    @Override
    public String toString() {
        return "EcucModel{" +
                "com=" + com +
                ", canIf=" + canIf +
                ", pduR=" + pduR +
                '}';
    }

    /**
     * Initialize the ECUC model with sample data
     */
    public void initialize() {
        // Initialize models

        // EcucPdus
        EcucPdu ESP_19 = new EcucPdu("ESP_19", 1, 8);
        EcucPdu TSK_07 = new EcucPdu("TSK_07", 2, 8);

        // Com
        // ComIPdus
        ComIPdu ComIPdu_ESP_19 = new ComIPdu(ESP_19, "Rx");
        this.com.addComIPdu(ComIPdu_ESP_19);

        ComIPdu ComIPdu_TSK_07 = new ComIPdu(TSK_07, "Tx");
        this.com.addComIPdu(ComIPdu_TSK_07);

        // CanIf
        // Can channels
        this.canIf.addCanIfChannel("PT_CAN", new CanIfChannel("PT_CAN"));
        this.canIf.addCanIfChannel("LP_CAN", new CanIfChannel("LP_CAN"));
        
        // CanIfPduCfgs
        CanIfPduCfg CanIfPduCfg_PT_CAN_ESP_19 = new CanIfPduCfg(ESP_19, "Rx");
        this.canIf.getCanIfChannel("PT_CAN").getCanIfPdus().add(CanIfPduCfg_PT_CAN_ESP_19);

        CanIfPduCfg CanIfPduCfg_LP_CAN_TSK_07 = new CanIfPduCfg(TSK_07, "Tx");
        this.canIf.getCanIfChannel("LP_CAN").getCanIfPdus().add(CanIfPduCfg_LP_CAN_TSK_07);

        // PduR
        // SrcPdus
        PduRSrcPdu PduRSrcPdu_ESP_19_CanIf2PduR = new PduRSrcPdu(ESP_19);
        this.pduR.addPduRSrcPdu(PduRSrcPdu_ESP_19_CanIf2PduR);
        
        PduRSrcPdu PduRSrcPdu_TSK_07_Com2PduR = new PduRSrcPdu(TSK_07);
        this.pduR.addPduRSrcPdu(PduRSrcPdu_TSK_07_Com2PduR);

        // DestPdus
        PduRDestPdu PduRDestPdu_ESP_19_PduR2Com = new PduRDestPdu(ESP_19);
        this.pduR.addPduRDestPdu(PduRDestPdu_ESP_19_PduR2Com);

        PduRDestPdu PduRDestPdu_TSK_07_PduR2CanIf_LP = new PduRDestPdu(TSK_07);
        this.pduR.addPduRDestPdu(PduRDestPdu_TSK_07_PduR2CanIf_LP);

        // RoutingPaths
        PduRRoutingPath PduRRoutingPath_ESP_19_CanIf2Com = new PduRRoutingPath(
                PduRSrcPdu_ESP_19_CanIf2PduR,
                PduRDestPdu_ESP_19_PduR2Com
        );
        this.pduR.addPduRRoutingPath(PduRRoutingPath_ESP_19_CanIf2Com);

        PduRRoutingPath PduRRoutingPath_TSK_07_Com2CanIf_LP = new PduRRoutingPath(
                PduRSrcPdu_TSK_07_Com2PduR,
                PduRDestPdu_TSK_07_PduR2CanIf_LP
        );
        this.pduR.addPduRRoutingPath(PduRRoutingPath_TSK_07_Com2CanIf_LP);
    }

    public static void main(String[] args) {
        EcucModel model = new EcucModel();
        model.initialize();
        System.out.println(model);
    }
}
