public class Test01 {
    public static void main(String[] args) {
        int a = 1, b = 1;
        long endTime1, endTime2;
        long startTime1 = System.currentTimeMillis();

        for (int i = 0; i < 300000000; i++) {
            a *= 2;
            a /=2;
        }
        endTime1 = System.currentTimeMillis();
        for (int i = 0; i < 300000000; i++) {
            a <<= 1;
            a >>= 1;
        }
        endTime2 = System.currentTimeMillis();

        long end1 = endTime1-startTime1;
        long end2 = endTime2 - endTime1;
        System.out.println("乘法的时间" + end1);
        System.out.println("位运算的时间" + end2);


    }
}
