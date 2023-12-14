package od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName _045xiangduikaiyinjie
 * @Description TODO
 * @Author 2+7
 * @Date 2023/3/10 15:40
 */
public class _045xiangduikaiyinjie {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }

    }

    private static void solution(String line) {
        String[] words = line.split(" ");

        int count = 0;

        for (String word : words) {
            char[] chars = word.toCharArray();
            if (word.replaceAll("[a-z]+", "").isEmpty()) {
                for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                }
            }
            if (chars.length < 4) continue;
            for (int i = 0; i < chars.length - 3; i++) {
                if (isWord(chars[i])
                        && isWord(chars[i + 1])
                        && isWord(chars[i + 2])
                        && isWord(chars[i + 3])
                )
                    if (!isVowel(chars[i])
                            && isVowel(chars[i + 1])
                            && !isVowel(chars[i + 2]) && chars[i + 2] != 'r'
                            && chars[i + 3] == 'e') {
                        count++;
                    }
            }
        }

        System.out.print(count);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u';
    }

    private static boolean isWord(char c) {
        return c <= 'z' && c >= 'a';
    }
}