import com.sun.javaws.IconUtil;

import javax.swing.plaf.IconUIResource;
import java.io.Serializable;
import java.math.BigInteger;

public class Solution70 {
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;

        }else{
            int twoNumber = n / 2;
            boolean haveMore = (n % 2 == 0) ? false  : true;
            int res = 0;
            for (int i = 1; i < twoNumber; i++) {
                res += (cResult(twoNumber, i)) * (i+1);
            }
            res += haveMore ? (1) * (twoNumber+1) : (1);
            res += 1;
            return res;
        }

    }
    public static int cResult(int n, int m){
        int res;
        BigInteger res1;
        res1 = jiecheng(n).divide((jiecheng(m).multiply(jiecheng(n-m))));
        res = Integer.valueOf(res1.toString());
        return res;

    }

    public static BigInteger jiecheng(int a){
        if (a == 0){
            return BigInteger.valueOf(1);
        }
        BigInteger res  = BigInteger.valueOf(a);
        BigInteger cur = BigInteger.valueOf(--a);
        while(a > 1){
            res =  res.multiply(cur);
            cur = BigInteger.valueOf(--a);
        }
        return res;
    }

    public static void main(String[] args) {
        int i = climbStairs(10);
        System.out.println(i);
        for (int i1 = 0; i1 < 10; i1++) {
            System.out.println(jiecheng(i1));
        }
    }
}
