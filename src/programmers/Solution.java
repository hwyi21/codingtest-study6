package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	public Solution() {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(solution(record));
	}
	
	/*
	 * 1. uid숫자를 key / value를 닉네임으로 hashmap 저장
	 * 2. 문장의 앞글자가 E와 L인 경우 판단
	 * 3. 문장을 공백을 기준으로 split
	 * 4. 배열의 두번째 uid숫자를 key로 이용하여 hashmap에 저장되어있는 닉네임 가져오기
	 * */
	public List solution(String[] record) {
        List answer = new ArrayList();
        Map<String, String> user = new HashMap<String, String>();
        
        for(int i=0; i<record.length; i++) {
        	String[] temp = record[i].split(" ");
        	if(temp.length==3) {
        		user.put(temp[1], temp[2]);
        	}
        }
        
        for(int i=0; i<record.length;i++) {
        	String first = record[i].substring(0,1);
        	String[] temp = record[i].split(" ");
        	if(first.equals("E")) {
        		String result = user.get(temp[1])+"님이 들어왔습니다.";
        		answer.add(result);
        	}else if(first.equals("L")) {
        		String result = user.get(temp[1])+"님이 나갔습니다.";
        		answer.add(result);
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		new Solution();
	}

}
