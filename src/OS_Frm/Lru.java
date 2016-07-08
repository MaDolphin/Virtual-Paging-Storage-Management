package OS_Frm;

public class Lru {
	public int[] disk,t;
	public int[][] page;
	public int disknum,pagenum,len;
	Pro pro =new Pro();
	public Lru(int pagenum,int disknum){
		this.disknum=disknum;
		this.pagenum=pagenum;
		this.len=pagenum*pro.memoryEachSize;
		this.disk=pro.initMemory(disknum);	
		this.t =new int [this.disknum];
		this.page=new int[disknum][2];
		for(int i=0;i<this.disknum;i++){
			this.page[i][1]=this.disk[i];
			this.page[i][0]=-1;
			t[i]=-1;		
		}
	}
	
	public int[] Skip(int [] x){
		int [] temp=new int [3];
		temp[0]=x[0];
		temp[1]=x[1];
		if(this.page[this.disknum-1][1]==-1)
			temp[2]=this.init(x[0]);			
		else temp[2]=this.Fun(x[0]);			
		return temp;		
	}
	
	public int Fun(int x){
		int temp=-1;
		boolean flage=false;
		for(int j=0;j<this.disknum;j++)
			if(x==t[j]){	
				for(;j<this.disknum-1;j++)
					t[j]=t[j+1];
				t[this.disknum-1]=x;
				flage=true;
				for(int i=0;i<this.disknum;i++)
					if(this.page[i][0]==x)
						temp=this.page[i][1];
				break;
			}
		if(!flage){
			for(int i=0;i<this.disknum;i++)
				if(this.page[i][0]==t[0]){
					this.page[i][0]=x;	
					temp=this.page[i][1];
					break;
				}
			for(int j=0;j<this.disknum-1;j++)
				t[j]=t[j+1];
			t[this.disknum-1]=x;
		}
		for(int j=0;j<this.page.length;j++){
			System.out.println("Ò³ºÅ£º"+this.page[j][0]+""+"¿éºÅ£º"+this.page[j][1]);
		}
		return temp;
	}
	
	public int init(int x){
		int temp = 0,count,a;
		boolean flage=false;
		for(int i=0;t[i]!=-1;i++){
			flage=false;
			count=-1;
			if(t[i]==x){		
				a=t[i];
				for(;count<this.disknum&&t[count+1]!=-1;count++){						
				}								
				for(;i<count+1;i++)
					t[i]=t[i+1];
				t[count]=a;
				flage=true;
				for(int j=0;j<this.disknum;j++)
					if(this.page[j][0]==x)
						temp=this.page[i][1];
				break;
			}
		}
		if(!flage)
			for(int i=0;i<this.disknum;i++)
				if(this.page[i][1]==-1){
					t[i]=x;
					this.page[i][0]=x;	
					this.page[i][1]=this.disk[i];
					temp=this.disk[i];					
				}
		for(int j=0;j<this.page.length;j++){
			System.out.println("Ò³ºÅ£º"+this.page[j][0]+""+"¿éºÅ£º"+this.page[j][1]);
		}
		return temp;
	}
}
