package leecodeHot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */
public class _053CanFinish {

    /**
     * 我们可以使用拓扑排序的方法来解决这个问题。
     * 具体步骤如下：
     * 1. 创建一个数组  inDegree ，用于记录每门课程的入度（即有多少先修课程）。
     * 2. 创建一个邻接表  adjacencyList ，用于记录每门课程的后续课程。
     * 3. 遍历  prerequisites  数组，将每门课程的入度和后续课程记录到  inDegree  和  adjacencyList  中。
     * 4. 创建一个队列  queue ，用于存储入度为0的课程。
     * 5. 将入度为0的课程加入到  queue  中。
     * 6. 使用BFS进行拓扑排序，直到队列为空。
     * - 从队列中取出一门课程  curr ，将其加入到结果数组中。
     * - 遍历  curr  的后续课程，将其入度减1。
     * - 如果减1后入度为0，将其加入到队列中。
     * 7. 检查结果数组的长度是否等于  numCourses ，如果相等，则说明可以完成所有课程的学习，返回 true；否则返回 false。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites)  {
        int[] inDegree = new int[numCourses]; //入度数组
        List<List<Integer>> adjacencyList = new ArrayList<>();//邻接表
        //初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        //遍历先修课程数组，记录入度和后续课程
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            inDegree[course]++;
            adjacencyList.get(prerequisiteCourse).add(course);
        }
        Queue<Integer> queue = new LinkedList<>();
        //将入度为0的课程加入到队列中
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        //适用BFS进行拓扑排序
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            //遍历当前课程的后续课程
            for (int next : adjacencyList.get(curr)) {
                inDegree[next]--;
                //如果入度为零，将其加入到队列中
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        //检查结果数组长度是否等于课程数量
        return result.size() == numCourses;
    }
}
