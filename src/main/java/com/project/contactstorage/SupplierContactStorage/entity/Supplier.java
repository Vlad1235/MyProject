package com.project.contactstorage.SupplierContactStorage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(description = "Details about the supplier")
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(notes ="the unique Id of the each supplier")
    @Column(name="id")
    private int id;

    @ApiModelProperty(notes ="the supplier company's name")
    @Column(name = "company_website")
    private String companyWebSite;

    @ApiModelProperty(notes ="the responsible managers's name")
    @Column(name = "manager_name")
    private String managerName;

    @ApiModelProperty(notes ="the responsible managers's email")
    @Column(name = "manager_email")
    private String managerEmail;

    @ApiModelProperty(notes ="the supplier company's name")
    @Column(name = "company_name")
    private String companyName;

    @ApiModelProperty(notes ="the product's name")
    @Column(name = "product_name")
    private String productName;

    public Supplier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyWebSite() {
        return companyWebSite;
    }

    public void setCompanyWebSite(String companyWebSite) {
        this.companyWebSite = companyWebSite;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", companyWebSite='" + companyWebSite + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", companyName='" + companyName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
