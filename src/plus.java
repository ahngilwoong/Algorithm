import java.util.ArrayList;
import java.util.Arrays;

public class plus {

    // 메인 메서드
    public static void main(String[] args) {
        plus pl = new plus();
        int[] num = {0,100,1000,10};
        pl.solution(num);
    }



    public int[] solution(int[] numbers) {
        //가변적인 배열이 필요하여 ArrayList 사용
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        // 입력 값을  순차적으로 더하기 위해 오름차순 정렬
        Arrays.sort(numbers);


        //배열의 i값과 i+1값을 더하는 반복문
        for(int i=0; i<numbers.length; i++) {
            // 배열의 마지막 부분은 더할 필요가 없으므로 break
            if(i==numbers.length-1){
                break;
            }
            // 더할 부분의 중첩 반복문, 배열의 같은 값이 존재할시 더하지 않는다
           for(int j=1; j<numbers.length; j++){
               // i가 다음부분과 같지않을경우안에  배열의 i와 j부분이 같으면 제외시킨다
               if(numbers[i]!=numbers[i+1]){
                   if(numbers[i]==numbers[j]){
                       continue;
                   }
               }
               // 가변 배열에 더한 값을 저장한다.
               list.add(numbers[i]+numbers[j]);
           }
        }
        // 모두 더한 값 중  for each를 사용하여 중복된 부분을 제거한다.
        for(int item : list){
            if(!list2.contains(item))
                list2.add(item);
        }
        // 밑 주석은 List를 integer배열로 변환하여 int배열로 바꾸는 방법
//        Integer[] ia = list2.toArray(new Integer[0]);
//        int[] answer = Arrays.stream(ia).mapToInt(i->i).toArray();

        // answer 배열을 만들고 list를 answer 배열에 담는다.
        int[] answer = new int[list2.size()];
        int cnt = 0;
        for(int arr : list2){
            answer[cnt++] = arr;
        }
//        for(int i=0; i<answer.length; i++){
//            System.out.println(answer[i]);
//
        Arrays.sort(answer); //  결과 값 오름차순
        return answer;
    }
}
