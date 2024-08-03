package org.team.postservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {
    private int id;

    private int ownerId;

    private String text;

    private boolean hasImage;

    /**
     * Getter for hasImage field with fixed method name (hasImage instead of Lombok's isHasImage).
     * Uses Lombok's getter: returns isHasImage result.
     */
    public boolean hasImage() {
        return this.isHasImage();
    }
}
