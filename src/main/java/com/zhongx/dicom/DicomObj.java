/**
 * @author linsf
 */
package com.zhongx.dicom;



public class DicomObj  {

	private String SopInstanceUID;
	private String ImageType;
	private String TransferSyntaxUID;
	private String InstanceNumber;
	private String PhotometricInterpretation;
	private String SamplesPerPixel;
	private String PixelRepresentation;
	private String Columns;
	private String Rows;
	private String BitsAllocated;
	private String BitsStored;

	public String getSopInstanceUID() {
		return SopInstanceUID;
	}

	public void setSopInstanceUID(String sopInstanceUID) {
		SopInstanceUID = sopInstanceUID;
	}

	public String getImageType() {
		return ImageType;
	}

	public void setImageType(String imageType) {
		ImageType = imageType;
	}

	public String getTransferSyntaxUID() {
		return TransferSyntaxUID;
	}

	public void setTransferSyntaxUID(String transferSyntaxUID) {
		TransferSyntaxUID = transferSyntaxUID;
	}

	public String getInstanceNumber() {
		return InstanceNumber;
	}

	public void setInstanceNumber(String instanceNumber) {
		InstanceNumber = instanceNumber;
	}

	public String getPhotometricInterpretation() {
		return PhotometricInterpretation;
	}

	public void setPhotometricInterpretation(String photometricInterpretation) {
		PhotometricInterpretation = photometricInterpretation;
	}

	public String getSamplesPerPixel() {
		return SamplesPerPixel;
	}

	public void setSamplesPerPixel(String samplesPerPixel) {
		SamplesPerPixel = samplesPerPixel;
	}

	public String getPixelRepresentation() {
		return PixelRepresentation;
	}

	public void setPixelRepresentation(String pixelRepresentation) {
		PixelRepresentation = pixelRepresentation;
	}

	public String getColumns() {
		return Columns;
	}

	public void setColumns(String columns) {
		Columns = columns;
	}

	public String getRows() {
		return Rows;
	}

	public void setRows(String rows) {
		Rows = rows;
	}

	public String getBitsAllocated() {
		return BitsAllocated;
	}

	public void setBitsAllocated(String bitsAllocated) {
		BitsAllocated = bitsAllocated;
	}

	public String getBitsStored() {
		return BitsStored;
	}

	public void setBitsStored(String bitsStored) {
		BitsStored = bitsStored;
	}

}
