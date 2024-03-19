import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HintManager {

    private String targetNum;
    
    public void numGen() {
        Random rand = new Random();
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            numbers.add(rand.nextInt(10));
        }
        String targetNum = "";
        for (Integer num : numbers) {
            targetNum += Integer.toString(num);
        }
        System.out.println(targetNum);
    }

    public char[] target() {
        return targetNum.toCharArray();
    }



}
