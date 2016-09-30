package Lambda;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Created by Administrator on 9/30/2016.
 */
public class Main {
    /*
        https://dzone.com/articles/functional-programming-java-8

        #Further Reader
        https://blog.informatech.cr/2014/04/04/jdk-8-interface-pollution/
     */

    public static void main(String[] args) {
        //1
        Integer x = 10;
        Integer res = mul3.apply(add1.apply(x)); //yields 33
        System.out.println(res);

        //2
        Integer res2 = sum.apply(1,2);
        System.out.println(res2);


        Optional<String> o = Optional.ofNullable(null);
        System.out.println(o+"adasd");
    }
    //1
    static Function<Integer,Integer> add1 = x -> x + 1;
    static Function<Integer,Integer> mul3 = x -> x * 3;
    //2
    static BinaryOperator<Integer> sum = (a,b) -> a + b;

}
