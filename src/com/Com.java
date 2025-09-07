package com;
import java.util.*;

public class Com {
    
    private final String moduleName;
    private ArrayList<ComIPdu> comIPdus = new ArrayList<>();

    // Constructor
    public Com() {
        this.moduleName = "Com";
    }

    // Getters and Setters
    public String getModuleName() {
        return moduleName;
    }

    public void addComIPdu(ComIPdu comIPdu) {
        comIPdus.add(comIPdu);
    }

    public ArrayList<ComIPdu> getComIPdus() {
        return comIPdus;
    }

    @Override
    public String toString() {
        return "Com{" +
                "moduleName='" + moduleName + '\'' +
                ", comIPdus=" + comIPdus +
                '}';
    }
}
