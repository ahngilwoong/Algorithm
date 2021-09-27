/*
문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
입출력 예
number	k	return
"1924"	2	"94"
"1231234"	3	"3234"
"4177252841"	4	"775841"


1. 문제는 number에 작은숫자를 앞부터 k만큼의 숫자를 뺀 값이 정답이다. 즉 number.length()-k = return값의 길이.

2. 밑의 알고리즘은 문자열을 나누었는데 나눈 기준은 2번 테스트케이스를 보면 1231234이고 k는 3이다 리턴값은 길이가 4일것이다. 
앞부터 작은값을 빼야하기에 문자열의 길이 보장할 3개는 남겨두고 그 나머지만 우선 비교한다. 그래서 앞부분의 수를 저정한 리스트는 ar 뒷부분의 수를 저장한 리스트는 ar2이다.

3. ar에서 max값을 찾아내서 그 max값이 나올때까지 앞부터 카운트를 세며 삭제해준다. 뒤의 숫자가 보장이 되어있기 때문에 삭제해도 되는것이다.  
이때 ar를 앞부터 삭제하다가 max값을 만나게되면 답을 저장하는 스트링빌더에 그 숫자를 넣어주고 지워준다. 이때 카운트는 세지 않는다. 이 카운트가 k가 되면 멈출것이다.
그러고 ar에서 스트링빌더에 숫자가 들어갔으면 ar2의 맨앞 숫자를 ar 맨 뒷숫자로 추가해준다. 왜냐면 이제 글자가 하나 들어갔기때문에 보장할 숫자가 2개여도 되기때문이다.

(3-1). max값은 Collections.max를 쓰니 시간초과가 난다 이유는 999999999999999999999999가 나와도 저거는 다돌기때문이다. 그래서 직접 맥스를 구하고 9를 만나면 그걸 맥스값으로 지정하고
더 이상 탐색을 안하도록한다. 왜냐면 1의자리숫자의 최대값은 9이기때문에 9보다 큰숫자가 없기에 9까지만 구하면 되는것이다.

4. 이렇게 ar2에서 빼오다가 ar2가 비면 ar에서 스트링빌더에 글자를 추가해주고 ar의 맨앞의 값을 지운다.

5. (3-1)의 이유로 9를 만나면 제일 큰값이기에 실행 시간 절약을 위해 바로 넣어준다.

6. 이 반복문은 문자를 제거한 숫자인 cnt가 문제에서 주어진 숫자 k가 되면 종료하거나 저장한 스트링빌더의 크기가 number-k가 되면 종료한다.
전자의 경우에는 ar와 ar2의 잔여물들을 스트링빌더에 넣고 리턴하면 답이다. 후자의 경우는 이미 리턴할 문자열의 길이을 다 채웠기에 그대로 리턴하면 된다.




*/



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        String number = "888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888";
        int k = 88;
        System.out.println(s.solution(number,k));
    }
    public String solution(String number, int k) {
        String answer = "";
        int spt = number.length()-k-1;
        if(spt==0){
            spt = number.length()-k;
        }
        String numberB = number.substring(number.length()-spt,number.length());
        String numberF = number.substring(0,number.length()-numberB.length());
        System.out.println(numberF + "/" + numberB);
        int[] numsF = Arrays.stream(numberF.split("")).mapToInt(Integer::parseInt).toArray();
        int[] numsB = Arrays.stream(numberB.split("")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> ar = (ArrayList<Integer>) Arrays.stream(numsF).boxed().collect(Collectors.toList());
        ArrayList<Integer> ar2 = (ArrayList<Integer>) Arrays.stream(numsB).boxed().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (true){
            if(sb.length()==number.length()-k){
                return sb.toString();
            }
            if(ar.get(0)==9){
                if(ar2.isEmpty()){
                    sb.append(ar.get(0));
                    ar.remove(0);
                }else{
                    if(sb.length()+ar2.size()==number.length()-k){
                        ar.clear();
                        break;
                    }
                    sb.append(ar.get(0));
                    ar.remove(0);
                    ar.add(ar2.get(0));
                    ar2.remove(0);
                    }
            }
            int maxF = ar.get(0);
            for (int i = 1; i < ar.size(); i++) {
                if(maxF < ar.get(i)) {
                    maxF = ar.get(i);
                    if (maxF == 9) break;
                }
            }
            if(cnt==k){
                break;
            }
            if(ar.get(0)==maxF){
                if(ar2.isEmpty()){
                    sb.append(ar.get(0));
                    ar.remove(0);
                }else{
                    if(ar2.get(0)<maxF){
                        sb.append(ar.get(0));
                        ar.remove(0);
                        ar.add(ar2.get(0));
                        ar2.remove(0);
                    }else{
                        if(sb.length()+ar2.size()==number.length()-k){
                            ar.clear();
                            break;
                        }
                        sb.append(ar.get(0));
                        ar.remove(0);
                        ar.add(ar2.get(0));
                        ar2.remove(0);
                    }
                }
            }else{
                cnt++;
                ar.remove(0);
            }
        }
        for (int i = 0; i < ar.size(); i++) sb.append(ar.get(i));
        for (int i = 0; i < ar2.size(); i++) sb.append(ar2.get(i));
        answer = sb.toString();
        return answer;
    }
}
