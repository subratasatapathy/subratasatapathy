/*

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
*/


import java.util.*;
class CombinationSum-ii {
	public static void main(String args[]) {
		// Your code goes here
		int [] a={97, 74, 34, 21, 49, 66, 48, 44, 28, 63};
		int len=a.length;
		ArrayList<Integer> list= new ArrayList<Integer>();
		for(int i=0;i<len;i++){
			list.add(a[i]);
		}
		ArrayList<ArrayList<Integer>> ans=combinationSum(list, 20);

	}
	static void populateCombi(ArrayList<Integer> ip,ArrayList<Integer> op,int sum,int B,Set<List<Integer>> ans){
        if(ip.size()==0){
            if(sum==B){
                Collections.sort(op);
                ans.add(op);
            }
            return;
        }
        ArrayList<Integer> ip1= new ArrayList<Integer>(ip);
        ArrayList<Integer> ip2= new ArrayList<Integer>(ip);
        ArrayList<Integer> op1= new ArrayList<Integer>(op);
        ArrayList<Integer> op2= new ArrayList<Integer>(op);
        int num=ip.get(0);
        if((num+sum) <= B){
            int sum1= sum+num;
            op1.add(num);
            ip1.remove(0);
            populateCombi(ip1,op1,sum1,B,ans);
            ip2.remove(0);
            populateCombi(ip2,op2,sum,B,ans);
        }else{
            ArrayList<Integer> ip3= new ArrayList<Integer>(ip);
            ArrayList<Integer> op3= new ArrayList<Integer>(op);
            ip3.remove(0);
            populateCombi(ip3,op3,sum,B,ans);
        }
        return;
    }
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int b) {
        Collections.sort(A);
        int i=A.size()-1;
		if(A.get(0) >b){
			return new ArrayList<ArrayList<Integer>>();
		}
        while(A.get(i)>b){
            A.remove(i);
            i--;
        }
        ArrayList<Integer> op= new  ArrayList<Integer>();
        Set<List<Integer>> ans= new HashSet<List<Integer>>();
        populateCombi(A,op,0,b,ans);
        //Set<ArrayList<Integer>> set= new TreeSet<ArrayList<Integer>>(ans);
        List<List<Integer>> res= new ArrayList<List<Integer>>(ans);
        ArrayList<ArrayList<Integer>> rsp=new ArrayList<ArrayList<Integer>>();
        for(List<Integer> list:res){
            rsp.add(new ArrayList<Integer>(list));
        }
        return rsp;
	}
}
