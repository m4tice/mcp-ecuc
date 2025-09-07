package com;
import ecuc.EcucPdu;

public class ComIPdu {
    
    private String name;
    private EcucPdu ecucPduRef;
    private final String pduDirection; // "Rx" or "Tx"

    // Constructor
    public ComIPdu(EcucPdu ecucPduRef, String direction) {
        this.name = "ComIPdu_" + direction + "_" + ecucPduRef.getPduName();
        this.ecucPduRef = ecucPduRef;
        this.pduDirection = direction;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public EcucPdu getEcucPduRef() {
        return ecucPduRef;
    }

    public String getPduDirection() {
        return pduDirection;
    }

    @Override
    public String toString() {
        return "ComIPdu{" +
                "name='" + name + '\'' +
                ", ecucPduRef=" + ecucPduRef +
                ", pduDirection='" + pduDirection + '\'' +
                '}';
    }   

}
