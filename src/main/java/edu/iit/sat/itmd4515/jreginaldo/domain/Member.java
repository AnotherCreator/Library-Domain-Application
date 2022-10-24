package edu.iit.sat.itmd4515.jreginaldo.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m")
public class Member {

    /*
            ========== CONSTRUCTORS ==========
     */
    public Member() {

    }

    public Member(String firstName, String lastName, String phone, String address, Integer memberType,
                  Integer isExpired) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.memberType = memberType;
        this.isExpired = isExpired;
    }

    /*
            ========== RELATIONSHIPS ==========
     */
    /*
        A singular member can have many checkouts at once
        1:N relationship (Bi-directional)
        Member(Owned) <--> Checkout(Owner)
     */
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Checkout> checkoutSet = new ArrayList<>();

    /*
        Not every member will be an employee but every employee with automatically be a member
        1:1 Relationship (Uni-Directional)
        Member --> Employee
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

    /*
        ========== OBJECT RELATED VARIABLES ==========
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(max = 15)
    @Column(name = "phone")
    private String phone;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "address")
    private String address;

    // 0 -- Local Resident Card Holder
    // 1 -- Non Local Resident Card Holder
    // 2 -- Staff Card Holder
    @Min(0)
    @Max(2)
    @Column(name = "member_type")
    private Integer memberType;

    // 0 -- Not expired
    // 1 -- Expired
    @Min(0)
    @Max(1)
    @Column(name = "expired")
    private Integer isExpired;

    /*
        ========== GETTER / SETTER ==========
     */
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Integer isExpired) {
        this.isExpired = isExpired;
    }

    public List<Checkout> getCheckoutSet() {
        return checkoutSet;
    }

    public void setCheckoutSet(List<Checkout> checkoutSet) {
        this.checkoutSet = checkoutSet;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /*
                    ========== @OVERRIDES ==========
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        if ((this.ID == null || member.ID == null)) {
            return false;
        }
        return ID.equals(member.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Member{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", memberType=" + memberType +
                ", isExpired=" + isExpired +
                '}';
    }
}
