package jzoffer.day03_String;

public class ReplaceSpace {
    //替换字符串
    public static String replaceSpace(String s){
        String str = null;
        str = s.replace(" ","%20");
        return str;
    }

    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(replaceSpace(s));
    }
}