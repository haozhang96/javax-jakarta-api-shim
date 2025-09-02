package javax.transaction;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * @deprecated Use {@link jakarta.transaction.Transactional} instead.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@InterceptorBinding
@Deprecated(since = "jakarta.transaction.Transactional")
public @interface Transactional {
    /**
     * @see jakarta.transaction.Transactional#value()
     */
    TxType value() default TxType.REQUIRED;

    /**
     * @see jakarta.transaction.Transactional#rollbackOn()
     */
    Class<?>[] rollbackOn() default {};

    /**
     * @see jakarta.transaction.Transactional#dontRollbackOn()
     */
    Class<?>[] dontRollbackOn() default {};

    //==================================================================================================================
    // Enumerations
    //==================================================================================================================

    /**
     * @deprecated Use {@link jakarta.transaction.Transactional.TxType} instead.
     */
    @Deprecated(since = "jakarta.transaction.Transactional.TxType")
    enum TxType implements TransactionShim.Enum<jakarta.transaction.Transactional.TxType> {
        /**
         * @see jakarta.transaction.Transactional.TxType#REQUIRED
         */
        REQUIRED,

        /**
         * @see jakarta.transaction.Transactional.TxType#REQUIRES_NEW
         */
        REQUIRES_NEW,

        /**
         * @see jakarta.transaction.Transactional.TxType#MANDATORY
         */
        MANDATORY,

        /**
         * @see jakarta.transaction.Transactional.TxType#SUPPORTS
         */
        SUPPORTS,

        /**
         * @see jakarta.transaction.Transactional.TxType#NOT_SUPPORTED
         */
        NOT_SUPPORTED,

        /**
         * @see jakarta.transaction.Transactional.TxType#NEVER
         */
        NEVER;

        //==============================================================================================================
        // Static Initialization
        //==============================================================================================================

        static {
            TransactionShim.initialize();
        }
    }
}
