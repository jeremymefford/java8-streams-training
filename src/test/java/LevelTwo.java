import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 * Searching, optionals and reduction
 *
 * @author Jeremy Mefford
 * @since 1/5/16
 */
public class LevelTwo {

    public static boolean hasWholeRoot(int i) {
        double root = Math.sqrt(i);
        return (int) root == root;
    }

    @Test
    public void testOne() {
        // given
        List<Integer> start = Arrays.asList(2, 5, 12, 16, 23, 31);

        System.out.println("========= Starting Test One =========");
        // find the first number in the list that has a whole square root (eg. 9 has a whole root of 3)
        // bonus, log the numbers as the stream processes and see which elements are actually traversed.  is it all of them?
        Optional<Integer> hasWholeRoot = null;

        // then
        Assert.assertEquals(Optional.of(16), hasWholeRoot);
    }

    @Test
    public void testTwo() {
        // given
        List<Integer> start = Arrays.asList(3, 5, 13, 17, 23, 31);

        // find the first even number (no, you cannot modify the original sequence)
        // return it as the string version of itself, or null if not present
        Optional<String> end = null;

        // then
        Assert.assertEquals(Optional.ofNullable(null), end);
    }

    @Test
    public void testThree() {
        // given
        List<BigDecimal> start = Arrays.asList(
                new BigDecimal("1"),
                new BigDecimal("1.12345612341212351"),
                new BigDecimal("10.142"),
                new BigDecimal("-1.2"),
                new BigDecimal("100.56789")
        );

        // when i sum them all together
        BigDecimal end = null;

        // then
        Assert.assertEquals(new BigDecimal("111.63334612341212351"), end);
    }

    @Test
    public void testFour() {
        // given
        Stream<BigDecimal> start = Stream.of(
                new BigDecimal("1"),
                new BigDecimal("1.12345612341212351"),
                new BigDecimal("10.142"),
                new BigDecimal("-1.2"),
                new BigDecimal("100.56789"),
                null
        );

        // when i get the last non-null element in the stream
        // hint. use reduce
        BigDecimal end = null;

        // then
        Assert.assertEquals(new BigDecimal("100.56789"), end);
    }

    @Test
    public void testFive() {
        // given
        Stream<BigDecimal> start = Stream.of(
                new BigDecimal("1"),
                new BigDecimal("1.12345612341212351"),
                new BigDecimal("10.142"),
                new BigDecimal("-1.2"),
                new BigDecimal("100.56789")
        );

        // when i get the average of these big decimals as doubles
        // hint. use DoubleStream
        OptionalDouble avg = null;

        // then
        Assert.assertEquals(22.326669224682426, avg.getAsDouble(), 0.0);
    }
}
