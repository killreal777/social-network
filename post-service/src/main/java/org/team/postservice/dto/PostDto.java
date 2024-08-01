package org.team.postservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class PostDto {
    private int id;

    private int ownerId;

    private String textContent;
}
