package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {
	
	public Solution() {
		int n = 6;
		int[] arr1 = {46, 33, 33, 22, 31, 50};
		int[] arr2 = {27, 56, 19, 14, 14, 10};
		System.out.println(solution(n , arr1, arr2));
	}
	
	/*
	 * 1. ������ -> 2������ ��ȯ(���ڿ��� ���ο� List�� ���)
	 * 2. �ڸ��� ���߱�
	 * 3. ���ڿ� ��
	 * 4. �� �� 0�̸� ���� / �� ���� #
	 * 5. ���ڿ��� ���� �� ��ȯ
	 * */
	public List solution(int n, int[] arr1, int[] arr2) {    
        List<String> map1 = new ArrayList<String>();
        List<String> map2 = new ArrayList<String>();
        List answer = new ArrayList();
        for(int i=0; i<n; i++) {
        	String a = Integer.toBinaryString(arr1[i]);
        	String b = Integer.toBinaryString(arr2[i]);
        	
        	if(a.length()<n) {
        		String temp="";
        		int size = a.length();
        		for(int j=0; j<(n-size); j++) {
        			temp+="0";
        		}
        		temp+=a;
        		a=temp;
        	}
        	if(b.length()<n) {
        		String temp="";
        		int size = b.length();
        		for(int j=0; j<(n-size); j++) {
        			temp+="0";
        		}
        		temp+=b;
        		b=temp;
        	}
        	map1.add(a);
        	map2.add(b);
        }

        for(int i=0; i<n; i++) {
        	String first = map1.get(i);
        	String second = map2.get(i);
        	String temp = "";
        	for(int j=0; j<n;j++) {
        		String a = first.substring(j, (j+1));
        		String b = second.substring(j,(j+1));
        		if(a.equals("0")&&b.equals("0")) {
        			temp+=" ";
        		}else {
        			temp+="#";
        		}
        	}
        	answer.add(temp);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		new Solution();
	}

}
