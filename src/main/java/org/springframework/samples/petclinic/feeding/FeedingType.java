package org.springframework.samples.petclinic.feeding;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "feeding_type")
public class FeedingType extends NamedEntity{
    //Integer id;
    
    @NotNull
    @Size(min = 30, max = 50)
    String name;
    
    @NotNull
    String description;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    PetType petType;
}
