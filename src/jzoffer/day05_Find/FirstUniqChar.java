package jzoffer.day05_Find;

import java.util.HashMap;

public class FirstUniqChar {
    //在字符串 s 中找出第一个只出现一次的字符。
    //如果没有，返回一个单空格。 s 只包含小写字母。
    public char firstUniqChar(String s){
        //哈希表法
        HashMap<Character,Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c:sc)
            dic.put(c,!dic.containsKey(c));
        for (char c:sc)//方法二 有序哈希表      //for(Map.Entry<Character,Boolean> d:dic.entrySet()
            if(dic.get(c)) return c;                //if(d.getValue()) return d.getKey();
        return ' ';
    }

    public static void main(String[] args) {
        HashMap<String,String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("abc","123");
        stringStringHashMap.put("abc","345");
        System.out.println(stringStringHashMap.get("abc"));
    }
}