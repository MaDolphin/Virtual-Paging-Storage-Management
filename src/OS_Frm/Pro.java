package OS_Frm;
public class Pro {
	public static int[][] memory={{0,-1},{1,-1},{2,-1},{3,-1},{4,-1},{5,-1},{6,-1},{7,-1},{8,-1},{9,-1},};
	public int[] memoryFree;
	public static int memoryEachSize=1024;
	public int[] change(int n){
		int[] temp = new int[2];
		temp[0]=n/this.memoryEachSize;
		temp[1]=n%this.memoryEachSize;
		return temp;
	}
	
	public int updateMemory(int page,int len,int disk){
		int distance;
		int[][] temp=this.memory;
		temp[disk][1]=page;
		distance=disk*this.memoryEachSize+len;
		this.memory=temp;
		return distance;
	}
	
	public int[] initMemory(int num){
		int t=0;
		int[] temp=new int[num];
		while(t<num){
			int i=(int)(Math.random()*10);
			if(this.memory[i][1]==-1){
				this.memory[i][1]=99999;
				temp[t]=i;
				t++;
				i++;
			}
			else i++;
		}
		this.memoryFree=temp;
		return temp;
	}
	
	public void deleteMemory(int[] temp){
		for(int i=0;i<temp.length;i++){
			this.memory[temp[i]][1]=-1;
		}
	}
}
