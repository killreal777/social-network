package org.team.postservice.dto;

import lombok.Data;

@Data
public class CreatePostRequestDto {
    private int ownerId;

    private String textContent;
}
