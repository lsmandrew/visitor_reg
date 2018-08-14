package com.ja.visitor_reg.json;

/**
 * 来访者信息
 * {
 * "birthday": "2018-08-13T02:00:45.242Z",
 * "carry": "string",
 * "carryImage": "string",
 * "censusAddr": "string",
 * "certificateNum": "string",
 * "certificateType": "string",
 * "enterTime": "2018-08-13T02:00:45.242Z",
 * "eventId": 0,
 * "headImage": "string",
 * "icNumber": "string",
 * "id": 0,
 * "idHeadImage": "string",
 * "idImage": "string",
 * "idScanImage": "string",
 * "isMain": 0,
 * "leaveTime": "2018-08-13T02:00:45.242Z",
 * "nation": "string",
 * "physicsNumber": "string",
 * "sex": 0,
 * "vehicleNumber": "string",
 * "visitorPhone": "string",
 * "visitorUnit": "string",
 * "vistorName": "string"
 * }
 */
public class VISITOR_INFO_UPLOAD {
    private String birthday;
    private String carry;
    private String carryImage;
    private String censusAddr;
    private String certificateNum;
    private String certificateType;
    private String enterTime;
    private String eventId;
    private String headImage;
    private String icNumber;
    private Long id;
    private String idHeadImage;
    private String idImage;
    private String idScanImage;
    private Long isMain;
    private String leaveTime;
    private String nation;
    private String physicsNumber;
    private Long sex;
    private String vehicleNumber;
    private String visitorPhone;
    private String visitorUnit;
    private String vistorName;

    @Override
    public String toString() {
        return "VISITOR_INFO{" +
                "birthday='" + birthday + '\'' +
                ", carry='" + carry + '\'' +
                ", carryImage='" + carryImage + '\'' +
                ", censusAddr='" + censusAddr + '\'' +
                ", certificateNum='" + certificateNum + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", enterTime='" + enterTime + '\'' +
                ", eventId='" + eventId + '\'' +
                ", headImage='" + headImage + '\'' +
                ", icNumber='" + icNumber + '\'' +
                ", id=" + id +
                ", idHeadImage='" + idHeadImage + '\'' +
                ", idImage='" + idImage + '\'' +
                ", idScanImage='" + idScanImage + '\'' +
                ", isMain=" + isMain +
                ", leaveTime='" + leaveTime + '\'' +
                ", nation='" + nation + '\'' +
                ", physicsNumber='" + physicsNumber + '\'' +
                ", sex=" + sex +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", visitorPhone='" + visitorPhone + '\'' +
                ", visitorUnit='" + visitorUnit + '\'' +
                ", vistorName='" + vistorName + '\'' +
                '}';
    }

    public VISITOR_INFO_UPLOAD() {
    }

    public VISITOR_INFO_UPLOAD(String birthday, String carry, String carryImage, String censusAddr, String
            certificateNum, String certificateType, String enterTime, String eventId, String headImage, String
            icNumber, Long id, String idHeadImage, String idImage, String idScanImage, Long isMain, String leaveTime,
                               String nation, String physicsNumber, Long sex, String vehicleNumber, String
                                       visitorPhone, String visitorUnit, String vistorName) {
        this.birthday = birthday;
        this.carry = carry;
        this.carryImage = carryImage;
        this.censusAddr = censusAddr;
        this.certificateNum = certificateNum;
        this.certificateType = certificateType;
        this.enterTime = enterTime;
        this.eventId = eventId;
        this.headImage = headImage;
        this.icNumber = icNumber;
        this.id = id;
        this.idHeadImage = idHeadImage;
        this.idImage = idImage;
        this.idScanImage = idScanImage;
        this.isMain = isMain;
        this.leaveTime = leaveTime;
        this.nation = nation;
        this.physicsNumber = physicsNumber;
        this.sex = sex;
        this.vehicleNumber = vehicleNumber;
        this.visitorPhone = visitorPhone;
        this.visitorUnit = visitorUnit;
        this.vistorName = vistorName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCarry() {
        return carry;
    }

    public void setCarry(String carry) {
        this.carry = carry;
    }

    public String getCarryImage() {
        return carryImage;
    }

    public void setCarryImage(String carryImage) {
        this.carryImage = carryImage;
    }

    public String getCensusAddr() {
        return censusAddr;
    }

    public void setCensusAddr(String censusAddr) {
        this.censusAddr = censusAddr;
    }

    public String getCertificateNum() {
        return certificateNum;
    }

    public void setCertificateNum(String certificateNum) {
        this.certificateNum = certificateNum;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdHeadImage() {
        return idHeadImage;
    }

    public void setIdHeadImage(String idHeadImage) {
        this.idHeadImage = idHeadImage;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getIdScanImage() {
        return idScanImage;
    }

    public void setIdScanImage(String idScanImage) {
        this.idScanImage = idScanImage;
    }

    public Long getIsMain() {
        return isMain;
    }

    public void setIsMain(Long isMain) {
        this.isMain = isMain;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPhysicsNumber() {
        return physicsNumber;
    }

    public void setPhysicsNumber(String physicsNumber) {
        this.physicsNumber = physicsNumber;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVisitorPhone() {
        return visitorPhone;
    }

    public void setVisitorPhone(String visitorPhone) {
        this.visitorPhone = visitorPhone;
    }

    public String getVisitorUnit() {
        return visitorUnit;
    }

    public void setVisitorUnit(String visitorUnit) {
        this.visitorUnit = visitorUnit;
    }

    public String getVistorName() {
        return vistorName;
    }

    public void setVistorName(String vistorName) {
        this.vistorName = vistorName;
    }
}
