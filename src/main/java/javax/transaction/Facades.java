package javax.transaction;

import javax.transaction.xa.XAResource;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * This interface contains {@link jakarta.transaction}-to-{@link javax.transaction} facades used for wrapping Jakarta
 *   Transactions objects into their Java Transactions counterparts.
 *
 * @deprecated Use {@link jakarta.transaction} instead.
 */
@Deprecated(since = "jakarta.transaction")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Annotations
    //==================================================================================================================

    final class Transactional extends TransactionShim.Facade.Annotation<jakarta.transaction.Transactional> implements javax.transaction.Transactional, TransactionShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Transactional(jakarta.transaction.Transactional target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public TxType value() {
            return TransactionShim.of(target.value());
        }

        @Override
        public Class<?>[] rollbackOn() {
            return target.rollbackOn();
        }

        @Override
        public Class<?>[] dontRollbackOn() {
            return target.dontRollbackOn();
        }
    }

    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class HeuristicCommitException extends javax.transaction.HeuristicCommitException {
        private static final long serialVersionUID = -3977609782149921760L; // Use the ID from jakarta.transaction.

        private final jakarta.transaction.HeuristicCommitException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HeuristicCommitException(jakarta.transaction.HeuristicCommitException target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class HeuristicMixedException extends javax.transaction.HeuristicMixedException {
        private static final long serialVersionUID = 2345014349685956666L; // Use the ID from jakarta.transaction.

        private final jakarta.transaction.HeuristicMixedException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HeuristicMixedException(jakarta.transaction.HeuristicMixedException target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class HeuristicRollbackException extends javax.transaction.HeuristicRollbackException {
        private static final long serialVersionUID = -3483618944556408897L; // Use the ID from jakarta.transaction.

        private final jakarta.transaction.HeuristicRollbackException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HeuristicRollbackException(jakarta.transaction.HeuristicRollbackException target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class InvalidTransactionException extends javax.transaction.InvalidTransactionException {
        private static final long serialVersionUID = 3597320220337691496L; // Use the ID from jakarta.transaction.

        private final jakarta.transaction.InvalidTransactionException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        InvalidTransactionException(jakarta.transaction.InvalidTransactionException target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class NotSupportedException extends javax.transaction.NotSupportedException {
        private static final long serialVersionUID = 56870312332816390L; // Use the ID from jakarta.transaction.

        private final jakarta.transaction.NotSupportedException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        NotSupportedException(jakarta.transaction.NotSupportedException target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class RollbackException extends javax.transaction.RollbackException {
        private static final long serialVersionUID = 4151607774785285395L; // Use the ID from jakarta.transaction.

        private final jakarta.transaction.RollbackException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        RollbackException(jakarta.transaction.RollbackException target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class Status extends TransactionShim.Facade<jakarta.transaction.Status> implements javax.transaction.Status {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Status(jakarta.transaction.Status target) {
            super(target);
        }
    }

    final class Synchronization extends TransactionShim.Facade<jakarta.transaction.Synchronization> implements javax.transaction.Synchronization {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Synchronization(jakarta.transaction.Synchronization target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void beforeCompletion() {
            target.beforeCompletion();
        }

        @Override
        public void afterCompletion(int status) {
            target.afterCompletion(status);
        }
    }

    final class SystemException extends javax.transaction.SystemException {
        private static final long serialVersionUID = 839699079412719325L; // Use the ID from jakarta.transaction.

        private final jakarta.transaction.SystemException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        SystemException(jakarta.transaction.SystemException target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class Transaction extends TransactionShim.Facade<jakarta.transaction.Transaction> implements javax.transaction.Transaction {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Transaction(jakarta.transaction.Transaction target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void registerSynchronization(
            javax.transaction.Synchronization synchronization
        ) throws javax.transaction.RollbackException, javax.transaction.SystemException {
            try {
                target.registerSynchronization(synchronization);
            } catch (jakarta.transaction.RollbackException exception) {
                throw TransactionShim.<javax.transaction.RollbackException>of(exception);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void registerSynchronization(
            jakarta.transaction.Synchronization synchronization
        ) throws javax.transaction.RollbackException, javax.transaction.SystemException {
            try {
                target.registerSynchronization(synchronization);
            } catch (jakarta.transaction.RollbackException exception) {
                throw TransactionShim.<javax.transaction.RollbackException>of(exception);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void commit() throws javax.transaction.RollbackException, javax.transaction.HeuristicMixedException, javax.transaction.HeuristicRollbackException, javax.transaction.SystemException {
            try {
                target.commit();
            } catch (jakarta.transaction.RollbackException exception) {
                throw TransactionShim.<javax.transaction.RollbackException>of(exception);
            } catch (jakarta.transaction.HeuristicMixedException exception) {
                throw TransactionShim.<javax.transaction.HeuristicMixedException>of(exception);
            } catch (jakarta.transaction.HeuristicRollbackException exception) {
                throw TransactionShim.<javax.transaction.HeuristicRollbackException>of(exception);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public boolean delistResource(XAResource resource, int flag) throws javax.transaction.SystemException {
            try {
                return target.delistResource(resource, flag);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public boolean enlistResource(
            XAResource resource
        ) throws javax.transaction.RollbackException, javax.transaction.SystemException {
            try {
                return target.enlistResource(resource);
            } catch (jakarta.transaction.RollbackException exception) {
                throw TransactionShim.<javax.transaction.RollbackException>of(exception);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public int getStatus() throws javax.transaction.SystemException {
            try {
                return target.getStatus();
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void rollback() throws javax.transaction.SystemException {
            try {
                target.rollback();
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void setRollbackOnly() throws javax.transaction.SystemException {
            try {
                target.setRollbackOnly();
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }
    }

    final class TransactionalException extends javax.transaction.TransactionalException {
        private static final long serialVersionUID = -8196645329560986417L; // Use the ID from jakarta.transaction.

        private final jakarta.transaction.TransactionalException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        TransactionalException(jakarta.transaction.TransactionalException target) {
            super(target.getMessage(), target.getCause());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class TransactionManager extends TransactionShim.Facade<jakarta.transaction.TransactionManager> implements javax.transaction.TransactionManager {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        TransactionManager(jakarta.transaction.TransactionManager target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void resume(
            javax.transaction.Transaction transaction
        ) throws javax.transaction.InvalidTransactionException, javax.transaction.SystemException {
            try {
                target.resume(transaction);
            } catch (jakarta.transaction.InvalidTransactionException exception) {
                throw TransactionShim.<javax.transaction.InvalidTransactionException>of(exception);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void resume(
            jakarta.transaction.Transaction transaction
        ) throws javax.transaction.InvalidTransactionException, javax.transaction.SystemException {
            try {
                target.resume(transaction);
            } catch (jakarta.transaction.InvalidTransactionException exception) {
                throw TransactionShim.<javax.transaction.InvalidTransactionException>of(exception);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void begin() throws javax.transaction.NotSupportedException, javax.transaction.SystemException {
            try {
                target.begin();
            } catch (jakarta.transaction.NotSupportedException exception) {
                throw TransactionShim.<javax.transaction.NotSupportedException>of(exception);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void commit() throws javax.transaction.RollbackException, javax.transaction.HeuristicMixedException, javax.transaction.HeuristicRollbackException, javax.transaction.SystemException {
            try {
                target.commit();
            } catch (jakarta.transaction.RollbackException exception) {
                throw TransactionShim.<javax.transaction.RollbackException>of(exception);
            } catch (jakarta.transaction.HeuristicMixedException exception) {
                throw TransactionShim.<javax.transaction.HeuristicMixedException>of(exception);
            } catch (jakarta.transaction.HeuristicRollbackException exception) {
                throw TransactionShim.<javax.transaction.HeuristicRollbackException>of(exception);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public int getStatus() throws javax.transaction.SystemException {
            try {
                return target.getStatus();
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public javax.transaction.Transaction getTransaction() throws javax.transaction.SystemException {
            try {
                return TransactionShim.of(target.getTransaction());
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void rollback() throws javax.transaction.SystemException {
            try {
                target.rollback();
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void setRollbackOnly() throws javax.transaction.SystemException {
            try {
                target.setRollbackOnly();
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void setTransactionTimeout(int seconds) throws javax.transaction.SystemException {
            try {
                target.setTransactionTimeout(seconds);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public javax.transaction.Transaction suspend() throws javax.transaction.SystemException {
            try {
                return TransactionShim.of(target.suspend());
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }
    }

    final class TransactionRequiredException extends javax.transaction.TransactionRequiredException {
        private static final long serialVersionUID = -1898806419937446439L; // Use the ID from jakarta.transaction.

        private final jakarta.transaction.TransactionRequiredException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        TransactionRequiredException(jakarta.transaction.TransactionRequiredException target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class TransactionRolledbackException extends javax.transaction.TransactionRolledbackException {
        private static final long serialVersionUID = -3142798139623020577L; // Use the ID from jakarta.transaction.

        private final jakarta.transaction.TransactionRolledbackException target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        TransactionRolledbackException(jakarta.transaction.TransactionRolledbackException target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String getMessage() {
            return target.getMessage();
        }

        @Override
        public String getLocalizedMessage() {
            return target.getLocalizedMessage();
        }

        @Override
        public Throwable getCause() {
            return target.getCause();
        }

        @Override
        public Throwable initCause(Throwable cause) {
            return target.initCause(cause);
        }

        @Override
        public String toString() {
            return target.toString();
        }

        @Override
        public void printStackTrace() {
            target.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintStream s) {
            target.printStackTrace(s);
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            target.printStackTrace(s);
        }

        @Override
        public Throwable fillInStackTrace() {
            try {
                return super.fillInStackTrace();
            } finally {
                if (target != null) {
                    target.fillInStackTrace();
                }
            }
        }

        @Override
        public StackTraceElement[] getStackTrace() {
            return target.getStackTrace();
        }

        @Override
        public void setStackTrace(StackTraceElement[] stackTrace) {
            target.setStackTrace(stackTrace);
        }
    }

    final class TransactionSynchronizationRegistry extends TransactionShim.Facade<jakarta.transaction.TransactionSynchronizationRegistry> implements javax.transaction.TransactionSynchronizationRegistry {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        TransactionSynchronizationRegistry(jakarta.transaction.TransactionSynchronizationRegistry target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getTransactionKey() {
            return target.getTransactionKey();
        }

        @Override
        public void putResource(Object key, Object value) {
            target.putResource(key, value);
        }

        @Override
        public Object getResource(Object key) {
            return target.getResource(key);
        }

        @Override
        public void registerInterposedSynchronization(javax.transaction.Synchronization synchronization) {
            target.registerInterposedSynchronization(synchronization);
        }

        @Override
        public void registerInterposedSynchronization(jakarta.transaction.Synchronization synchronization) {
            target.registerInterposedSynchronization(synchronization);
        }

        @Override
        public int getTransactionStatus() {
            return target.getTransactionStatus();
        }

        @Override
        public void setRollbackOnly() {
            target.setRollbackOnly();
        }

        @Override
        public boolean getRollbackOnly() {
            return target.getRollbackOnly();
        }
    }

    final class UserTransaction extends TransactionShim.Facade<jakarta.transaction.UserTransaction> implements javax.transaction.UserTransaction {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        UserTransaction(jakarta.transaction.UserTransaction target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public void begin() throws javax.transaction.NotSupportedException, javax.transaction.SystemException {
            try {
                target.begin();
            } catch (jakarta.transaction.NotSupportedException exception) {
                throw TransactionShim.<javax.transaction.NotSupportedException>of(exception);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void commit() throws javax.transaction.RollbackException, javax.transaction.HeuristicMixedException, javax.transaction.HeuristicRollbackException, javax.transaction.SystemException {
            try {
                target.commit();
            } catch (jakarta.transaction.RollbackException exception) {
                throw TransactionShim.<javax.transaction.RollbackException>of(exception);
            } catch (jakarta.transaction.HeuristicMixedException exception) {
                throw TransactionShim.<javax.transaction.HeuristicMixedException>of(exception);
            } catch (jakarta.transaction.HeuristicRollbackException exception) {
                throw TransactionShim.<javax.transaction.HeuristicRollbackException>of(exception);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void rollback() throws javax.transaction.SystemException {
            try {
                target.rollback();
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void setRollbackOnly() throws javax.transaction.SystemException {
            try {
                target.setRollbackOnly();
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public int getStatus() throws javax.transaction.SystemException {
            try {
                return target.getStatus();
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }

        @Override
        public void setTransactionTimeout(int seconds) throws javax.transaction.SystemException {
            try {
                target.setTransactionTimeout(seconds);
            } catch (jakarta.transaction.SystemException exception) {
                throw TransactionShim.<javax.transaction.SystemException>of(exception);
            }
        }
    }
}
