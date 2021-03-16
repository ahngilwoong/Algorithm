public class test3 {
    public static void main(String[] args){
        test3 ts = new test3();
        System.out.println(ts.solution(3));
    }
    public String solution(int n) {
        String answer = "";
        String wm = "";
        String wm1 = "수";
        String wm2 = "박";
        for(int i=0; i<n; i++){
            if(wm.length()%2==0){
                wm = wm+wm1;
                if(wm.length()==n){
                    break;
                }
            }
            else{
                wm = wm+wm2;
                if(wm.length()==n){
                    break;
                }
            }
        }
        answer = wm;
        return answer;
    }
}
