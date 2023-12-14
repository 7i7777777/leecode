package random.Dec06;

public class MySqrt {

    /*
    * 给你一个非负整数 x ，计算并返回x的算术平方根,由于返回类型是整数，结果只保留整数部分，小数部分将被舍去,
    注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
    eq: 0->0    1->1    4->2    8->2
    * */

//    public static int mySqrt(int x) {
//        int asr = 1;
//        for (int i = 0; i <= x / 2; i++) {
//            if (i * i <= x && (i + 1) * (i + 1) > x) {
//                asr = i;
//            }
//        }
//
//        return asr;
//    }

    //二分查找法
    public int mySqrt(int x){
        int l=0,r=x,ans=-1;
        while(l<=r){
            int mid = l+(r-1)/2;
            if((long)mid*mid<=x){
                ans = mid;
                l = mid+1;
            }else {
                r=mid-1;
            }
        }
        return ans;
    }
    //牛顿迭代
    public int mySqrt1(int x){
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

}