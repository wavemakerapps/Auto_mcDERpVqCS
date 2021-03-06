/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.auto_mcderpvqcs.db_levelcheck;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Child1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`CHILD1`")
public class Child1 implements Serializable {

    private Integer childId1;
    private String childCol1;
    private String childCol2;
    private String childCol3;
    private Parent1 parent1;

    @Id
    @Column(name = "`CHILD_ID1`", nullable = false, scale = 0, precision = 10)
    public Integer getChildId1() {
        return this.childId1;
    }

    public void setChildId1(Integer childId1) {
        this.childId1 = childId1;
    }

    @Column(name = "`CHILD_COL1`", nullable = true, length = 255)
    public String getChildCol1() {
        return this.childCol1;
    }

    public void setChildCol1(String childCol1) {
        this.childCol1 = childCol1;
    }

    @Column(name = "`CHILD_COL2`", nullable = true, length = 255)
    public String getChildCol2() {
        return this.childCol2;
    }

    public void setChildCol2(String childCol2) {
        this.childCol2 = childCol2;
    }

    @Column(name = "`CHILD_COL3`", nullable = true, length = 255)
    public String getChildCol3() {
        return this.childCol3;
    }

    public void setChildCol3(String childCol3) {
        this.childCol3 = childCol3;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`CHILD_ID1`", referencedColumnName = "`PARENT_ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_CHILD1_TO_PARENT1_CHIPBDwQ`"))
    @Fetch(FetchMode.JOIN)
    public Parent1 getParent1() {
        return this.parent1;
    }

    public void setParent1(Parent1 parent1) {
        if(parent1 != null) {
            this.childId1 = parent1.getParentId();
        }

        this.parent1 = parent1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Child1)) return false;
        final Child1 child1 = (Child1) o;
        return Objects.equals(getChildId1(), child1.getChildId1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChildId1());
    }
}