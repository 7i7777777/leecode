package random.May;

/**
 * @ClassName Main
 * @Description TODO 有一排瓷砖，红绿颜色，要重新喷涂。要求每个红色左边不能有绿的，求最小喷涂次数。
 * 比如rrrrgrr，修改一次
 * rgrgr，改成rrrgg，或者rrrrr修改两次
 * @Author 2+7
 * @Date 2023/5/24 15:32
 */
public class Main {

    public static int solution(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'g') {
                count++;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            int leftG = 0;
            int rightR = 0;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == 'g') {
                    leftG++;
                }
            }
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(j) == 'r') {
                    rightR++;
                }
            }
            count = Math.min(count, leftG + rightR);
        }
        return count;
    }

    public static int solution1(String s) {
        int num = 0;
        while (s.contains("gr")) {
            int gr = s.indexOf("gr");
            s = s.substring(0, gr) + s.substring(gr + 2);
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
//        String str = "rrrrgrr";
//        String str = "rgrgr";
        String str = "rggrrrgggr";
//        String str = "rgggggggggggg";
        int minimumCount = solution1(str);
        System.out.println("最小喷涂次数：" + minimumCount);
    }
}