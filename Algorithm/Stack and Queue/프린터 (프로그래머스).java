/*


문제 : 

일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 
그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 
이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 
이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.

예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

priorities          location  return
[2, 1, 3, 2]        2	        1
[1, 1, 9, 1, 1, 1]  0	        5


큐 2개 리스트 2개를 만들어 각각 값을 넣어준다. q2같은 경우는 리턴할 값을 담은 배열의 인덱스 수를 넣어줬다.
그 뒤 q가 비어있을 때 까지의 반복을 돌려 q의 peek값을 제외한 나머지의 최댓값을 구해주고
peek값이 나머지 값의 최댓값인 max보다 작을시 peek값을 제거하고 맨 뒤로 보내준다.
반대로 max보다 크거나 같으면 맨 앞의 peek값이 제일 중요도가 큰 인쇄물이므로 출력(삭제)후 해당 인덱스 값을 리스트에 넣어준다.
그러면 반복적으로 작업되어 중요도가 큰 순서대로 인덱스 값들이 리스트에 저장된다.
그 후 목표값인 location과 리스트의 숫자를 비교해 해당 location값이 리스트의 몇 번째 자리에 있는지 확인 후 그 값을 리턴해준다.


*/
   
   
   
   
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2= new LinkedList<>();
        ArrayList<Integer> ar = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < priorities.length; i++) {
            q.add(priorities[i]);
            q2.add(i);
            ar.add(priorities[i]);
        }

        while (!q.isEmpty()){
            int max = 0;
            int save = ar.get(0);
            ar.remove(0);
            for (int i = 0; i < ar.size(); i++) {
                if(max < ar.get(i)){
                    max = ar.get(i);
                }
            }
            if(q.peek()<max){
                q.add(q.poll());
                q2.add(q2.poll());
                ar.add(save);
                continue;
            }else{
                q.poll();
                ar2.add(q2.poll());
                continue;
            }
        }
        for (int i = 0; i < ar2.size(); i++) {
            if(location==ar2.get(i)){
                answer = i+1;
            }
        }

        return answer;
    }
