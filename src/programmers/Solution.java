package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Solution {
	List<int[]> answer = new ArrayList<int[]>();
	
	public Solution() {
		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
		solution(5, build_frame);
	}
	
	public int[][] solution(int n, int[][] build_frame) {
		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2]; // 구조물
			int b = build_frame[i][3]; // 삭제 / 설치

			if (a == 0) {// 기둥
				if (b == 1) { // 기둥 설치
					boolean check = buildP(x, y); // 기둥 설치
					if(check) {
						int[] build = {x, y, a};
						answer.add(new int[] {x,y,a});
					}
				}else {// 기둥 삭제
					del(x,y,a);
					boolean ch = check();
					if(!ch) {
						answer.add(new int[] {x,y,a});
					}
				}
			}else { // 보
				if(b==1) { //보 설치
					boolean check = buildB(x, y); // 보 설치
					if(check) {
						int[] build = {x, y, a};
						answer.add(new int[] {x,y,a});
					}
				}else {
					del(x,y,a);
					boolean ch = check();
					if(!ch) {
						answer.add(new int[] {x,y,a});
					}
				}
			}
		}
		Collections.sort(answer,new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) return -1;
                else if (a[0]== b[0]) {
                    if (a[1] < b[1]) return -1;
                    else if (a[1]== b[1]) {
                        if (a[2] < b[2]) return -1;
                        else return 1;
                    }
                }
                return 1;
            }
        });
		int[][] result = new int[answer.size()][3];
		for(int i=0; i<answer.size(); i++) {
			result[i][0] = answer.get(i)[0];
			result[i][1] = answer.get(i)[1];
			result[i][2] = answer.get(i)[2];
		}
		return result;
	}

	public boolean buildP(int x, int y) {
		if(y==0) {
			return true;
		}
		
		for(int i=0; i<answer.size();i++) {
			int x1 = answer.get(i)[0];
			int y1 = answer.get(i)[1];
			int a = answer.get(i)[2];
			if(a==0) { //기둥
				if(x==x1&&y==y1+1) {
					return true;
				}
			}else {//보
				if((x==x1&&y==y1)||(x==x1+1&&y==y1)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean buildB(int x, int y) {
		int count=0;
		for(int i=0; i<answer.size();i++) {
			int x1 = answer.get(i)[0];
			int y1 = answer.get(i)[1];
			int a = answer.get(i)[2];
			if(a==0) { //기둥
				if((x==x1&&y==y1+1)||(x+1==x1&&y==y1+1)) {
					return true;
				}
			}else {//보
				if((x==x1+1&&y==y1)||(x+1==x1&&y==y1)) {
					count++;
				}
			}
		}
		if(count==2) {
			return true;
		}
		return false;
	}
	
	public void del(int x, int y, int a) {
		for(int i=0; i<answer.size();i++) {
			int x1 = answer.get(i)[0];
			int y1 = answer.get(i)[1];
			int a1 = answer.get(i)[2];
			
			if(x==x1&&y==y1&&a==a1) {
				answer.remove(i);
			}
		}
	}
	
	public boolean check() {
		for(int i=0; i<answer.size();i++) {
			int x = answer.get(i)[0];
			int y = answer.get(i)[1];
			int a = answer.get(i)[2];
			if(a==0) {
				boolean ch = buildP(x,y);
				if(ch) continue;
				else {
					return false;
				}
			}else {
				boolean ch = buildB(x,y);
				if(ch) continue;
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		new Solution();
	}

}
