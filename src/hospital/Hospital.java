package hospital;

import lesson8.LinkedList;

public class Hospital
{
    Reg[] regs=new Reg[12];
   LinkedList<Doctor> doctors;

    public void addDoctor(Doctor doctor)
   {
       doctors.add(doctor);

   }

    public Reg[] getRegs() {
        return regs;
    }

    public void setRegs(Reg[] regs) {
        this.regs = regs;
    }

    public LinkedList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(LinkedList<Doctor> doctors) {
        this.doctors = doctors;
    }
}
