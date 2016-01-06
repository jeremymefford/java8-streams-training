import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * Collections and transformations
 *
 * @author Jeremy Mefford
 * @since 1/5/16
 */
public class LevelOne {

    final Random usedInNumberEleven = new Random(123456L);

    @Test
    public void testOne() {
        // given
        List<Integer> start = Arrays.asList(1, 2, 3, 4, 5);

        // when i square every element in the list
        List<Integer> end = null;

        // then
        Assert.assertEquals(Arrays.asList(1, 4, 9, 16, 25), end);
    }

    @Test
    public void testTwo() {
        // given
        List<Integer> start = Arrays.asList(1, 2, 3, 4, 5);

        // when i take the log base 2 of each number
        List<Double> end = null;

        // then
        Assert.assertEquals(Arrays.asList(0.0, 0.6931471805599453, 1.0986122886681098, 1.3862943611198906, 1.6094379124341003), end);
    }

    @Test
    public void testThree() {
        // given
        List<String> start = Arrays.asList("asdf", "jkl;", "qwerty", null, "foobar");

        // when i transform each string to upper case
        List<String> end = null;

        // then
        Assert.assertEquals(Arrays.asList("ASDF", "JKL;", "QWERTY", "FOOBAR"), end);
    }

    @Test
    public void testFour() {
        // given
        List<String> start = Arrays.asList("asdf", "asdf", "asdf", "asdf");

        // when i deduplicate this list
        Set<String> end = null;

        // then
        Assert.assertEquals(Sets.newHashSet("asdf"), end);
    }

    @Test
    public void testFive() {
        // given
        List<String> start = Arrays.asList("asdf", "asdf", "asdf", "asdf");

        // when i deduplicate this list
        LinkedList<String> end = null;

        // then
        Assert.assertEquals(new LinkedList<>(Collections.singleton("asdf")), end);
    }

    @Test
    public void testSix() {
        // given
        List<String> start = Arrays.asList("a", "ab", "abc", "abcd");

        // when i map the string to it's length
        Map<String, Integer> end = null;

        // then
        Assert.assertEquals(new HashMap<String, Integer>() {{
            put("a", 1);
            put("ab", 2);
            put("abc", 3);
            put("abcd", 4);
        }}, end);
    }

    @Test
    public void testSeven() {
        // given
        List<Integer> start = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when i find all of the even numbers
        List<Integer> end = null;

        // then
        Assert.assertEquals(Arrays.asList(2, 4, 6), end);
    }

    private String repeatBySoManyNumbers(int i) {
        StringBuilder ret = new StringBuilder();
        for (int x = 0; x < i; x++) {
            ret.append(String.valueOf(i));
        }
        return ret.toString();
    }

    @Test
    public void testEight() {
        // given
        List<Integer> start = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // when i find all of the even numbers
        // and create strings containing that number repeated by it's value (eg, 2 -> "22", 4 -> "4444")
        // hint. use the repeatBySoManyNumbers() method
        List<Integer> end = null;

        // then
        Assert.assertEquals(Arrays.asList("22", "4444", "666666", "88888888", "10101010101010101010"), end);
    }


    @Test
    public void testNine() {
        // given
        List<Integer> start = Arrays.asList(1, 2, 3, 4, 5);
        List<String> dest = new ArrayList<>();

        // when i move odd numbers from start to dest (an existing collection) using streams
        // the numbers should be a string in dest (eg, 1 -> "1")
        // do not use an intermediate collection (no calls to .collect())

        // then
        Assert.assertEquals(Arrays.asList("1", "3", "5"), dest);
    }

    private class TestTenHelper {
        private String usefulMethod(int i) {
            return "echo: " + i;
        }
    }

    @Test
    public void testTen() {
        // given
        List<Integer> start = Arrays.asList(1, 2);
        TestTenHelper helper = new TestTenHelper();

        // when i use helper to collect items in start
        // hint. should use a method reference here
        List<String> end = null;

        // then
        Assert.assertEquals(Arrays.asList("echo: 1", "echo: 2"), end);
    }

    public Long generatorSupplier() {
        long curr = usedInNumberEleven.nextLong();
        return curr++ % 3L == 0 ? null : curr;
    }

    @Test
    public void testEleven() {
        // given
        Stream<Long> nullGeneratingStream = Stream.generate(this::generatorSupplier);

        // find how many null elements there are in the first 1000 elements
        // ex. credit. log every element to system out
        long count = -1L;

        // then
        Assert.assertEquals(364, count);
    }
}