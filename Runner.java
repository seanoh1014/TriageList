import java.util.*;

public class Runner {

    public static void main(String[] args) {

        TriageList triage = new TriageList();

        triage.addPatient("Nalla",  1);
        triage.addPatient("Harsha", 3);
        triage.addPatient("Ryan",   1);
        triage.addPatient("Nisha",  3);
        triage.addPatient("Andrew", 1);
        triage.addPatient("shreya", 2);

        System.out.println();
        System.out.println("Expected: [1-Nalla, 1-Ryan, 1-Andrew, 2-shreya, 3-Harsha, 3-Nisha]");
        System.out.println("Actual:   " + triage); 

        System.out.println();
        System.out.println("Expected: P1:3, P2:1, P3:2");
        System.out.println("Actual:   " + triage.triageCount());

        System.out.println();
        System.out.println("Expected: 1\t\tActual: " + triage.contains("Nalla"));      // 1
        System.out.println("Expected: 3\t\tActual: " + triage.contains("Nisha"));      // 3
        System.out.println("Expected: Nalla\t\tActual: " + triage.treatNextPatient()); // Nalla
        System.out.println("Expected: -1\t\tActual: " + triage.contains("Nalla"));     // -1
        System.out.println("Expected: Ryan\t\tActual: " + triage.treatNextPatient());  // Ryan
        System.out.println("Expected: Andrew\tActual: " + triage.treatNextPatient());  // Andrew
        System.out.println("Expected: Shreya\tActual: " + triage.treatNextPatient());  // Shreya

        triage.addPatient("Rithvik", 1);
        triage.addPatient("Tanvi",   2);

        System.out.println();
        System.out.println("Expected: [1-Rithvik, 2-Tanvi, 3-Harsha, 3-Nisha]");
        System.out.println("Actual:   " + triage);

        System.out.println();
  }
}
