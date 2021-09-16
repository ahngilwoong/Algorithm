/*
문제 설명
0부터 9까지의 숫자 중 일부가 들어있는 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ numbers의 길이 ≤ 9
0 ≤ numbers의 모든 수 ≤ 9
numbers의 모든 수는 서로 다릅니다.

문제의 조건대로 0부터 9까지 있는 배열을 만들고
numbers 배열 안에 있는 인덱스가 number배열에 있으면 그 배열을 지워주면 
numbers에 없는 값이 나온다 그걸 answer에 더해준다.

*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] numbers) {
        int[] number = {1,2,3,4,5,6,7,8,9,0};
        int answer = 0;
        ArrayList<Integer> ar = (ArrayList<Integer>) Arrays.stream(number).boxed().collect(Collectors.toList());
        for (int i = 0; i < numbers.length; i++) {
            if(ar.contains(numbers[i])){
                ar.remove(ar.indexOf(numbers[i]));
            }
        }
        for (int i = 0; i < ar.size(); i++) {
            answer+=ar.get(i);
        }
        return answer;
    }
}
