import java.util.Arrays;

public class test1 {


    public static void main(String[] args){
        test1 ts = new test1();

        System.out.println(ts.solution("Zgfedcb"));
    }

    public String solution(String s) {
        String answer = "";
        char[] c = new char[s.length()];
        String[] e = new String[s.length()];
        for(int i=0; i<s.length(); i++){
            c[i] = s.charAt(i);
            e[i] = Character.toString(c[i]);
        }
        Arrays.sort(e);
        String str =Arrays.toString(e);
        char[] c2 = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            c2[i]=str.charAt(i);
            if(Character.isUpperCase(c2[i])==true){
                c2[i]=c2[i+1];
                c2[s.length()-1]=c2[i];
            }

            System.out.println(c2[i]);
        }

        return answer;
    }

}
