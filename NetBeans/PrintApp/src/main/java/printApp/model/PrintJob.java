package printApp.model;

public class PrintJob extends Entitet {
	
	private float cost;
	private boolean result;
	private Printer printer;
	private Material material;
	private Part part;
	
	
	
	public PrintJob() {
		super();
	}
	public PrintJob(int id, float cost, boolean result, Printer printer, Material material, Part part) {
		super(id);
		this.cost = cost;
		this.result = result;
		this.printer = printer;
		this.material = material;
		this.part = part;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Printer getPrinter() {
		return printer;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	
	

}
