package com.guany.myscaffold.common.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Auther: guany
 * @Date: 2023/06/25
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {EnumValidator.class}
)
public @interface Enum {
    String[] value();

    String message() default "只能是指定的值";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
