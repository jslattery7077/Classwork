import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        ArrayList<Integer> newSet = new ArrayList<Integer>();
        for (int start = 0; start < numbers.size(); start++) {
            newSet.add(numbers.get(start));
            if (start + 1 < numbers.size()) {
                newSet.add(numbers.get(start+1));
                start++;
            }
            if (start+1 < numbers.size()) {
                newSet.add(numbers.get(start+1));
                start++;
            }
        }

        System.out.println(newSet.toString());
    }
}