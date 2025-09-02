package javax.annotation;

import java.lang.annotation.*;

/**
 * @deprecated Use {@link jakarta.annotation.Resource} instead.
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Resources.class)
@Deprecated(since = "jakarta.annotation.Resource")
public @interface Resource {
    /**
     * @see jakarta.annotation.Resource#name()
     */
    String name() default "";

    /**
     * @see jakarta.annotation.Resource#lookup()
     */
    String lookup() default "";

    /**
     * @see jakarta.annotation.Resource#type()
     */
    Class<?> type() default Object.class;

    /**
     * @see jakarta.annotation.Resource#authenticationType()
     */
    AuthenticationType authenticationType() default AuthenticationType.CONTAINER;

    /**
     * @see jakarta.annotation.Resource#shareable()
     */
    boolean shareable() default true;

    /**
     * @see jakarta.annotation.Resource#mappedName()
     */
    String mappedName() default "";

    /**
     * @see jakarta.annotation.Resource#description()
     */
    String description() default "";

    //==================================================================================================================
    // Enumerations
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.annotation.Resource.AuthenticationType} instead.
     */
    @Deprecated(since = "jakarta.annotation.Resource.AuthenticationType")
    enum AuthenticationType implements AnnotationShim.Enum<jakarta.annotation.Resource.AuthenticationType> {
        /**
         * @see jakarta.annotation.Resource.AuthenticationType#CONTAINER
         */
        CONTAINER,

        /**
         * @see jakarta.annotation.Resource.AuthenticationType#APPLICATION
         */
        APPLICATION;

        //==============================================================================================================
        // Static Initialization
        //==============================================================================================================

        static {
            AnnotationShim.initialize();
        }
    }
}
