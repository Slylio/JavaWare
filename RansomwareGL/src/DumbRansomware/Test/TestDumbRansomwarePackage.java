package DumbRansomware.Test;

import DumbRansomware.DumbCustomerReader;

public class TestDumbRansomwarePackage {
    public static void main(String[] args) {
        System.out.println("Test du Package DumbRansomware :");
        System.out.println("");
        System.out.println("Test DumbCustomerReader");
        DumbCustomerReader customreader = DumbCustomerReader.getInstance();
        System.out.println(customreader.toString());
        System.out.println("Liste des Properties :\n");
        customreader.showFullProperties();
    }
}
