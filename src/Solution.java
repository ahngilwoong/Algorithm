import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static void main(String[] args){
        Solution sl = new Solution();

        System.out.println(sl.solution("tRy hElLo wOrLd"));
    }

    public String solution(String s) {

        char[] c = new char[s.length()];

        for(int i=0; i<s.length(); i++){
            c[i] = s.charAt(i);
            if(i%2!=0&&Character.isLowerCase(c[i])==false){
                if(c[i]==' '){
                    continue;
                }
                c[i]=(char)(c[i]+32);

            }
            if(i%2==0&&Character.isUpperCase(c[i])==false) {
                if(c[i]==' '){
                    continue;
                }
                c[i]=(char)(c[i]-32);
            }

        }
        String answer = new String(c);
        return answer;
    }
}
