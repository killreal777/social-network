package org.team.postservice.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.team.postservice.model.PostEntity;

public class PostValidator implements ConstraintValidator<ValidPost, PostEntity> {
    @Override
    public boolean isValid(PostEntity post, ConstraintValidatorContext context) {
        System.out.println("VALIDATION");
        System.out.println("HAS TEXT: " + hasText(post));
        System.out.println("HAS IMAGE: " + post.hasImage());
        return hasText(post) || post.hasImage();
    }

    private boolean hasText(PostEntity post) {
        return post.getText() != null && !post.getText().trim().isEmpty();
    }
}

