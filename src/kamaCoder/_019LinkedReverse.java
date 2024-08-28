package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/15 18:30
 *
 *
 * 19. 单链表反转
 * 题目描述
 * 根据一个整数序列构造一个单链表，然后将其反转。
 *
 * 例如：原单链表为 2 3 4 5 ，反转之后为5 4 3 2
 *
 * 输入描述
 * 输入包括多组测试数据，每组测试数据占一行，第一个为大于等于0的整数n，表示该单链表的长度，后面跟着n个整数，表示链表的每一个元素。整数之间用空格隔开
 * 输出描述
 * 针对每组测试数据，输出包括两行，分别是反转前和反转后的链表元素，用空格隔开
 *
 * 如果链表为空，则只输出一行，list is empty
 *
 * 输入示例
 * 5 1 2 3 4 5
 * 0
 * 输出示例
 * 1 2 3 4 5
 * 5 4 3 2 1
 * list is empty
 * 提示信息
 * 本题用数组，也是可有过的，输入一遍数组，然后倒叙输出。不过建议大家用本题来链表操作
 */
public class _019LinkedReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if(n==0){
                System.out.println("list is empty");
                break;
            }
            List<Integer> list = new ArrayList<>();
            while(n>0){
                list.add(sc.nextInt());
                n--;
            }
            list.forEach(i->System.out.print(i+" "));
            System.out.println();
            for (int i = list.size()-1; i >= 0; i--) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
}
