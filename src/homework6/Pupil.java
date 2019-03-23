package homework6;

import java.util.Arrays;

public class Pupil {
    private String id;
    private ExamResult[] examResults=new ExamResult[2];

    public Pupil(String id) {
        this.id = id;
    }

    public void setExamResults(String[] predmets,int[] values)
        {
        for (int i=0;i<predmets.length;i++){
           examResults[i]=new ExamResult(predmets[i],values[i]);
        }

        }

    @Override
    public String toString() {

        return "Студент " + id + '\n' + examResults[0]+'\n'+ examResults[1];
    }
}


////-----внутренний класс----------------------
 class ExamResult {
 private String Predmet;
 private int value;
 private boolean result;

     public ExamResult(String predmet, int value)
     {
         Predmet = predmet;
         this.value = value;
         this.result=getresult(value);

     }

     private boolean getresult(int value)
     {
         if (value<=2) return false;
         else return true;
     }

     @Override
     public String toString() {

          return  Predmet +" " + (result==false ? "не сдал":"сдал");
     }
 }