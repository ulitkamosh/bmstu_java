package Lab3.Lab3_var4;

public class Hospital {
    public static void main(String[] args) {
        Patient patient1 = new Patient("olex");
        Doctor doctor1 = new Doctor("doctor1");
        Doctor doctor2 = new Doctor("doctor2");

        Doctor.Drug arbidol = new Doctor.Drug("arbidol");
        Doctor.Drug arbidol1 = new Doctor.Drug("arbidol2");

        doctor1.writePrescriptionDrug(arbidol, patient1);
        patient1.setCurrentlyInHospital();

    }
}
