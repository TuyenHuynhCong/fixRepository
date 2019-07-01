package com.vnext.interjava.userproduct.idea.entity;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "nameproduct")
    public String nameproduct;
    @Column(name = "nhacungcap")
    public String nhacungcap;
    @Column(name = "soluong")
    public int soluong;
    @Column(name = "gia")
    public int gia;



    public Product() {
    }

    public Product(String nameproduct, String nhacungcap, int soluong , int gia) {
        this.nameproduct = nameproduct;
        this.nhacungcap = nhacungcap;
        this.soluong = soluong;
        this.gia = gia;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public String getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(String nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }


}
