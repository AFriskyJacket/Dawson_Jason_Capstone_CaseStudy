package com.Catpics.Dawson_Jason_Capstone_CaseStudy.catEnjoyer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "image_meta_data")
public class ImageMetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "image_meta_data_tags",
            joinColumns = @JoinColumn(name = "imageMetaData_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id"))
    private Collection<Tag> tags = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cat_enjoyer_id", nullable = false)
    private CatEnjoyer catEnjoyer;

    public ImageMetaData(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImageMetaData that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "ImageMetaData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}