import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

public class HintTest {

    @Test
    public void testNumGen() {
        HintManager hintManager = new HintManager();
        String generatedNum = hintManager.numGen();

        // Check if the length of the generated string is 3
        assertEquals(3, generatedNum.length());

        // Check if all characters in the string are unique
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : generatedNum.toCharArray()) {
            uniqueChars.add(c);
        }
        assertEquals(3, uniqueChars.size());
    }

}