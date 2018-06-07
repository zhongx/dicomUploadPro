/**
 * @author linsf
 */
package com.zhongx.dicom;

import java.util.List;



public class Study  {

	private String PatientName;
	private String PatientID;
	private String PatientSex;
	private String PatientAge;
	private String StudyInstanceUID;
	private String StudyDate;
	private String StudyID;

	private List<Series> series;
	private List<DicomObj> dicomObjs;
	private List<Image> images;

	public String getPatientName() {
		return PatientName;
	}

	public void setPatientName(String patientName) {
		PatientName = patientName;
	}

	public String getPatientID() {
		return PatientID;
	}

	public void setPatientID(String patientID) {
		PatientID = patientID;
	}

	public String getPatientSex() {
		return PatientSex;
	}

	public void setPatientSex(String patientSex) {
		PatientSex = patientSex;
	}

	public String getPatientAge() {
		return PatientAge;
	}

	public void setPatientAge(String patientAge) {
		PatientAge = patientAge;
	}

	public String getStudyInstanceUID() {
		return StudyInstanceUID;
	}

	public void setStudyInstanceUID(String studyInstanceUID) {
		StudyInstanceUID = studyInstanceUID;
	}

	public String getStudyDate() {
		return StudyDate;
	}

	public void setStudyDate(String studyDate) {
		StudyDate = studyDate;
	}

	public String getStudyID() {
		return StudyID;
	}

	public void setStudyID(String studyID) {
		StudyID = studyID;
	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

	public List<DicomObj> getDicomObjs() {
		return dicomObjs;
	}

	public void setDicomObjs(List<DicomObj> dicomObjs) {
		this.dicomObjs = dicomObjs;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
