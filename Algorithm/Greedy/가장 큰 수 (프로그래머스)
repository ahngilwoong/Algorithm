/*

0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

입출력 예
numbers            return
[6, 10, 2]         "6210"
[3, 30, 34, 5, 9]  "9534330"


해당 문제는 배열 하나하나를 비교하여 해당 상황의 큰 값을 도출해 나가야 하기 때문에 그리디 알고리즘이다.
해당 문제를 풀면서 0이 있는 원소는 맨 뒤로 보내는 공식을 세우는 등 엄청나게 많은 시도를 해봤다.
결국 알아낸 것은 Arrays.sort 함수 내부에 있는 compare 비교 함수를 Override해서 나만의 조건 기준으로
정의하여 정렬하면 되는 문제였다.

굳이 Arrays.sort의 compare함수 말고도 Priority Queue의 compare 함수를 Override 해도 해결이 가능하다.

우선 Arrays.sort의 Comparator를 사용해 Compare 함수를 쓰기 위해선 비교하는 배열의 타입이 Integer 타입의 배열이여야 한다.(int 배열 불가)
제공된 배열을 Integer배열로 변환 후 compare함수를 정의하는데 일단
compare함수의 매개변수로 있는 o1과 o2는 비교할 인덱스 두개를 뜻한다.
두개의 인덱스의 사이즈를 비교해주고 사이즈가 같으면 순수하게 값을 비교해주고 앞으로 보낼지 뒤로 보낼지를 결정한다.
만약 두개의 사이즈가 다를 경우(자릿수가 다를 경우) 두개의 값을 앞뒤로 붙여본 뒤 뭐가 더 크게 나오는지 판별 후 앞으로 보낼지 뒤로 보낼지 결정한다.
그 뒤 정렬된 배열을 스트링 빌더에 추가해준뒤 값을 리턴해주면 된다.
문제에서 인덱스가 0000으로 들어오게 되면 결국 0을 어디다 붙여도 0이기 때문에 0000이 아닌 0으로 리턴하게 한다.






*/

import java.util.*;

public class bigNum {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        bigNum bn = new bigNum();
        System.out.println(bn.solution(numbers));
    }
    public String solution(int[] numbers) {
        Integer[] iArr = Arrays.stream( numbers ).boxed().toArray( Integer[]::new );
        Arrays.sort(iArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String o1Str = Integer.toString(o1);
                String o2Str = Integer.toString(o2);
                int o1Size = o1Str.length();
                int o2Size = o2Str.length();

                if(o1Size == o2Size){
                    if(o1<o2){
                        return 1;
                    }else if(o1>o2){
                        return -1;
                    }else{
                        return 0;
                    }
                }else{
                    int a = Integer.parseInt(o1Str + o2Str);
                    int b = Integer.parseInt(o2Str + o1Str);
                    if(a<b){
                        return 1;
                    }else if(a>b){
                        return -1;
                    }else{
                        return 0;
                    }

                }
                }
        });

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < numbers.length; i++){
            sb.append(iArr[i]);
            if(iArr[i]==0){
                cnt++;
            }
        }
        if(cnt== numbers.length){
            sb.replace(0,numbers.length,"");
            sb.append("0");
        }
        return sb.toString();
    }
}
