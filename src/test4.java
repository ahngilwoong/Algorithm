import java.util.ArrayList;

public class test4 {

    public static void main(String[] args){

        test4 ts = new test4();
        System.out.println(ts.solution(10));
    }

    public int solution(int n) {
        int answer =0;
        int cnt = 0;
        int count =0;
        for(int i=2; i<=n; i++){
            for(int j=2; j<=Math.sqrt(n); j++){
                if(i%j==0){
                    cnt++;
                    break;
                }
            }
            if(cnt ==1){
                count++;
            }
            cnt=0;
        }
        System.out.println(count);
        return answer;
    }
}
