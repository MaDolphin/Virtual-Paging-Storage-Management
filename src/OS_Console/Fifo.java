package OS_Console;

public class Fifo {
	private int[] list;
	private int[] disk;
	private int[][] page;
	private int disknum,pagenum;
	Pro pro =new Pro();
	public Fifo(int pagenum,int disknum){
		this.disknum=disknum;
		this.pagenum=pagenum;
		this.list=pro.createList(pagenum,disknum);
		pro.createMemory(pagenum);
		this.disk=pro.initMemory(disknum);		
	}
	
	private void Fun(int x) {
		int num=0;
		int count=0;
		boolean flage=false;
		for(int i=x;i<this.list.length;i++){
			flage=false;
			for(int j=0;j<this.disknum;j++)
				if(this.page[j][0]==this.list[i]){
					System.out.println("未缺页不进行页面置换");
					System.out.println();
					flage=true;
					break;
				}
			if(!flage){
				if(num!=this.disknum){
					this.page[num][0]=this.list[i];						
					pro.updateMemory(this.page[num][0],this.page[num][1]);
					System.out.println();
					num++;
					count++;
				}
				else {
					num=0;
					this.page[num][0]=this.list[i];						
					pro.updateMemory(this.page[num][0],this.page[num][1]);
					System.out.println();
					num++;
					count++;
				}
			}
		}	
		System.out.println("总共移动次数为："+count+"次");
		System.out.println();
	}
	
	private void init() {
		int num=0;
		boolean flage=false;
		this.page=new int[disknum][2];
		for(int i=0;i<this.disknum;i++)
			this.page[i][0]=-1;
		int i=0;
		while(this.page[this.disknum-1][0]==-1){
			for(int j=0;j<this.disknum;j++){
				flage=false;
				if(this.page[j][0]==this.list[i]){
					flage=true;
					break;
				}
			}
			if(!flage){
				this.page[num][0]=this.list[i];
				this.page[num][1]=this.disk[num];
				pro.updateMemory(this.page[num][0],this.page[num][1]);
				System.out.println();
				num++;
			}
			i++;
		}
		this.Fun(i);
		pro.deleteMemory();
	}
	
	public static void main(String[] args){
		System.out.println("FIFO");
		Fifo fi =new Fifo(10,3);
		fi.init();
	}
}