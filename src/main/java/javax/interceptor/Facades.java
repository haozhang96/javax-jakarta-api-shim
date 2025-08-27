package javax.interceptor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * This interface contains {@link jakarta.interceptor}-to-{@link javax.interceptor} facades used for wrapping Jakarta
 *   Interceptors objects into their Java Interceptors counterparts.
 *
 * @deprecated Use {@link jakarta.interceptor} instead.
 */
@Deprecated(since = "jakarta.interceptor")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Annotations
    //==================================================================================================================

    final class AroundConstruct extends InterceptorShim.Facade.Annotation<jakarta.interceptor.AroundConstruct> implements javax.interceptor.AroundConstruct, InterceptorShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        AroundConstruct(jakarta.interceptor.AroundConstruct target) {
            super(target);
        }
    }

    final class AroundInvoke extends InterceptorShim.Facade.Annotation<jakarta.interceptor.AroundInvoke> implements javax.interceptor.AroundInvoke, InterceptorShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        AroundInvoke(jakarta.interceptor.AroundInvoke target) {
            super(target);
        }
    }

    final class AroundTimeout extends InterceptorShim.Facade.Annotation<jakarta.interceptor.AroundTimeout> implements javax.interceptor.AroundTimeout, InterceptorShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        AroundTimeout(jakarta.interceptor.AroundTimeout target) {
            super(target);
        }
    }

    final class ExcludeClassInterceptors extends InterceptorShim.Facade.Annotation<jakarta.interceptor.ExcludeClassInterceptors> implements javax.interceptor.ExcludeClassInterceptors, InterceptorShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ExcludeClassInterceptors(jakarta.interceptor.ExcludeClassInterceptors target) {
            super(target);
        }
    }

    final class ExcludeDefaultInterceptors extends InterceptorShim.Facade.Annotation<jakarta.interceptor.ExcludeDefaultInterceptors> implements javax.interceptor.ExcludeDefaultInterceptors, InterceptorShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ExcludeDefaultInterceptors(jakarta.interceptor.ExcludeDefaultInterceptors target) {
            super(target);
        }
    }

    final class Interceptor extends InterceptorShim.Facade.Annotation<jakarta.interceptor.Interceptor> implements javax.interceptor.Interceptor, InterceptorShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Interceptor(jakarta.interceptor.Interceptor target) {
            super(target);
        }
    }

    final class InterceptorBinding extends InterceptorShim.Facade.Annotation<jakarta.interceptor.InterceptorBinding> implements javax.interceptor.InterceptorBinding, InterceptorShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        InterceptorBinding(jakarta.interceptor.InterceptorBinding target) {
            super(target);
        }
    }

    final class Interceptors extends InterceptorShim.Facade.Annotation<jakarta.interceptor.Interceptors> implements javax.interceptor.Interceptors, InterceptorShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Interceptors(jakarta.interceptor.Interceptors target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Class<?>[] value() {
            return target.value();
        }
    }

    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class Interceptor$Priority extends javax.interceptor.Interceptor.Priority {
        private final jakarta.interceptor.Interceptor.Priority target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Interceptor$Priority(jakarta.interceptor.Interceptor.Priority target) {
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public boolean equals(Object other) {
            return target.equals(other);
        }

        @Override
        public int hashCode() {
            return target.hashCode();
        }

        @Override
        public String toString() {
            return target.toString();
        }
    }

    final class InvocationContext extends InterceptorShim.Facade<jakarta.interceptor.InvocationContext> implements javax.interceptor.InvocationContext {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        InvocationContext(jakarta.interceptor.InvocationContext target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Object getTarget() {
            return target.getTarget();
        }

        @Override
        public Object getTimer() {
            return target.getTimer();
        }

        @Override
        public Method getMethod() {
            return target.getMethod();
        }

        @Override
        public Constructor<?> getConstructor() {
            return target.getConstructor();
        }

        @Override
        public Object[] getParameters() {
            return target.getParameters();
        }

        @Override
        public void setParameters(Object[] parameters) {
            target.setParameters(parameters);
        }

        @Override
        public Map<String, Object> getContextData() {
            return target.getContextData();
        }

        @Override
        public Object proceed() throws Exception {
            return target.proceed();
        }
    }
}
