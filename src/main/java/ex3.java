import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ex3 {
    public static void main(String[] args) {
        int count = 2;
        List<BigDecimal> f = new ArrayList<>();
        f.add(new BigDecimal(1));
        f.add(new BigDecimal(3));
        int n = 2;
        while(count != 40){
            f.add(new BigDecimal(5).multiply(f.get(n-1)).add(f.get(n-2)));
            if(!isEven(f.get(n))){
                count++;
            }
            n++;
        }
        System.out.println(f.getLast());

    }
    public static boolean isEven(BigDecimal number) {
        BigInteger intVal = number.toBigIntegerExact();
        return intVal.mod(BigInteger.TWO).equals(BigInteger.ZERO);
    }
}

/**
 * Функция 𝑓(𝑛) задается рекурсивно формулой 𝑓(𝑛) = 5 𝑓(𝑛 − 1) + 𝑓(𝑛 − 2).
 * В массив А сохраняются только нечетные значения функции 𝑓(𝑛).
 * Вычислите А[39] − 40-й элемент массива А, если 𝑓(0) = 1, 𝑓(1) = 3.
 */