package  pl.olointeria.assessment.dto;


public class SupplierPSCPSDto {


    private Integer id;
    private String name;
    private String id_Sap;
    private String classification;
    private Long totalScore;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId_Sap() {
        return id_Sap;
    }
    public void setId_Sap(String id_Sap) {
        this.id_Sap = id_Sap;
    }
    public String getClassification() {
        return classification;
    }
    public void setClassification(String classification) {
        this.classification = classification;
    }
    public Long getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(Long totalScore) {
        this.totalScore = totalScore;
    }


    public void add(int i, SupplierPSCPSDto listSuppliersPSCPSDto) {
    }
}

