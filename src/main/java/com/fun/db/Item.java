package com.fun.db;

import javax.persistence.*;
import java.util.List;

/**
 * Created by pstanaringa on 13.07.2017.
 */
@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<ItemTag> itemTagList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ItemTag> getItemTagList() {
        return itemTagList;
    }

    public void setItemTagList(List<ItemTag> itemTagList) {
        this.itemTagList = itemTagList;
    }
}
