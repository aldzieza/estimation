package pl.olointeria.assessment.prima;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SupplierPSCPS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length =45, nullable =false,unique = true)
    private String name;

    @Column(length =45, nullable =false,unique = false)
    private String id_Sap;

    @Column(length =1, nullable =false)
    private String classification;
    @Column(length =3, nullable =false)
    private Long totalScore;



    public SupplierPSCPS(String name, String id_Sap, String classification, Long totalScore) {
        this.name = name;
        this.id_Sap = id_Sap;
        this.classification = classification;
        this.totalScore = totalScore;
    }

    public SupplierPSCPS() {
    }

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

    public void setlassification(String classification) {
        this.classification = classification;
    }

    public Long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Long totalScore) {
        this.totalScore = totalScore;
    }



}
