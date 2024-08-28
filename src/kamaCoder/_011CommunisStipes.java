package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/2 14:06
 *
 *
 * 11. 共同祖先
 * 题目描述
 * 小明发现和小宇有共同祖先！现在小明想知道小宇是他的长辈，晚辈，还是兄弟。
 * 输入描述
 * 输入包含多组测试数据。每组首先输入一个整数N（N<=10），接下来N行，每行输入两个整数a和b，表示a的父亲是b（1<=a,b<=20）。小明的编号为1，小宇的编号为2。
 * 输入数据保证每个人只有一个父亲。
 * 输出描述
 * 对于每组输入，如果小宇是小明的晚辈，则输出“You are my younger”，如果小宇是小明的长辈，则输出“You are my elder”，如果是同辈则输出“You are my brother”。
 * 输入示例
 * 5
 * 1 3
 * 2 4
 * 3 5
 * 4 6
 * 5 6
 * 6
 * 1 3
 * 2 4
 * 3 5
 * 4 6
 * 5 7
 * 6 7
 * 输出示例
 * You are my elder
 * You are my brother
 */
public class _011CommunisStipes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        while(true){
            String line = sc.nextLine().trim();
            if(line.isEmpty()){
                break;
            }
            int N = Integer.parseInt(line);
            List<Integer> Alist = new ArrayList<>();
            List<Integer> Blist = new ArrayList<>();
            int A = 1;
            int B = 2;
            for (int i = 1; i <= N; i++) {
                String[] s = sc.nextLine().trim().split("\\s+");
                if(Integer.parseInt(s[0]) == A){
                    A = Integer.parseInt(s[1]);
                    Alist.add(A);
                }else if(Integer.parseInt(s[0]) == B){
                    B = Integer.parseInt(s[1]);
                    Blist.add(B);
                }
            }
            if(Alist.size() == Blist.size()){
                list.add("You are my brother");
            }else if(Alist.size() > Blist.size()){
                list.add("You are my elder");
            }else{
                list.add("You are my younger");
            }
        }
        sc.close();
        list.forEach(System.out::println);
    }
}
