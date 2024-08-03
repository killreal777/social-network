package org.team.postservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue
    private int id;

    private int ownerId;

    private String textContent;

    private boolean hasImage;

    /**
     * Getter for hasImage field with fixed method name (hasImage instead of Lombok's isHasImage).
     * Uses Lombok's getter: returns isHasImage result.
     */
    public boolean hasImage() {
        return this.isHasImage();
    }
}
