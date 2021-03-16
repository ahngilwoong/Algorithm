
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    public class defaultClass {

         public static void main(String[] args) {
            defaultClass df = new defaultClass();
            int[] num = {2,1,3,4,1};
            System.out.println(df.solution(num));
        }
        public int[] solution(int[] numbers) {
            ArrayList<Integer> list = new ArrayList<>();

            int result = 0;

            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    result = numbers[i] + numbers[j];
                    if (!list.contains(result)) {
                        list.add(result);
                    }
                }
            }

            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            Arrays.sort(answer);

            return answer;
        }

    }

