import main.StreamIteration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Math.abs;

class StreamIterationTest {
    static double t(double x){
        return x * x * x;
    }

    @Test
    void testStreamIteration(){
        /*List<Double> list = StreamIteration.streamIteration(
                (x) -> (x*x*x - 2.0) / (3.0),
                1.0,
                (x, xNew) -> abs(x - xNew) < (double)Float.MIN_VALUE,
                1000
        );*/
        //System.out.println(t(list.get(9999)));
        StreamIteration.fibo(10).forEach(
                System.out::println
        );
    }
}
