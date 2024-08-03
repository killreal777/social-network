package org.team.postservice.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreatePostRequest {
    private int ownerId;

    @Size(max = 30, message = "Text content less than or equals to 30 characters")
    private String text;
}
