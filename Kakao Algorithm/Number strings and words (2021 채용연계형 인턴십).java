/*

숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

1478 → "one4seveneight"
234567 → "23four5six7"
10203 → "1zerotwozero3"
이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.



s	result
"one4seveneight"	1478
"23four5six7"	234567
"2three45sixseven"	234567
"123"	123



각 숫자에 대한 영어 배열을 만들어주고 HashMap에 해당 영어 문자에 대한 숫자 값을 벨류값으로 넣은 뒤
replaceAll을 써서 문자열이 저장된 키값을 만나면 숫자로 변환된 벨류값을 리턴하도록 한다.


*/


import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Solution sl =  new Solution();
        String s = "123";
        System.out.println(sl.solution(s));
    }
    public int solution(String s) {
        int answer = 0;
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        HashMap<String,Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length; i++) hm.put(str[i],i);
        for (int i = 0; i < str.length; i++) {
            s=s.replaceAll(str[i],Integer.toString(hm.get(str[i])));
        }
        answer=Integer.parseInt(s);
        return answer;
    }
}
