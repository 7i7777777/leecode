package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName _011zuixiaoyezijiedian
 * @Description TODO 最小叶子节点
 * 题目描述
 * 二叉树也可以用数组来存储，
 * 给定一个数组，树的根节点的值储存在下标1，
 * 对于储存在下标n的节点，他的左子节点和右子节点分别储存在下标2*n和2*n+1，
 * 并且我们用-1代表一个节点为空，
 * 给定一个数组存储的二叉树，
 * 试求从根节点到最小的叶子节点的路径，
 * 路径由节点的值组成。
 *
 * 输入描述
 * 输入一行为数组的内容，
 * 数组的每个元素都是正整数，元素间用空格分割，
 * 注意第一个元素即为根节点的值，
 * 即数组的第n元素对应下标n，
 * 下标0在树的表示中没有使用，所以我们省略了，
 * 输入的树最多为7层。
 *
 * 输出描述
 * 输出从根节点到最小叶子节点的路径上各个节点的值，
 * 由空格分割，
 * 用例保证最小叶子节点只有一个。
 *
 * 示例一
 * 输入
 * 3 5 7 -1 -1 2 4
 * 输出
 * 3 7 2
 * 示例二
 * 输入
 * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
 * 输出
 * 5 8 7 6
 * @Author 2+7
 * @Date 2023/3/3 10:55
 */
public class _011zuixiaoyezijiedian {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String treeStr = scanner.nextLine();
            solution(treeStr);
        }
    }

    private static void solution(String treeStr) {
        String[] split = ("0 " + treeStr).split(" ");
        int min = Integer.MAX_VALUE;
        int minPos = 0;
        for (int i = 2; i < split.length; i++) {
            int tmp = Integer.parseInt(split[i]);
            if (tmp != 0 && tmp != -1 && tmp < min && i * 2 > split.length) {
                min = tmp;
                minPos = i;
            }
        }
        List<String> path = new ArrayList<>();
        back(split, minPos, path);

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
            if (i != 0) {
                System.out.print(" ");
            }
        }

    }

    private static void back(String[] split, int minPos, List<String> path) {
        path.add(split[minPos]);
        if (minPos == 1) {
            return;
        }
        if (minPos % 2 == 0) {
            back(split, minPos / 2, path);
        } else {
            back(split, (minPos - 1) / 2, path);
        }
    }

}