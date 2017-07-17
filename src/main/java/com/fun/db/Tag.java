package com.fun.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by pstanaringa on 13.07.2017.
 */
@Entity
@Table(name = "TAG")
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemTag> itemTagList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemTag> getItemTagList() {
        return itemTagList;
    }

    public void setItemTagList(List<ItemTag> itemTagList) {
        this.itemTagList = itemTagList;
    }
}
