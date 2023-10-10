package printApp.model;



public class Material extends Entitet {
	
	private String materialName;
	private String manufacturer;
	private float costPerUnit;
	private float calibratedExposure;
	private float layerHeight;
	private float bottomExposure;
	private int liftDistance;
	private float liftSpeed;
	private int bottomLiftDistance;
	private float bottomLiftSpeed;
	private float retractSpeed;
	private float bottomRetractSpeed;
	private float lightOffDelay;
	
	
	
	
	public Material(int id, String materialName, String manufacturer, float costPerUnit, float calibratedExposure,
			float layerHeight, float bottomExposure, int liftDistance, float liftSpeed, int bottomLiftDistance,
			float bottomLiftSpeed, float retractSpeed, float bottomRetractSpeed, float lightOffDelay) {
		super(id);
		this.materialName = materialName;
		this.manufacturer = manufacturer;
		this.costPerUnit = costPerUnit;
		this.calibratedExposure = calibratedExposure;
		this.layerHeight = layerHeight;
		this.bottomExposure = bottomExposure;
		this.liftDistance = liftDistance;
		this.liftSpeed = liftSpeed;
		this.bottomLiftDistance = bottomLiftDistance;
		this.bottomLiftSpeed = bottomLiftSpeed;
		this.retractSpeed = retractSpeed;
		this.bottomRetractSpeed = bottomRetractSpeed;
		this.lightOffDelay = lightOffDelay;
	}
	public Material() {
		super();
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public float getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(float costPerUnit) {
		this.costPerUnit = costPerUnit;
	}
	public float getCalibratedExposure() {
		return calibratedExposure;
	}
	public void setCalibratedExposure(float calibratedExposure) {
		this.calibratedExposure = calibratedExposure;
	}
	public float getLayerHeight() {
		return layerHeight;
	}
	public void setLayerHeight(float layerHeight) {
		this.layerHeight = layerHeight;
	}
	public float getBottomExposure() {
		return bottomExposure;
	}
	public void setBottomExposure(float bottomExposure) {
		this.bottomExposure = bottomExposure;
	}
	public int getLiftDistance() {
		return liftDistance;
	}
	public void setLiftDistance(int liftDistance) {
		this.liftDistance = liftDistance;
	}
	public float getLiftSpeed() {
		return liftSpeed;
	}
	public void setLiftSpeed(float liftSpeed) {
		this.liftSpeed = liftSpeed;
	}
	public int getBottomLiftDistance() {
		return bottomLiftDistance;
	}
	public void setBottomLiftDistance(int bottomLiftDistance) {
		this.bottomLiftDistance = bottomLiftDistance;
	}
	public float getBottomLiftSpeed() {
		return bottomLiftSpeed;
	}
	public void setBottomLiftSpeed(float bottomLiftSpeed) {
		this.bottomLiftSpeed = bottomLiftSpeed;
	}
	public float getRetractSpeed() {
		return retractSpeed;
	}
	public void setRetractSpeed(float retractSpeed) {
		this.retractSpeed = retractSpeed;
	}
	public float getBottomRetractSpeed() {
		return bottomRetractSpeed;
	}
	public void setBottomRetractSpeed(float bottomRetractSpeed) {
		this.bottomRetractSpeed = bottomRetractSpeed;
	}
	public float getLightOffDelay() {
		return lightOffDelay;
	}
	public void setLightOffDelay(float lightOffDelay) {
		this.lightOffDelay = lightOffDelay;
	}
	
	
	

}
