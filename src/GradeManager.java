public class GradeManager {

    public static String[] reverseStudentNames(String[] names) {
        String[] reversed = new String[names.length];

        for (int i = 0; i < names.length; i++) {
            String original = names[i];
            String reversedName = new StringBuilder(original).reverse().toString();
            reversed[i] = reversedName;
        }

        return reversed;
    }

    public static char getLetterGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }

    public static String[] findFailingStudents(String[] names, int[] scores) {
        int failCount = 0;
        for (int score : scores) {
            if (score < 60) failCount++;
        }

        String[] failing = new String[failCount];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failing[index] = names[i];
                index++;
            }
        }

        return failing;
    }

    public static void main(String[] args) {
        String[] students = {"Abdullah", "Mohammed", "Daniyel", "Nut"};
        int[] scores = {95, 67, 45, 78};

        System.out.println("Reversed names");
        String[] reversedNames = reverseStudentNames(students);
        for (String name : reversedNames) {
            System.out.println(name);
        }

        System.out.println("Letter grades");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + " " + getLetterGrade(scores[i]));
        }

        System.out.println("Failing students");
        String[] failing = findFailingStudents(students, scores);
        for (String name : failing) {
            System.out.println(name);
        }
    }
}
