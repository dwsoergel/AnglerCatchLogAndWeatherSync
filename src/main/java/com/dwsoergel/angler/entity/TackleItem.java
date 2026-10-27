package com.dwsoergel.angler.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;
import java.util.Objects;

@Entity(name = "TackleItem")
@Table(name = "tackle_items")
public class TackleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "lure_type")
    private String lureType;

    @ManyToOne
    private User user;

    public TackleItem() {
    }

    public TackleItem(String itemName, String lureType, User user) {
        this.itemName = itemName;
        this.lureType = lureType;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getLureType() {
        return lureType;
    }

    public void setLureType(String lureType) {
        this.lureType = lureType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TackleItem tackleItem = (TackleItem) o;
        return Objects.equals(itemName, tackleItem.itemName) &&
                Objects.equals(lureType, tackleItem.lureType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, lureType);
    }
}
