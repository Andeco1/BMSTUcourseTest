import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ex2 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/data_prog_contest_problem_2.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.exit(1);
        }

        int size = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(in.nextInt());
        }

        Map<Integer, Integer> letters = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            letters.put(i, 0);
        }

        int begin = 0;
        int min = Integer.MAX_VALUE;

        for (int end = 0; end < size; end++) {
            letters.put(arr.get(end), letters.get(arr.get(end)) + 1);

            while (check(letters)) {
                min = Math.min(min, end - begin + 1);
                letters.put(arr.get(begin), letters.get(arr.get(begin)) - 1);
                begin++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println("NONE");
        } else {
            System.out.println(min);
        }
    }

    public static boolean check(Map<Integer, Integer> letters) {
        return !letters.containsValue(0);
    }
}
