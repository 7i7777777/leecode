package od;

import java.util.*;

/**
 * @ClassName _101doudizhu2
 * @Description TODO
 * @Author 2+7
 * @Date 2023/3/30 14:21
 */
public class _101doudizhu2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String my = scanner.nextLine();
            String over = scanner.nextLine();
            solution(my, over);
        }
    }

    static String[] graph = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private static void solution(String my, String over) {

        HashMap<String, Integer> cards = new HashMap<>();
        for (String s : graph) {
            cards.put(s, 4);
        }

        diff(cards, my);
        diff(cards, over);


        String res = find(cards);
        System.out.println(res);
    }

    private static void diff(HashMap<String, Integer> cards, String str) {
        for (String card : str.split("-")) {
            if (cards.containsKey(card)) {
                cards.put(card, cards.get(card) - 1);
            }
        }
    }

    private static String find(HashMap<String, Integer> cards) {
        String res = "NO-CHAIN";


        int l = 0, r = 0;
        for (int i = 0; i < graph.length; i++) {
            String card = graph[i];
            if (cards.get(card) > 0) {
                l = i;
                while (i < graph.length - 1 && cards.get(graph[i + 1]) > 0) {
                    i++;
                }
                r = i + 1;
            }
        }

        if (r - l >= 5) {
            StringBuilder builder = new StringBuilder();
            for (int i = l; i < r; i++) {
                builder.append(graph[i]).append("-");
            }

            if (builder.length() > 0) {
                res = builder.substring(0, builder.length() - 1);
            }
        }


        return res;
    }
}