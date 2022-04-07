import java.util.*;
class KnapSack1 {
	public static void main(String args[]) {
		// Your code goes here
		List<Integer> wts=new ArrayList<Integer>();
		List<Integer> vals =new ArrayList<Integer>();
		List<Integer> outcomes=new ArrayList<Integer>();
		int[] ws={1,3,4,5,7,2,6,2};
		int[] vs={1,4,5,7,12,6,22,4};
		int len=vs.length;
		for(int i=0;i<len;i++){
			wts.add(ws[i]);
			vals.add(vs[i]);
		}
		int cap=8;
		knapsack(wts,vals,outcomes,0,0,cap);
		Collections.sort(outcomes);
		System.out.println(outcomes);


	}
	static void knapsack(List<Integer> wts,List<Integer> vals,List<Integer> outcomes,int wt,int val,int cap ){
		if(wts.size()==0){
			outcomes.add(val);
			return;
		}
		int v0=vals.get(0);
		int w0=wts.get(0);
		
		if((w0+wt)<=cap){
			int wt1=wt;
			int wt2=wt;
			int val1=val;
			int val2=val;
			List<Integer> wts1= new ArrayList<Integer>(wts);
			List<Integer> wts2= new ArrayList<Integer>(wts);
			List<Integer> vals1=new ArrayList<Integer>(vals);
			List<Integer> vals2=new ArrayList<Integer>(vals);
			wt1+=w0;
			val1+=v0;
			wts1.remove(0);
			vals1.remove(0);
			knapsack(wts1,vals1,outcomes,wt1,val1,cap);
			wts2.remove(0);
			vals2.remove(0);
			knapsack(wts2,vals2,outcomes,wt2,val2,cap);
			return;

		}else{
			List<Integer> wts3= new ArrayList<Integer>(wts);
			List<Integer> vals3=new ArrayList<Integer>(vals);
			wts3.remove(0);
			vals3.remove(0);
			knapsack(wts3,vals3,outcomes,wt,val,cap);
			return;
		}

	}
}
