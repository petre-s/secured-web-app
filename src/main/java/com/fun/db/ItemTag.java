package com.fun.db;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by pstanaringa on 13.07.2017.
 */
@Entity
@Table(name = "ITEM_TAG")
public class ItemTag {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TAG_ID", nullable = false)
    private Tag tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
