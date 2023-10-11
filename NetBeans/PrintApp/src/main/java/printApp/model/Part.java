package printApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class Part extends Entitet {
	
        @Column(nullable = false)
	private String partName;
	private String stlOriginal;
	private String stlSupported;
	private String slicedFile;
        @ManyToOne
	private Project project;
	
	
	
	
	
	public Part(Integer id, String partName, String stlOriginal, String stlSupported, String slicedFile, Project project) {
		super(id);
		this.partName = partName;
		this.stlOriginal = stlOriginal;
		this.stlSupported = stlSupported;
		this.slicedFile = slicedFile;
		this.project = project;
	}

	
	public Part() {
		super();
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getStlOriginal() {
		return stlOriginal;
	}
	public void setStlOriginal(String stlOriginal) {
		this.stlOriginal = stlOriginal;
	}
	public String getStlSupported() {
		return stlSupported;
	}
	public void setStlSupported(String stlSupported) {
		this.stlSupported = stlSupported;
	}
	public String getSlicedFile() {
		return slicedFile;
	}
	public void setSlicedFile(String slicedFile) {
		this.slicedFile = slicedFile;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	
	@Override
	public String toString() {
		
		return partName;
	}

}
