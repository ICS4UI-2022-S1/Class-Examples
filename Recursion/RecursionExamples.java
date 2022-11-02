
public class RecursionExamples{

    // recursive fib
    public static int fibNum(int n){
        // base case(s)
        if(n <= 1){
            return n;
        }
        // recursive call
        return fibNum(n-1) + fibNum(n-2);
    }

    // natural sum solution (also triangle num :))
    public static int naturalSum(int n){
        // base case
        if(n == 1){
            return 1;
        }
        // recursive call
        return naturalSum(n-1) + n;
    }

    public static void main(String[] args){
        // testing purposes
        int fibAnswer = fibNum(6);
        System.out.println(fibAnswer);
        // testing natural sum
        int naturalSumTest = naturalSum(5);
        System.out.println(naturalSumTest);
    }
}