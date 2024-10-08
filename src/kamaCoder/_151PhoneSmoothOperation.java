package kamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengjq3
 * @data 2024/8/6 17:45
 *
 *
 * 151. 手机流畅运行的秘密
 * 题目描述
 * 8 月份发布会一结束，米小兔就在公司领到了一台最新发布的 Xiaomi MIX Fold 3 手机，这是一款小米旗舰折叠屏手机，并搭载了全新升级架构的 MIU114 系统。
 * 其先进的应用引擎不仅让系统更流畅，应用体验也大幅提升。
 * 在一个优化项中，为了尽可能提升用户白天使用手机的体验和续航，某些已经在系统中注册过的任务会被设置为空闲任务，仅在手机空闲时运行 (比如数据备份或 AI 相册整理)。
 *
 *
 * 现在系统中注册了若干组空闲任务，每个任务有各自的耗电量以及允许任务运行的最低初始电量，我们需要计算手机能够串行完成全部任务的最低初始电量。
 *
 *
 * 注意点1: 所有电量以 mAh(毫安时)计，Xiaomi MIX Fold 3 的大电池容量是4800mAh。
 *
 * 注意点2: 本题目假设手机在运行空闲任务期间，不处于充电状态，也没有额外耗电行为。
 *
 * 注意点3: 智能应用引擎会以最合适的顺序串行运行任务。
 *
 * 输入描述
 * 一个描述了所有任务的长字符串。任务与任务之间用逗号隔开，每组任务由耗电量及最低初始电量组成，用冒号隔开。
 * 输出描述
 * 一个数字，代表依次完成全部任务的最低初始电量，如果最低初始电量超过手机电池容量，则返回-1。
 * 输入示例
 * 1:10,2:12,3:10
 * 输出示例
 * 13
 * 提示信息
 * 在样例中，手机至少需要有 13mAh 的初始电量，在运行任务 2 后剩余电量 11mAh、运行任务1后剩余电量 10mAh、运行任务 3 后剩 7 mAh。
 */
public class _151PhoneSmoothOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] tasks = s.split(",");
        List<Task> taskList = new ArrayList<>();

        for (String task : tasks) {
            String[] parts = task.split(":");
            int powerConsumption = Integer.parseInt(parts[0]);
            int minInitialPower = Integer.parseInt(parts[1]);
            taskList.add(new Task(powerConsumption,minInitialPower));
        }

        taskList.sort((a,b) -> b.minInitialPower-a.minInitialPower);
        int currentPower = 0;
        int initialPower = 0;
        for (Task task : taskList) {
            if(currentPower < task.minInitialPower) {
                initialPower += task.minInitialPower - currentPower;
                currentPower = task.minInitialPower;
            }
            currentPower -= task.powerConsumption;
        }
        if(initialPower>4800){
            System.out.println(-1);
        }else {
            System.out.println(initialPower);
        }

    }

    static class Task{
        int powerConsumption;
        int minInitialPower;

        Task(int powerConsumption, int minInitialPower) {
            this.powerConsumption = powerConsumption;
            this.minInitialPower = minInitialPower;
        }
    }
}
