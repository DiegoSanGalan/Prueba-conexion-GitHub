package evaluacion.primera;

/**
 * Clase RegionDTO
 * @author Diego Santamaría
 *
 */
public class RegionDTO {

	private int REGION_ID;
	private String REGION_NAME;
	
	/**
	 * Constructor de la clas RegionDTO
	 * @param region_ID Tipo int
	 * @param region_NAME Tipo String
	 */
	public RegionDTO(int region_ID, String region_NAME) {
		//super();
		REGION_ID = region_ID;
		REGION_NAME = region_NAME;
	}
	
	/**
	 * @return the rEGION_ID
	 */
	public int getREGION_ID() {
		return REGION_ID;
	}

	/**
	 * @param rEGION_ID the rEGION_ID to set
	 */
	public void setREGION_ID(int rEGION_ID) {
		REGION_ID = rEGION_ID;
	}

	/**
	 * @return the rEGION_NAME
	 */
	public String getREGION_NAME() {
		return REGION_NAME;
	}

	/**
	 * @param rEGION_NAME the rEGION_NAME to set
	 */
	public void setREGION_NAME(String rEGION_NAME) {
		REGION_NAME = rEGION_NAME;
	}

	
	
	
	
}
