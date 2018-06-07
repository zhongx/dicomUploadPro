CREATE TABLE [dbo].[drtb_meta] (
  [fautoinc] int  IDENTITY(1,1) NOT NULL,
  [fguid] char(40) COLLATE Chinese_PRC_CI_AS  NULL,
  [StudyDate] varchar(8) COLLATE Chinese_PRC_CI_AS  NULL,
  [SeriesDate] varchar(8) COLLATE Chinese_PRC_CI_AS  NULL,
  [ContentDate] varchar(8) COLLATE Chinese_PRC_CI_AS  NULL,
  [StudyTime] varchar(6) COLLATE Chinese_PRC_CI_AS  NULL,
  [SeriesTime] varchar(6) COLLATE Chinese_PRC_CI_AS  NULL,
  [ContentTime] varchar(6) COLLATE Chinese_PRC_CI_AS  NULL,
  [GFrom] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [PatientID] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [PatientName] varchar(30) COLLATE Chinese_PRC_CI_AS  NULL,
  [InstanceNumber] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [SeriesDescription] varchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [ImageComments] varchar(2000) COLLATE Chinese_PRC_CI_AS  NULL,
  [filename] varchar(500) COLLATE Chinese_PRC_CI_AS  NULL,
  [flag] int  NULL
)


