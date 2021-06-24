package com.lightshell.zen.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name="convenientinformation")
public class ConvenientInformation {
    private int id;
    private String name;
    private String fullname;
    private String locationPhoto;
    private Double lat;
    private Double lng;
    private String category;
    private String province;
    private String city;
    private String district;
    private String town;
    private String street;
    private String streetNumber;
    private String address;
    private String committee;
    private String businessHours;
    private String contacter;
    private String avatar;
    private String tel;
    private String fax;
    private String status;
    private String creator;
    private Timestamp credate;
    private String optuser;
    private Timestamp optdate;
    private String cfmuser;
    private Timestamp cfmdate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "fullname", nullable = true, length = 400)
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "locationPhoto", nullable = true, length = 400)
    public String getLocationPhoto() {
        return locationPhoto;
    }

    public void setLocationPhoto(String locationPhoto) {
        this.locationPhoto = locationPhoto;
    }

    @Basic
    @Column(name = "lat", nullable = true, precision = 0)
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "lng", nullable = true, precision = 0)
    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Basic
    @Column(name = "category", nullable = true, length = 45)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 45)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "district", nullable = true, length = 45)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "town", nullable = true, length = 45)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Basic
    @Column(name = "street", nullable = true, length = 200)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "streetNumber", nullable = true, length = 45)
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 400)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "committee", nullable = true, length = 45)
    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    @Basic
    @Column(name = "businessHours", nullable = true, length = 100)
    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    @Basic
    @Column(name = "contacter", nullable = true, length = 45)
    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    @Basic
    @Column(name = "avatar", nullable = true, length = 400)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String contacterPhoto) {
        this.avatar = contacterPhoto;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "fax", nullable = true, length = 20)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 2)
    public String getStatus() {
        return status;
    }

    public void setStatus(String statues) {
        this.status = statues;
    }

    @Basic
    @Column(name = "creator", nullable = true, length = 20)
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "credate", nullable = true)
    public Timestamp getCredate() {
        return credate;
    }

    public void setCredate(Timestamp credate) {
        this.credate = credate;
    }

    @Basic
    @Column(name = "optuser", nullable = true, length = 20)
    public String getOptuser() {
        return optuser;
    }

    public void setOptuser(String optuser) {
        this.optuser = optuser;
    }

    @Basic
    @Column(name = "optdate", nullable = true)
    public Timestamp getOptdate() {
        return optdate;
    }

    public void setOptdate(Timestamp optdate) {
        this.optdate = optdate;
    }

    @Basic
    @Column(name = "cfmuser", nullable = true, length = 20)
    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
    }

    @Basic
    @Column(name = "cfmdate", nullable = true)
    public Timestamp getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Timestamp cfmdate) {
        this.cfmdate = cfmdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConvenientInformation that = (ConvenientInformation) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(fullname, that.fullname) && Objects.equals(locationPhoto, that.locationPhoto) && Objects.equals(lat, that.lat) && Objects.equals(lng, that.lng) && Objects.equals(category, that.category) && Objects.equals(province, that.province) && Objects.equals(city, that.city) && Objects.equals(district, that.district) && Objects.equals(town, that.town) && Objects.equals(street, that.street) && Objects.equals(streetNumber, that.streetNumber) && Objects.equals(address, that.address) && Objects.equals(committee, that.committee) && Objects.equals(businessHours, that.businessHours) && Objects.equals(contacter, that.contacter) && Objects.equals(avatar, that.avatar) && Objects.equals(tel, that.tel) && Objects.equals(fax, that.fax) && Objects.equals(status, that.status) && Objects.equals(creator, that.creator) && Objects.equals(credate, that.credate) && Objects.equals(optuser, that.optuser) && Objects.equals(optdate, that.optdate) && Objects.equals(cfmuser, that.cfmuser) && Objects.equals(cfmdate, that.cfmdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fullname, locationPhoto, lat, lng, category, province, city, district, town, street, streetNumber, address, committee, businessHours, contacter, avatar, tel, fax, status, creator, credate, optuser, optdate, cfmuser, cfmdate);
    }
}
