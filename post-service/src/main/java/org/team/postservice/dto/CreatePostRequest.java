package org.team.postservice.dto;

import lombok.Data;

@Data
public class CreatePostRequest {
    private int ownerId;

    private String textContent;
}
