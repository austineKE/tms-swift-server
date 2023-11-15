package co.sys.procurement.tmsswiftserver.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "material_id")
    private int id;
    @Column(name = "material_srn")
    private int srn;
    @Column(name = "material_cost")
    private BigDecimal cost;
    @Column(name = "material_type")
    private String type;
    @Column(name = "material_list")
    private String materialList;
    @Column(name = "material_delivery_date")
    private Date deliveryDate;
    @Column(name = "material_transport_cost")
    private BigDecimal transportCost;
    @Column(name = "material_transport_type")
    private String transportType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSrn() {
        return srn;
    }

    public void setSrn(int srn) {
        this.srn = srn;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterialList() {
        return materialList;
    }

    public void setMaterialList(String materialList) {
        this.materialList = materialList;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public BigDecimal getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(BigDecimal transportCost) {
        this.transportCost = transportCost;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }
}
