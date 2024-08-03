package org.team.postservice.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class ImageValidator implements ConstraintValidator<ValidImage, MultipartFile> {
    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        return file == null || file.isEmpty() || isJpeg(file);
    }

    private boolean isJpeg(MultipartFile file) {
        return "image/jpeg".equals(file.getContentType());
    }
}
