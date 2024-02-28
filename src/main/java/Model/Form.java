package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="forms")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    
    @Column
    private String fullName;

    @Column
    private String fatherName;

    @Column
    private String motherName;

    @Column
    private String DOB;

    @Column
    private String gender;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private String country;

    @Column
    private String city;

    @Lob
    @Column(length = 1000000)
    private byte[] picture;

    @Column
    private String filename;

    @Lob
    @Column(length = 1000000)
    private byte[] diplomaFile;

    @Column
    private String department;

    @Column
    private String degree;

    @Column
    private String status;


    public Form() {
        
    }

    public Form(String fullName, String fatherName, String motherName, String dOB, String gender, String email,
            String phone, String address, String country, String city, byte[] picture, String filename, byte[] file,
            String department, String degree, String status) {
        this.fullName = fullName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        DOB = dOB;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.country = country;
        this.city = city;
        this.picture = picture;
        this.filename = filename;
        this.diplomaFile = file;
        this.department = department;
        this.degree = degree;
        this.status = status;
    }

    
    public byte[] getDiplomaFile() {
        return diplomaFile;
    }

    public void setDiplomaFile(byte[] diplomaFile) {
        this.diplomaFile = diplomaFile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getFile() {
        return diplomaFile;
    }

    public void setFile(byte[] file) {
        this.diplomaFile = file;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    
}
