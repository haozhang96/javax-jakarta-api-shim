package javax.jws;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.jws.WebParam} instead.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.jws.WebParam")
public @interface WebParam {
    /**
     * @see jakarta.jws.WebParam#name()
     */
    String name() default "";

    /**
     * @see jakarta.jws.WebParam#partName()
     */
    String partName() default "";

    /**
     * @see jakarta.jws.WebParam#targetNamespace()
     */
    String targetNamespace() default "";

    /**
     * @see jakarta.jws.WebParam#mode()
     */
    Mode mode() default Mode.IN;

    /**
     * @see jakarta.jws.WebParam#header()
     */
    boolean header() default false;

    //==================================================================================================================
    // Enumerations
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.jws.WebParam.Mode} instead.
     */
    @Deprecated(since = "jakarta.jws.WebParam.Mode")
    enum Mode implements JWSShim.Enum<jakarta.jws.WebParam.Mode> {
        /**
         * @see jakarta.jws.WebParam.Mode#IN
         */
        IN,

        /**
         * @see jakarta.jws.WebParam.Mode#OUT
         */
        OUT,

        /**
         * @see jakarta.jws.WebParam.Mode#INOUT
         */
        INOUT;

        //==============================================================================================================
        // Static Initialization
        //==============================================================================================================

        static {
            JWSShim.initialize();
        }
    }
}
