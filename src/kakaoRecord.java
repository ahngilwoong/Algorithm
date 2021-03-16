import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class kakaoRecord {
    public static void main(String[] args){
        kakaoRecord kr = new kakaoRecord();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan","Leave uid4567"};
        kr.solution(record);
    }

    public String[] solution(String[] record) {
        Map<String,String> map = new HashMap<String,String>();
        ArrayList<String> answerList = new ArrayList<String>();
        String[] spList = {};
        String[] answer = {};
        String status;
        String id;
        String name = null;
        for(int i=0; i<record.length; i++){
            spList = record[i].split(" ");
            status = spList[0];
            id = spList[1];
            if(status.equals("Enter")){
                name = spList[2];
                map.put(id,name);                // Map 값
            }
            if(spList.length==3){
                if(status.equals("Change")){
                    name = spList[2];
                    map.replace(id,name);                     // Map 값
                }
            }
        }
        for(int j=0; j<record.length; j++){
            spList = record[j].split(" ");
            status = spList[0];
            id = spList[1];
            if(status.equals("Enter")){
                answerList.add(map.get(id)+"님이 들어왔습니다.");
            }
            if(status.equals("Leave")){
                answerList.add(map.get(id)+"님이 나갔습니다.");
            }
        }
        answer = answerList.toArray(new String[0]);
        for(int i=0; i < answerList.size(); i++)
        {
            System.out.println(answer[i]);
        }
        return answer;
    }
}
