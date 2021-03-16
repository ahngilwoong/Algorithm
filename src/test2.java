import java.util.Arrays;

public class test2 {

    public static void main(String[] args){
        test2 ts = new test2();
        int[] d= {1,3,2,4,5};
        System.out.println(ts.solution(d,9));
    }

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum=0;
        int cnt=0;
        for(int i =0; i<d.length; i++){
            sum += d[i];
            if(sum==budget){
                answer = i+1;
                break;
            }else if(sum<budget){
                cnt++;
                answer = cnt;


            }

        }
        return answer;
    }

}
