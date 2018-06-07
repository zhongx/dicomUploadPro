/**
 * @author linsf
 */
package com.zhongx.dicom;



public class Series  {

	private String SeriesInstanceUID;
	private String SeriesDate;
	private String SeriesNumber;
	private String Modality;
	private String InstitutionName;

	public String getSeriesInstanceUID() {
		return SeriesInstanceUID;
	}

	public void setSeriesInstanceUID(String seriesInstanceUID) {
		SeriesInstanceUID = seriesInstanceUID;
	}

	public String getSeriesDate() {
		return SeriesDate;
	}

	public void setSeriesDate(String seriesDate) {
		SeriesDate = seriesDate;
	}

	public String getSeriesNumber() {
		return SeriesNumber;
	}

	public void setSeriesNumber(String seriesNumber) {
		SeriesNumber = seriesNumber;
	}

	public String getModality() {
		return Modality;
	}

	public void setModality(String modality) {
		Modality = modality;
	}

	public String getInstitutionName() {
		return InstitutionName;
	}

	public void setInstitutionName(String institutionName) {
		InstitutionName = institutionName;
	}

}
