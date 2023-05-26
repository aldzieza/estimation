package pl.olointeria.assessment.component;

import javax.persistence.*;

@Entity
public class ComponentPSCPS {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String sapName;
    private String sapNumber;
    private String id_Sap;
    private String customer;
    private Long ppm;
    private Long certificate;
    private Long approval;
    private String auditResult;
    private String pscr;
    private String location;
    private String deliveryDeley;
    private String interference;
    private String collaboration;
    private Long averageScore;
    private String primaPlant;
    private String supplier;



    public ComponentPSCPS(){};

    public ComponentPSCPS(Long id, String sapName, String sapNumber, String id_Sap, String customer, Long ppm, Long certificate, Long approval, String auditResult, String pscr, String location, String deliveryDeley, String interference, String collaboration, Long averageScore, String primaPlant, String supplier) {
        this.id = id;
        this.sapName = sapName;
        this.sapNumber = sapNumber;
        this.id_Sap = id_Sap;
        this.customer = customer;
        this.ppm = ppm;
        this.certificate = certificate;
        this.approval = approval;
        this.auditResult = auditResult;
        this.pscr = pscr;
        this.location = location;
        this.deliveryDeley = deliveryDeley;
        this.interference = interference;
        this.collaboration = collaboration;
        this.averageScore = averageScore;
        this.primaPlant = primaPlant;
         this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSapName() {
        return sapName;
    }

    public void setSapName(String sapName) {
        this.sapName = sapName;
    }

    public String getSapNumber() {
        return sapNumber;
    }

    public void setSapNumber(String sapNumber) {
        this.sapNumber = sapNumber;
    }

    public String getId_Sap() {
        return id_Sap;
    }

    public void setId_Sap(String id_Sap) {
        this.id_Sap = id_Sap;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getPpm() {
        return ppm;
    }

    public void setPpm(Long ppm) {
        this.ppm = ppm;
    }

    public Long getCertificate() {
        return certificate;
    }

    public void setCertificate(Long certificate) {
        this.certificate = certificate;
    }

    public Long getApproval() {
        return approval;
    }

    public void setApproval(Long approval) {
        this.approval = approval;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public String getPscr() {
        return pscr;
    }

    public void setPscr(String pscr) {
        this.pscr = pscr;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeliveryDeley() {
        return deliveryDeley;
    }

    public void setDeliveryDeley(String deliveryDeley) {
        this.deliveryDeley = deliveryDeley;
    }

    public String getInterference() {
        return interference;
    }

    public void setInterference(String interference) {
        this.interference = interference;
    }

    public String getCollaboration() {
        return collaboration;
    }

    public void setCollaboration(String collaboration) {
        this.collaboration = collaboration;
    }

    public Long getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Long averageScore) {
        this.averageScore = averageScore;
    }

    public String getPrimaPlant() {
        return primaPlant;
    }

    public void setPrimaPlant(String primaPlant) {
        this.primaPlant = primaPlant;
    }
     public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
