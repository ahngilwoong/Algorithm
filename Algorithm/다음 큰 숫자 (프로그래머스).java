/*
    문제 :

자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

입출력 예
n	result
78	83
15	23


처음엔 숫자를 받아 진수로 변환한 뒤 규칙을 찾아 0을 시프트 하거나 list로 만들어서
규칙에 따라 0의 위치를 바꿔주고 리턴하게 하였다.
그랬더니 시간초과는 물론이고 런타임에러까지 떳고 코드도 매우 길었다.
그래서 그냥 1씩 더해서 풀어볼까 해서 풀었던게 String을  Array.asList하여 list에 넣어주고
Collection.frequency를 이용하여 1의 개수를 세주고 입력받은 숫자를 1씩 더해주며 똑같이 1의 개수를 세줬다.
1의 개수를 비교하여 1의개수가 같지 않으면 continue시키고 같다면 1씩 더해줬으니 그 값이 조건을 만족한 다음 큰수이기에 그것을 리턴해주는 형식이다.
정확도 테스트는 100점이였지만 효율성 테스트에서 시간초과가 났다.
원인 분석을 해보니 while반복문을 돌때마다 new를 이용한 list를 생성한 것이 문제가 될 것 같아
list를 사용하지 않고 String 자체에서 1의 개수를 세주기로 하였다.
입력받은 숫자를 toBinaryString으로 2진법 문자열화 시켜주고
그 이진법의 문자열의 길이에 1이 없는 문자열의 길이를 빼주면 1의 개수가 나오게 된다. 그 코드가
int count = a.length() - a.replace(String.valueOf("1"), "").length(); 이다.
이렇게 리스트화 안시키고 1의 개수를 체크하는 방법을 찾았고 그 뒤 똑같이 1씩 더해가며 1의 개수를 찾아줬다.
그렇게 했더니 0.0x ms의 시간초과가 안나는 효율적인 알고리즘인 나오게 되었다.




 */

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a = 30;
        System.out.println(s.solution(a));
    }
    public int solution(int n) {
        int answer = 0;
        String a = Integer.toBinaryString(n);
        int count = a.length() - a.replace(String.valueOf("1"), "").length();
        int testNum = n;

        while (true){
            testNum++;
            String b = Integer.toBinaryString(testNum);
            int count2 = b.length() - b.replace(String.valueOf("1"), "").length();
            if(count==count2){
                answer = testNum;
                break;
            }else{
                continue;
            }
        }
        return answer;
    }
}