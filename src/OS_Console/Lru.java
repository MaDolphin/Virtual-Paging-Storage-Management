package OS_Console;

public class Lru {
	private int[] list;
	private int[] disk;
	private int[][] page;
	private int disknum,pagenum;
	Pro pro =new Pro();
	public Lru(int pagenum,int disknum){
		this.disknum=disknum;
		this.pagenum=pagenum;
		this.list=pro.createList(pagenum,disknum);
		pro.createMemory(pagenum);
		this.disk=pro.initMemory(disknum);		
	}
	
	public void Fun(int []t,int x){
		int m=0;
		int count=0;
		boolean flage=false;
		for(int i=x;i<this.list.length;i++){
			flage=false;
			for(int j=0;j<this.disknum;j++)
				if(this.list[i]==t[j]){	
					for(;j<this.disknum-1;j++)
						t[j]=t[j+1];
					t[this.disknum-1]=this.list[i];
					flage=true;
					break;
				}
			if(!flage){
				for(int j=0;j<this.disknum;j++)
					if(this.page[j][0]==t[0]){
						this.page[j][0]=this.list[i];						
						pro.updateMemory(this.page[j][0],this.page[j][1]);
						System.out.println();
						count++;
						break;
					}
				for(m=0;m<this.disknum-1;m++)
					t[m]=t[m+1];
				t[this.disknum-1]=this.list[i];
			}
			else{
				System.out.println("未缺页不进行页面置换");
				System.out.println();
			}
		}
		System.out.println("总共移动次数为："+count+"次");
		System.out.println();
	}
	
	public void init(){
		int x,count;
		int num=0;
		boolean flage=false;
		int []t =new int [this.disknum];
		this.page=new int[disknum][2];
		for(int i=0;i<this.disknum;i++){
			this.page[i][0]=-1;
			t[i]=-1;
		}
		int i=0;
		while(this.page[this.disknum-1][0]==-1){
			for(int j=0;t[j]!=-1;j++){
				flage=false;
				count=-1;
				if(t[j]==this.list[i]){		
					x=t[j];
					for(;count<this.disknum&&t[count+1]!=-1;count++){						
					}								
					for(;j<count+1;j++)
						t[j]=t[j+1];
					t[count]=x;
					flage=true;
					break;
				}
			}
			if(!flage){
				t[num]=this.list[i];
				this.page[num][0]=this.list[i];
				this.page[num][1]=this.disk[num];
				pro.updateMemory(this.page[num][0],this.page[num][1]);
				System.out.println();
				num++;
			}
			for(int j=0;j<this.page.length;j++){
				System.out.println("页号："+this.page[j][0]+""+"块号："+this.page[j][1]);
			}
			i++;
		}
		this.Fun(t, i);
		pro.deleteMemory();
	}
	
	public static void main(String[] args){
		System.out.println("LRU");
		Lru lru =new Lru(10,4);
		lru.init();
	}
}