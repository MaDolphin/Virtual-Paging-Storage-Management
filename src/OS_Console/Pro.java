package OS_Console;
public class Pro {
	public int[][] memory;
	public int[] memoryFree;
	public int memoryEachSize=1024;
	
	public int[] createList(int pagenum,int disknum){
		int[] temp=new int[pagenum];
		System.out.println("该程序的页面数为"+pagenum+"页，可分配的逻辑块为"+disknum+"块");
		for(int i=0;i<temp.length;i++){
			temp[i]=(int)(Math.random()*pagenum);
		}
		System.out.print("进程运行序列: ");
		for(int i=0;i<temp.length;i++){
			System.out.print(temp[i]+"  ");
		}
		System.out.println();
		return temp;
	}
	
	public int[][] createMemory(int num){
		int t=num-num/2;
		int[][] temp=new int[num][2];
		for(int i=0;i<temp.length;i++){
			temp[i][0]=i;temp[i][1]=-1;
		}
		while(t>0){
			temp[(int)(Math.random()*num)][1]=99999;
			t--;
		}
		this.memory=temp;
		return temp;
	}
	
	public int[][] updateMemory(int page,int disk){
		int distance;
		int[][] temp=this.memory;
		temp[disk][1]=page;
		distance=disk*this.memoryEachSize;
		this.memory=temp;
		System.out.print("移动的页表的页号:"+page+" 块号:"+disk+" 物理地址(H):"+Integer.toHexString(distance)+"H");
		System.out.println();
		System.out.println("内存使用情况");
		System.out.print("块号:   ");
		for(int i=0;i<this.memory.length;i++){
			System.out.printf("%-5d",this.memory[i][0]);
		}
		System.out.println();
		System.out.print("状态位:  ");
		for(int i=0;i<this.memory.length;i++){
			if(this.memory[i][1]==99999)
				System.out.printf("%-5c",'#');
			else System.out.printf("%-5d",this.memory[i][1]);
		}
		System.out.println();
		return temp;
	}
	
	public int[] initMemory(int num){//first 123
		int t=0,i=0;
		int[] temp=new int[num];
		while(t<num){
			if(this.memory[i][1]==-1){
				temp[t]=i;
				t++;
				i++;
			}
			else i++;
		}
		System.out.print("用于页面置换的块号: ");
		for(int j=0;j<temp.length;j++){
			System.out.printf("%-4d",temp[j]);
		}
		System.out.println();
		System.out.println();
		this.memoryFree=temp;
		return temp;
	}
	
	public void deleteMemory(){
		for(int i=0;i<this.memoryFree.length;i++){
			this.memory[this.memoryFree[i]][1]=-1;
		}
		System.out.println("内存回收");
		System.out.print("块号:   ");
		for(int i=0;i<this.memory.length;i++){
			System.out.printf("%-5d",this.memory[i][0]);
		}
		System.out.println();
		System.out.print("状态位:  ");
		for(int i=0;i<this.memory.length;i++){
			if(this.memory[i][1]==99999)
				System.out.printf("%-5c",'#');
			else System.out.printf("%-5d",this.memory[i][1]);
		}
		System.out.println();
	}
}
