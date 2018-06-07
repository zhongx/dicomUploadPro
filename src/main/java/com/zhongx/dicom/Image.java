/**
 * @author linsf
 */
package com.zhongx.dicom;



public class Image  {

	private String PixelSpacing;
	private String SliceLocation;
	private String SliceThickness;
	private String ImagePositionPatient;
	private String ImageOrientation;

	public String getPixelSpacing() {
		return PixelSpacing;
	}

	public void setPixelSpacing(String pixelSpacing) {
		PixelSpacing = pixelSpacing;
	}

	public String getSliceLocation() {
		return SliceLocation;
	}

	public void setSliceLocation(String sliceLocation) {
		SliceLocation = sliceLocation;
	}

	public String getSliceThickness() {
		return SliceThickness;
	}

	public void setSliceThickness(String sliceThickness) {
		SliceThickness = sliceThickness;
	}

	public String getImagePositionPatient() {
		return ImagePositionPatient;
	}

	public void setImagePositionPatient(String imagePositionPatient) {
		ImagePositionPatient = imagePositionPatient;
	}

	public String getImageOrientation() {
		return ImageOrientation;
	}

	public void setImageOrientation(String imageOrientation) {
		ImageOrientation = imageOrientation;
	}

}
