package com.fairyonline.course.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.teacher.entity.Teacher;

@Entity
@Table(name="course")
public class Course {
	private int ID;
	private String cName;
	private int price;
	private Category categoryID;
	private Date UPTime;
	private Teacher tId;
	private String cImg;
	private String cIntroduction;
	private List<Chapters> chaptersList = new ArrayList<Chapters>();
//<<<<<<< HEAD
//	private Set<Cart> cartSet = new HashSet<Cart>();
//	private Set<Orders> orderSet = new HashSet<Orders>();
//=======
	private Set<Cart> cartSet = new HashSet<Cart>();
	private Set<Orders> orderSet = new HashSet<Orders>();
	private Set<FollowCourse> fcSet = new HashSet<FollowCourse>();
//>>>>>>> refs/remotes/origin/sy
	
	public Course() {
		
	}
	public Course(String Name,int Price,Date UPTime) {
		this.cName=Name;
		this.price=Price;
		this.UPTime = UPTime;
	
		
	}
	public Course(String Name, int price, java.sql.Date now, int tID) {
		// TODO Auto-generated constructor stub
	}
//	@Id
//	@GeneratedValue(generator="my_gen")
//    @GenericGenerator(name="my_gen", strategy="increment")
//	@Column(name="id")
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	@Column(name="id")
	public int getId() {
		return ID;
	}
	public void setId(int iD) {
		this.ID = iD;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getCName() {
		return cName;
	}
	public void setCName(String cName) {
		this.cName = cName;
	}
//	public String getcName() {
//		return cName;
//	}
//	public void setcName(String cName) {
//		this.cName = cName;
//	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@ManyToOne
	@JoinColumn(name="categoryID")
	public  Category getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}
	public Date getUPTime() {
		return UPTime;
	}
	public void setUPTime(Date uPTime) {
		UPTime = uPTime;
	}
	@ManyToOne
	@JoinColumn(name="tId")
	public Teacher gettId() {
		return tId;
	}
	public void settId(Teacher tId) {
		this.tId = tId;
	}
	public String getcImg() {
		return cImg;
	}
	public void setcImg(String cImg) {
		this.cImg = cImg;
	}
	public String getcIntroduction() {
		return cIntroduction;
	}
	public void setcIntroduction(String cIntroduction) {
		this.cIntroduction = cIntroduction;
	}
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)//��������EAGER
	@JoinColumn(name="CID")
//	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
//    @JoinColumn(name="CID")
	public List<Chapters> getChaptersList() {
		return chaptersList;
	}
	public void setChaptersList(List<Chapters> chaptersList) {
		this.chaptersList = chaptersList;
	}
	@OneToMany
	@JoinColumn(name="courseId")
	public Set<Cart> getCartSet() {
		return cartSet;
	}
	public void setCartSet(Set<Cart> cartSet) {
		this.cartSet = cartSet;
	}
	@ManyToMany
	@JoinTable(name="CARTLIST", 
	    joinColumns=@JoinColumn(name="OID"),
	    inverseJoinColumns=@JoinColumn(name="CID"))
	public Set<Orders> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Orders> orderSet) {
		this.orderSet = orderSet;
	}
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="fcid")
	public Set<FollowCourse> getFcSet() {
		return fcSet;
	}
	public void setFcSet(Set<FollowCourse> fcSet) {
		this.fcSet = fcSet;
	}
	@Override
	public String toString() {
		return "Course [ID=" + ID + ", Name=" + cName + ", Price=" + price + ", categoryID=" + categoryID + ", UPTime="
				+ UPTime + ", tId=" + tId + ", chaptersList=" + chaptersList + "]";
	}
	

}
