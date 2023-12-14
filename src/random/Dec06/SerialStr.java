package random.Dec06;

public class SerialStr {
    //连续字符  只包含一种字符的最长非空子字符串的长度
    public int maxPower(String s){
        int num =1 , max = 1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
               num++;
               max = Math.max(num,max);
            }else{
                num=1;
            }
        }
        return max;
    }
}