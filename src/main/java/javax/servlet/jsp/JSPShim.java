package javax.servlet.jsp;

import javax.servlet.ServletShim;
import javax.shim.Shim;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.servlet.jsp} instead.
 */
@Deprecated(since = "jakarta.servlet.jsp")
public interface JSPShim extends ServletShim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        ServletShim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends JSPShim> S of(Object object) {
        if (object == null || object instanceof JSPShim) {
            return S(object);
        } else if (object instanceof jakarta.servlet.jsp.JspException) {
            return S(of((jakarta.servlet.jsp.JspException) object));
        } else if (object instanceof jakarta.servlet.jsp.ErrorData) {
            return S(new Facades.ErrorData(S(object)));
        }

        throw new UnsupportedOperationException("Unknown type: " + object.getClass().getName());
    }

    static <S extends JspException> S of(jakarta.servlet.jsp.JspException exception) {
        if (exception == null || exception instanceof JSPShim) {
            return S(exception);
        }

        return S(new Facades.JspException(exception));
    }

    static <S extends JSPShim> Stream<S> of(Object... objects) {
        return Shim.of(JSPShim::of, objects);
    }

    static <S extends JSPShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(JSPShim::of, objects);
    }

    static <S extends JSPShim & Annotation> Stream<S> of(Annotation... annotations) {
        return Shim.of(JSPShim::of, annotations);
    }

    static <S extends JSPShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
