package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName java8stream
 * @Description TODO
 * @Author 2+7
 * @Date 2023/3/8 17:07
 */
public class java8stream {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 4, 5, 5, 6, 7, 8, 2, 2, 2, 2);
        List<Integer> collect = integers.stream().limit(5).collect(Collectors.toList());
        System.out.println(integers);
        System.out.println(collect);
    }
}