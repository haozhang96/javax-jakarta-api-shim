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
     * @deprecated Use {@link jakarta.jws.soap.SOAPBinding.Style} instead.
     */
    @Deprecated(since = "jakarta.jws.soap.SOAPBinding.Style")
    enum Style implements JWSShim.Enum<jakarta.jws.soap.SOAPBinding.Style> { DOCUMENT, RPC }

    /**
     * @see jakarta.jws.soap.SOAPBinding#style()
     */
    Style style() default Style.DOCUMENT;

    /**
     * @deprecated Use {@link jakarta.jws.soap.SOAPBinding.Use} instead.
     */
    @Deprecated(since = "jakarta.jws.soap.SOAPBinding.Use")
    enum Use implements JWSShim.Enum<jakarta.jws.soap.SOAPBinding.Use> { LITERAL, ENCODED }

    /**
     * @see jakarta.jws.soap.SOAPBinding#use()
     */
    Use use() default Use.LITERAL;

    /**
     * @deprecated Use {@link jakarta.jws.soap.SOAPBinding.ParameterStyle} instead.
     */
    @Deprecated(since = "jakarta.jws.soap.SOAPBinding.ParameterStyle")
    enum ParameterStyle implements JWSShim.Enum<jakarta.jws.soap.SOAPBinding.ParameterStyle> { BARE, WRAPPED }

    /**
     * @see jakarta.jws.soap.SOAPBinding#parameterStyle()
     */
    ParameterStyle parameterStyle() default ParameterStyle.WRAPPED;
}
