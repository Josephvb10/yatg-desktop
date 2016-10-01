package cr.tec.yatg.desktop.services.Structures;

public class SimpleNodo {
	private SimpleNodo next;
	private String nodeType;
	private int xr,xl,yr,yl;
	
	public SimpleNodo(String nodeType){
		this.next=null;
		this.nodeType = nodeType;		
	}
	
	public int getXL(){ return this.xl;}
	public int getYL(){ return this.yl;}
	public void setVerticeUL(int xl, int yl){
		this.xl = xl;
		this.yl = yl;
	}
	
	public int getXR(){ return this.xr;}
	public int getYR(){ return this.yr;}
	public void setVerticeDR(int xr, int yr){
		this.xr = xr;
		this.yr = yr;
	}
	public void setNodeType(String nodeType){this.nodeType = nodeType;}
	public String getNodeType(){return this.nodeType;}
	
	public void setNext(SimpleNodo nodo){this.next = nodo;}
	public SimpleNodo getNext(){return this.next;}
	

}
