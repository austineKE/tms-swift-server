package co.sys.procurement.tmsswiftserver.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "quotation")
public class Quotation {
    @Id
    @Column(name = "quotation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "quotation_guid")
    private String guid;
    @Column(name = "quotation_srn")
    private BigInteger quotation_srn;
    @Column(name = "quotation_quote")
    private String quote;
    @Column(name = "quotation_validity")
    private String validity;
    @Column(name = "quotation_delivery_time")
    private String deliveryTime;
    @Column(name = "quotation_material_cost_id")
    private int materialCostId;
    @ManyToOne
    @JoinColumn(name = "quotation_srn", referencedColumnName = "project_srn",  // a reference to a non-PK column
            foreignKey = @ForeignKey(name="quotation_project_fk"))
    private Project project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public BigInteger getQuotation_srn() {
        return quotation_srn;
    }

    public void setQuotation_srn(BigInteger quotation_srn) {
        this.quotation_srn = quotation_srn;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getMaterialCostId() {
        return materialCostId;
    }

    public void setMaterialCostId(int materialCostId) {
        this.materialCostId = materialCostId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
