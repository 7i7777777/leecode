package od;

import java.util.Scanner;

/**
 * @ClassName _092chongzuzifuchuan
 * @Description TODO 重组字符串
 * 题目描述
 * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，
 * 要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。
 * 对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；
 * 反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；
 * 大小写字母的数量相等时，不做转换。
 * <p>
 * 输入描述
 * 输入为两行，第一行为参数K，第二行为字符串S。
 * <p>
 * 输出描述
 * 输出转换后的字符串。
 * <p>
 * 示例一
 * 输入
 * 3
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abc-ABC-4aB-@
 * @Author 2+7
 * @Date 2023/3/28 16:07
 */
public class _092chongzuzifuchuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        System.out.println(recombinationString(k, s));
    }

    private static String recombinationString(int k, String s) {
        String[] arr = s.split("-");
        StringBuffer sb = new StringBuffer();
        sb.append(arr[0]);
        if (arr.length > 1) {
            sb.append("-");
        }
        for (int i = 1; i < arr.length; i++) {
            int j = 0, m = k;
            while (j<arr[i].length()) {
                String s1 = "";
                if(m <= arr[i].length()){
                    s1 = arr[i].substring(j, m);
                }else{
                    s1 = arr[i].substring(j, arr[i].length());
                }
                sb.append(caseSwitching(s1));
                sb.append("-");
                j = m;
                m += m;
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private static String caseSwitching(String s) {
        int upperNums = 0, lowerNums = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                upperNums++;
            } else if(Character.isLowerCase(c)){
                lowerNums++;
            }
        }
        if(upperNums==lowerNums){
            return s;
        }
        return upperNums > lowerNums ? s.toUpperCase() : s.toLowerCase();
    }
}