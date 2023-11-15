package co.sys.procurement.tmsswiftserver.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "project_srn")
    private BigInteger srn;
    @Column(name = "projectname")
    private String nameOfProject;
    @Column(name = "projectcode")
    private String projectCode;
    @Column(name = "location")
    private String location;
    @Column(name = "timeline")
    private String timeline;
    @JsonIgnore
    @Column(name = "IsTermsAgreed")
    private String termsAndCondition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfProject() {
        return nameOfProject;
    }

    public void setNameOfProject(String nameOfProject) {
        this.nameOfProject = nameOfProject;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public String isTermsAndCondition() {
        return termsAndCondition;
    }

    public void setTermsAndCondition(String termsAndCondition) {
        this.termsAndCondition = termsAndCondition;
    }

    public BigInteger getSrn() {
        return srn;
    }

    public void setSrn(BigInteger srn) {
        this.srn = srn;
    }

    public String getTermsAndCondition() {
        return termsAndCondition;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", nameOfProject='" + nameOfProject + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", location='" + location + '\'' +
                ", timeline='" + timeline + '\'' +
                ", termsAndCondition=" + termsAndCondition +
                '}';
    }
}
