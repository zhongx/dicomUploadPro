package com.zhongx.dicom;

import java.io.File;
import java.util.UUID;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomInputStream;


/**
 */
public class DicomUtil {

    public DrtbMetaEntity readDicom(File file) {

        DrtbMetaEntity entity = new DrtbMetaEntity();
        Attributes attr = null;
        try {
            DicomInputStream dis = new DicomInputStream(file);
            attr = dis.readDataset(-1, -1);

            // set CharacterSet gb18030
            attr.setString(Tag.SpecificCharacterSet, VR.CS, "GB18030");

            entity.setFguid(UUID.randomUUID().toString());
            entity.setStudyDate(attr.getString(Tag.StudyDate));
            entity.setSeriesDate(attr.getString(Tag.SeriesDate));
            entity.setContentDate(attr.getString(Tag.ContentDate));
            entity.setStudyTime(attr.getString(Tag.StudyTime));
            entity.setSeriesTime(attr.getString(Tag.SeriesTime));
            entity.setContentTime(attr.getString(Tag.ContentTime));
            entity.setPatientID(attr.getString(Tag.PatientID));
            entity.setPatientName(attr.getString(Tag.PatientName));
            entity.setInstanceNumber(attr.getString(Tag.InstanceNumber));
            entity.setSeriesDescription(attr.getString(Tag.SeriesDescription));
            entity.setImageComments(attr.getString(Tag.ImageComments));

        } catch (Exception e) {
            e.printStackTrace();
            entity = null;
        }

        return entity;
    }
}
