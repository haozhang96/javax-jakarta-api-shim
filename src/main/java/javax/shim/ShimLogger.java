package javax.shim;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @deprecated This class should only be used internally by the {@code javax-jakarta-api-shim} library.
 */
@Deprecated(since = "javax-jakarta-api-shim")
public interface ShimLogger {
    Consumer<Object> DEBUG = System.err::println;
    Consumer<Object> INFO = System.out::println;
    BiConsumer<Object, Throwable> ERROR =
        (message, cause) -> {
            System.err.println(message);
            Optional.ofNullable(cause).ifPresent(Throwable::printStackTrace);
        };
}
