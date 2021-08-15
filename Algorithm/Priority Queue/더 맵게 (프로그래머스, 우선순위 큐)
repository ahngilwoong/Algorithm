/*

입출력 예
scoville	        K	return
[1, 2, 3, 9, 10, 12]	7	2
입출력 예 설명
스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]

스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
가진 음식의 스코빌 지수 = [13, 9, 10, 12]

모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
이 섞은 횟수 2가 문제의 답입니다.





즉 배열안의 숫자중 K보다 낮은 수들을 K만큼 충족 시키도록 주어진 공식
섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
의 공식으로 계산하여 최대한 K의 수에 가깝게 만드는 문제이다.
배열에 들어오는 숫자는 랜덤이며 가장 맵지않은 스코빌 지수와 두 번쨰로 맵지 않은 지수를 구하기 위해서는
오름차순 정렬을 해야하는데 이때 효과적인게 들어오는 족족 정렬해주는 우선순위 큐이다.
우선 add를 해줄 때 K보다 낮은 수는 안들어가게 하였고, 이때 큐에 아무것도 없다면 K보다 낮은 수가 배열에 없다는 뜻이기에
0을 리턴해준다. 그 후 선입선출의 특성을 가진 큐의 맨 앞 숫자가 7보다 작을때동안 반복하는 while문을 선언해주고,
큐의 숫자가 1개남으면 더 이상 K이상의 스코빌 지수를 뽑아낼 수 없기에 문제의 조건대로 -1을 리턴한다.
반복문 안의 식은 a와 b를 선언하여 각각 맨 앞숫자를 저장과 동시에 지워준다.
그 후 스코빌 지수를 구하는 식을 구하고 다시 우선순위 큐에 넣어주고 이를 반복한다.
그럼 그에 대한 횟수가 나올 것이고, 그 횟수를 리턴 해주는 알고리즘 이다.


*/


import java.util.PriorityQueue;

public class spicy {
    public static void main(String[] args) {
        spicy sp = new spicy();
        int[] scoville = {9,9,9};
        int K = 7;
        System.out.println(sp.solution(scoville,K));

    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            if (scoville[i] >= K) {
                continue;
            }
            pq.add(scoville[i]);
        }
        if (pq.isEmpty()) {
            return 0;
        }
        int cnt = 0;
        while (pq.peek()<K) {
            if (pq.size() < 2) return -1;
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + (2*b);
            cnt++;
            pq.add(sum);
        }
        return cnt;
    }
}
