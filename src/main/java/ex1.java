import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ex1 {
    public static class Segment{
        Integer begin;
        Integer end;
        public Segment(Integer begin, Integer end) {
            this.begin = begin;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        File file = new File("src/main/resources/data_prog_contest_problem_1.txt");
        Scanner in = null;
        try{
            in = new Scanner(file);
        } catch (FileNotFoundException e){
            System.exit(1);
        }

        int size = in.nextInt();
        List<Segment> arr = new ArrayList<>();
        for(int i = 0; i < size; i++){
            Segment segment = new Segment(in.nextInt(), in.nextInt());
            arr.add(segment);
        }

        arr.sort((a,b) -> a.begin < b.begin ? -1 : 1);

        for(Segment segment : arr){
            System.out.println(segment.begin + " " + segment.end);
        }
        int count = 0;
        while(!arr.isEmpty()){
            arr = oneIteration(arr);
            count++;
        }
        System.out.println(count);
    }

    public static List<Segment> oneIteration(List<Segment> arr){
        List<Segment> newArr = new ArrayList<>();
        Segment currMin = arr.getFirst();
        for(Segment segment : arr){
            if(!((segment.begin >= currMin.begin && segment.begin <= currMin.end) || (segment.end >= currMin.begin && segment.end <= currMin.end))){
                newArr.add(segment);
            } else {
                if(currMin.begin < segment.begin) currMin.begin = segment.begin;
                if(currMin.end > segment.end) currMin.end = segment.end;
            }
        }
        return newArr;
    }
}
