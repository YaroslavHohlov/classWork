import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

class LeftJoinOperatorTest {
    @Test
    void join() {
//        Test1
        Collection leftCollection = Arrays.asList(new DataRow(0, "Ukraine"), new DataRow(1, "Germany"), new DataRow(2, "France"));
        Collection rightCollection = Arrays.asList(new DataRow(0, "Kyiv"), new DataRow(1, "Berlin"), new DataRow(3, "Budapest"));

        LeftJoinOperator leftJoin = new LeftJoinOperator();
        Collection result = leftJoin.join(leftCollection, rightCollection);
        Assertions.assertEquals("[[0, Ukraine, Kyiv], [1, Germany, Berlin], [2, France, null]]", result.toString());
        //        Test2
        leftCollection = Arrays.asList(new DataRow("abs", "Ukraine"), new DataRow((byte) 0, "Germany"), new DataRow('g', "France"), new DataRow(5.67, "Greece"));
        rightCollection = Arrays.asList(new DataRow("abs", "Kyiv"), new DataRow((byte) 0, "Berlin"), new DataRow(5.6, "Budapest"));

        leftJoin = new LeftJoinOperator();
        result = leftJoin.join(leftCollection, rightCollection);
        Assertions.assertEquals("[[abs, Ukraine, Kyiv], [0, Germany, Berlin], [g, France, null], [5.67, Greece, null]]", result.toString());

//        Test3
        int[] arr1 = {1, 1, 1};
        int[] arr2 = {1, 1, 1};
        int[] arr3 = {1, 1, 3};
        int[] arr4 = {1, 1, 1};
        leftCollection = Arrays.asList(new DataRow(arr1, "Ukraine"), new DataRow(arr2, "Germany"), new DataRow(arr3, "France"), new DataRow(arr4, "Kropyvnytskiy"));
        rightCollection = Arrays.asList(new DataRow(arr1, "Kyiv"), new DataRow(arr3, "Berlin"), new DataRow(arr2, "Budapest"), new DataRow(arr1, "Lviv"), new DataRow(arr1, "Rivne"));

        leftJoin = new LeftJoinOperator();
        result = leftJoin.join(leftCollection, rightCollection);
        Assertions.assertEquals("[[" + arr1 + ", Ukraine, Kyiv], [" + arr1 + ", Ukraine, Lviv], [" + arr1 + ", Ukraine, Rivne], [" + arr2 + ", Germany, Budapest], [" + arr3 + ", France, Berlin], [" + arr4 + ", Kropyvnytskiy, null]]", result.toString());
    }

}
