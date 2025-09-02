package javax.jws.soap;

import javax.jws.JWSShim;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @deprecated Use {@link jakarta.jws.soap.SOAPBinding} instead.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated(since = "jakarta.jws.soap.SOAPBinding")
public @interface SOAPBinding {
    /**
     * @see jakarta.jws.soap.SOAPBinding#style()
     */
    Style style() default Style.DOCUMENT;

    /**
     * @see jakarta.jws.soap.SOAPBinding#use()
     */
    Use use() default Use.LITERAL;

    /**
     * @see jakarta.jws.soap.SOAPBinding#parameterStyle()
     */
    ParameterStyle parameterStyle() default ParameterStyle.WRAPPED;

    //==================================================================================================================
    // Enumerations
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.jws.soap.SOAPBinding.Style} instead.
     */
    @Deprecated(since = "jakarta.jws.soap.SOAPBinding.Style")
    enum Style implements JWSShim.Enum<jakarta.jws.soap.SOAPBinding.Style> {
        /**
         * @see jakarta.jws.soap.SOAPBinding.Style#DOCUMENT
         */
        DOCUMENT,

        /**
         * @see jakarta.jws.soap.SOAPBinding.Style#RPC
         */
        RPC;

        //==============================================================================================================
        // Static Initialization
        //==============================================================================================================

        static {
            JWSShim.initialize();
        }
    }

    /**
     * @deprecated Use {@link jakarta.jws.soap.SOAPBinding.Use} instead.
     */
    @Deprecated(since = "jakarta.jws.soap.SOAPBinding.Use")
    enum Use implements JWSShim.Enum<jakarta.jws.soap.SOAPBinding.Use> {
        /**
         * @see jakarta.jws.soap.SOAPBinding.Use#LITERAL
         */
        LITERAL,

        /**
         * @see jakarta.jws.soap.SOAPBinding.Use#ENCODED
         */
        ENCODED;

        //==============================================================================================================
        // Static Initialization
        //==============================================================================================================

        static {
            JWSShim.initialize();
        }
    }

    /**
     * @deprecated Use {@link jakarta.jws.soap.SOAPBinding.ParameterStyle} instead.
     */
    @Deprecated(since = "jakarta.jws.soap.SOAPBinding.ParameterStyle")
    enum ParameterStyle implements JWSShim.Enum<jakarta.jws.soap.SOAPBinding.ParameterStyle> {
        /**
         * @see jakarta.jws.soap.SOAPBinding.ParameterStyle#BARE
         */
        BARE,

        /**
         * @see jakarta.jws.soap.SOAPBinding.ParameterStyle#WRAPPED
         */
        WRAPPED;

        //==============================================================================================================
        // Static Initialization
        //==============================================================================================================

        static {
            JWSShim.initialize();
        }
    }
}
