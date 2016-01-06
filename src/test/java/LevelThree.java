import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Misc. complicated operations
 *
 * @author Jeremy Mefford
 * @since 1/5/16
 */
public class LevelThree {

    private String getCategory(int i) {
        switch (i % 3) {
            case 0:
                return "BLUE";
            case 1:
                return "GREEN";
            case 2:
                return "ORANGE";
            default:
                // this is not possible
                return null;
        }
    }

    @Test
    public void testOne() {
        //given
        Stream<TestBean> start = IntStream.range(1, 100)
                .mapToObj(i -> new TestBean(i, getCategory(i)));


        //when i collect them by category
//        Map<String, List<TestBean>> end = null;
        Map<String, List<TestBean>> end = start
                .collect(Collectors.groupingBy(TestBean::getCategory));

        //then
        Assert.assertEquals(3, end.size());
        Assert.assertEquals(33, end.get("BLUE").size());
        Assert.assertEquals(33, end.get("GREEN").size());
        Assert.assertEquals(33, end.get("ORANGE").size());
    }


    @Test
    public void testTwo() {
        //given
        Stream<TestBean> start = IntStream.range(1, 100)
                .mapToObj(i -> new TestBean(i, getCategory(i)))
                .map(bean -> bean.setSubIds(IntStream.range(0, 10).mapToObj(Integer::valueOf).collect(Collectors.toList())));

        //when i get all of the even GREEN subIds in all of the given test beans
        //hint. use flatMap
//        List<Integer> ids = null;
        List<Integer> ids = start.filter(bean -> "GREEN".equals(bean.getCategory()))
                .map(TestBean::getSubIds)
                .flatMap(Collection::stream)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        //then
        Assert.assertEquals(165, ids.size());
        Assert.assertEquals(Sets.newHashSet(0, 2, 4, 6, 8), new HashSet<>(ids));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testThree() {
        //given
        Stream<TestBean> start = IntStream.range(1, 100)
                .mapToObj(i -> new TestBean(i, getCategory(i)));

        //when i get all of the ids and return an immutable (unmodifiable) list
        //hint. use collectingAndThen
//        List<Integer> ids = null;
        List<Integer> ids = start
                .map(TestBean::getId)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        //then
        Assert.assertEquals(99, ids.size());
        ids.add(1); // this should throw and not execute the next line
        Assert.fail();
    }

    /**
     * @see Predicate#or(Predicate)
     * @see LevelTwo#hasWholeRoot(int)
     */
    @Test
    public void testFour() {
        //given
        Stream<TestBean> start = IntStream.range(1, 100)
                .mapToObj(i -> new TestBean(i, getCategory(i)));

        //when i chain together predicates to find all of the ids that are even and less than 25 or that have a whole number square root (eg, 4 is even, 9 has a whole square root)
        //basically (id < 25 && id % 2 == 0) || (id has whole root)
        //do not use multiple filter lines, create one predicate and use it
        //hint. look at predicate's default methods
        //hint. use the static helper from LevelTwo
//        Predicate<TestBean> predicate = null;
        Predicate<TestBean> predicate = bean -> bean.getId() % 2 == 0;
        predicate = predicate.and(bean -> bean.getId() < 25);
        predicate = predicate.or(bean -> LevelTwo.hasWholeRoot(bean.getId()));

        List<Integer> ids = start
                .filter(predicate)
                .map(TestBean::getId)
                .collect(Collectors.toList());

        //then
        Assert.assertEquals(Arrays.asList(1, 2, 4, 6, 8, 9, 10, 12, 14, 16, 18, 20, 22, 24, 25, 36, 49, 64, 81), ids);
    }
}
