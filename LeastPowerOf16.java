public class LeastPowerOf16 {
    public static void main(String[] args) {
        System.out.println(findLeast());
    }

    static boolean notContainsDigit(long num, int d) {
        long val = num;
        while (val > 0) {
            if(val % 10 == d) {
                return false;
            }
            val = val / 10;
        }
        return true;
    }

    static boolean isValid(long num) {
        return notContainsDigit(num, 1) && notContainsDigit(num, 2) && notContainsDigit(num, 4) && notContainsDigit(num, 8);
    }
    
    static long findLeast() {
        long n = 16 * 16 * 16 * 16;
        while(true) {
            n = 16 * n;
            System.out.println(n);
            if (isValid(n)) {
                return n;
            }
        }
    }
}
