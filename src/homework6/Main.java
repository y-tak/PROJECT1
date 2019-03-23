package homework6;

public class Main {
    public static void main(String[] args) {
        Pupil pupil = new Pupil("1324");
        String ex[] = {"Математика","Биология"};
        int marks[] = { 2, 5 };
        pupil.setExamResults(ex, marks);
        System.out.println(pupil);

    }
}
