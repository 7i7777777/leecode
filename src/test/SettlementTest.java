package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhengjq3
 * @data 2024/4/1 12:12
 */
public class SettlementTest {

    public static void main(String[] args) {
        // 指定文件路径
        String filePath = "D:\\IdeaWorkspace\\leetcode\\src\\test\\SETT_RING_DETAIL_202402.avl";
        String filePath1 = "D:\\IdeaWorkspace\\leetcode\\src\\test\\SETT_RING_DETAIL_202310.avl";

        // 创建 File 对象
        File file = new File(filePath1);
        ArrayList<Integer> list = new ArrayList<>();

        try {
            // 创建 FileReader 对象
            FileReader reader = new FileReader(file);
            // 创建 BufferedReader 对象，用于按行读取文件内容
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            // 按行读取文件内容
            while ((line = bufferedReader.readLine()) != null) {
                // 处理每行数据
                int test = test(line);
                list.add(test);
            }

            // 关闭 BufferedReader
            bufferedReader.close();
            // 关闭 FileReader
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static int test(String line){
        String[] dataArray = line.split("\\^");
        return dataArray.length;
    }
}
