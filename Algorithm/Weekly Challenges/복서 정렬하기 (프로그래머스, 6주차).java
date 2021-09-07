

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] weights = {50,82,75,120};
        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};
        System.out.println(s.solution(weights,head2head));
    }
    public int[] solution(int[] weights, String[] head2head) {
        int[] ans = new int[weights.length];
        int[] answer = new int[weights.length];
        ArrayList<Double> winRate = new ArrayList<>();
        ArrayList<Integer> winCnt = new ArrayList<>();
        String[] copyStr = head2head.clone();
        int winCount = 0;
        for (int i = 0; i < head2head.length; i++) {
            ans[i] = i+1;
            winCount = 0;
            head2head[i] = head2head[i].replace("N","");
            int perCnt = head2head[i].length()-head2head[i].replace(String.valueOf("W"),"").length();
            Double percent = (double)perCnt/head2head[i].length();
            winRate.add(percent);

            for (int j = 0; j < copyStr.length; j++) {
                if(copyStr[i].charAt(j)=='W'){
                    if(weights[i]<weights[j]){
                        winCount++;
                    }
                }
            }
            winCnt.add(winCount);
        }
        
        Integer[] iArr = Arrays.stream( ans ).boxed().toArray( Integer[]::new );
        Arrays.sort(iArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(winRate.get(o1-1) > winRate.get(o2-1)){
                    return -1;
                }else if(winRate.get(o1-1) < winRate.get(o2-1)){
                    return 1;
                }else{
                    if (winCnt.get(o1-1) > winCnt.get(o2-1)){
                        return -1;
                    }else if(winCnt.get(o1-1) < winCnt.get(o2-1)){
                        return  1;
                    }else{
                        if(weights[o1-1] > weights[o2-1]){
                            return -1;
                        }else if(weights[o1-1] < weights[o2-1]){
                            return 1;
                        }else{
                            return 0;
                        }
                    }
                }
            }
        });

        for (int i = 0; i < iArr.length; i++) {
            answer[i] = iArr[i];
            System.out.println(answer[i]);
        }


        return answer;
    }
}
