package OS_Console;
public class Pro {
	public int[][] memory;
	public int[] memoryFree;
	public int memoryEachSize=1024;
	
	public int[] createList(int pagenum,int disknum){
		int[] temp=new int[pagenum];
		System.out.println("�ó����ҳ����Ϊ"+pagenum+"ҳ���ɷ�����߼���Ϊ"+disknum+"��");
		for(int i=0;i<temp.length;i++){
			temp[i]=(int)(Math.random()*pagenum);
		}
		System.out.print("������������: ");
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
		System.out.print("�ƶ���ҳ���ҳ��:"+page+" ���:"+disk+" �����ַ(H):"+Integer.toHexString(distance)+"H");
		System.out.println();
		System.out.println("�ڴ�ʹ�����");
		System.out.print("���:   ");
		for(int i=0;i<this.memory.length;i++){
			System.out.printf("%-5d",this.memory[i][0]);
		}
		System.out.println();
		System.out.print("״̬λ:  ");
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
		System.out.print("����ҳ���û��Ŀ��: ");
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
		System.out.println("�ڴ����");
		System.out.print("���:   ");
		for(int i=0;i<this.memory.length;i++){
			System.out.printf("%-5d",this.memory[i][0]);
		}
		System.out.println();
		System.out.print("״̬λ:  ");
		for(int i=0;i<this.memory.length;i++){
			if(this.memory[i][1]==99999)
				System.out.printf("%-5c",'#');
			else System.out.printf("%-5d",this.memory[i][1]);
		}
		System.out.println();
	}
}
