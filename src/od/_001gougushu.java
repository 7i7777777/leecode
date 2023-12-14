package od;


import java.util.Scanner;

/**
 * @ClassName _001gougushu
 * @Description TODO 如果三个正整数A、B、C ，A² + B² = C² 则为勾股数，
 * 如果ABC之间两两互质，即A与B，A与C，B与C均互质没有公约数，则称其为勾股数元组。
 * 请求出给定 n ~ m 范围内所有的勾股数元组。
 * @Author 2+7
 * @Date 2023/2/27 09:55
 */
public class _001gougushu {
    //寻找勾股数组
    public static void gougushu(int n, int m) {
        int d = -1;
        for (int a = n; a <= m; a++) {
            for (int b = a + 1; b <= m; b++) {
                for (int c = b + 1; c <= m; c++) {
                    if (a * a + b * b == c * c && gcd(a, b) == 1) {
                        System.out.println(a + " " + b + " " + c);
                        d = a;
                    }
                }
            }
        }
        if(d==-1){
            System.out.println("Na");
        }

    }

    //判断公约数
    public static int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        gougushu(n, m);
    }
}