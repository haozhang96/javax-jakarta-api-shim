package javax.transaction;

import javax.shim.Shim;
import javax.shim.ShimSupport;
import java.lang.annotation.Annotation;
import java.util.stream.Stream;

/**
 * @deprecated Use {@link jakarta.transaction} instead.
 */
@Deprecated(since = "jakarta.transaction")
public interface TransactionShim extends Shim {
    //==================================================================================================================
    // Helper Methods
    //==================================================================================================================

    static void initialize() {
        Shim.initialize();
    }

    //==================================================================================================================
    // Factory Methods
    //==================================================================================================================

    static <S extends TransactionShim> S of(Object object) {
        if (object == null || object instanceof TransactionShim) {
            return S(object);
        } else if (object instanceof Exception) {
            return S(of((Exception) object));
        } else if (object instanceof jakarta.transaction.Status) {
            return S(new Facades.Status(S(object)));
        } else if (object instanceof jakarta.transaction.Synchronization) {
            return S(new Facades.Synchronization(S(object)));
        } else if (object instanceof jakarta.transaction.Transaction) {
            return S(new Facades.Transaction(S(object)));
        } else if (object instanceof jakarta.transaction.TransactionManager) {
            return S(new Facades.TransactionManager(S(object)));
        } else if (object instanceof jakarta.transaction.TransactionSynchronizationRegistry) {
            return S(new Facades.TransactionSynchronizationRegistry(S(object)));
        } else if (object instanceof jakarta.transaction.UserTransaction) {
            return S(new Facades.UserTransaction(S(object)));
        }

        return ShimSupport.throwUnknownType(null, object);
    }

    static <S extends Exception & TransactionShim> S of(Exception exception) {
        if (exception == null || exception instanceof TransactionShim) {
            return S(exception);
        } else if (exception instanceof jakarta.transaction.HeuristicCommitException) {
            return S(new Facades.HeuristicCommitException(S(exception)));
        } else if (exception instanceof jakarta.transaction.HeuristicMixedException) {
            return S(new Facades.HeuristicMixedException(S(exception)));
        } else if (exception instanceof jakarta.transaction.HeuristicRollbackException) {
            return S(new Facades.HeuristicRollbackException(S(exception)));
        } else if (exception instanceof jakarta.transaction.InvalidTransactionException) {
            return S(new Facades.InvalidTransactionException(S(exception)));
        } else if (exception instanceof jakarta.transaction.NotSupportedException) {
            return S(new Facades.NotSupportedException(S(exception)));
        } else if (exception instanceof jakarta.transaction.RollbackException) {
            return S(new Facades.RollbackException(S(exception)));
        } else if (exception instanceof jakarta.transaction.SystemException) {
            return S(new Facades.SystemException(S(exception)));
        } else if (exception instanceof jakarta.transaction.TransactionalException) {
            return S(new Facades.TransactionalException(S(exception)));
        } else if (exception instanceof jakarta.transaction.TransactionRequiredException) {
            return S(new Facades.TransactionRequiredException(S(exception)));
        } else if (exception instanceof jakarta.transaction.TransactionRolledbackException) {
            return S(new Facades.TransactionRolledbackException(S(exception)));
        }

        return ShimSupport.throwUnknownType(null, exception);
    }

    static <S extends TransactionShim> Stream<S> of(Object[] objects) {
        return Shim.of(TransactionShim::of, objects);
    }

    static <S extends TransactionShim> Stream<S> of(Iterable<?> objects) {
        return Shim.of(TransactionShim::of, objects);
    }

    static <S extends TransactionShim & Annotation> Stream<S> of(Annotation[] annotations) {
        return Shim.of(TransactionShim::of, annotations);
    }

    static <S extends TransactionShim> Class<? extends S> of(Class<S> shimType, Class<?> interfaceType) {
        return Shim.of(shimType, interfaceType);
    }

    //==================================================================================================================
    // Enum-specific Implementation
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.transaction} instead.
     */
    @Deprecated(since = "jakarta.transaction")
    interface Enum<E extends java.lang.Enum<E>> extends TransactionShim, Shim.Enum<E> { }

    //==================================================================================================================
    // Private Helper Methods
    //==================================================================================================================

    @SuppressWarnings("unchecked")
    private static <S> S S(Object object) {
        return (S) object;
    }
}
