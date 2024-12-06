package lk.ijse.crop_monitoring.entity.impl;

import jakarta.persistence.*;
import main.java.lk.ijse.crop_monitoring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "crop")
public class Crop implements SuperEntity {
    @Id
    private String cropCode;
    private String commonName;
    private String scientificName;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    private String category;
    private String season;
    @ManyToOne
    @JoinColumn(name = "fieldCode", nullable = false)
    private lk.ijse.crop_monitoring.entity.impl.Field field;
    @OneToMany(mappedBy="crop")
    private List <lk.ijse.crop_monitoring.entity.impl.Log> logs;
}