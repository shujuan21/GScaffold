package com.guany.myscaffold.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * enum注解处理逻辑
 *
 * @Auther: guany
 * @Date: 2023/06/25
 */
public class EnumValidator implements ConstraintValidator<Enum, Object> {
    private List<String> values = new ArrayList();

    public EnumValidator() {
    }

    public void initialize(Enum constraintAnnotation) {
        this.values = Arrays.asList(constraintAnnotation.value());
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return value != null ? this.values.contains(value.toString()) : true;
    }
}
