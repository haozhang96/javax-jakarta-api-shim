package javax.inject;

/**
 * This interface contains {@link jakarta.inject}-to-{@link javax.inject} facades used for wrapping Jakarta Dependency
 *   Injection objects into their Java Dependency Injection counterparts.
 *
 * @deprecated Use {@link jakarta.inject} instead.
 */
@Deprecated(since = "jakarta.inject")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Annotations
    //==================================================================================================================

    final class Inject extends InjectShim.Facade.Annotation<jakarta.inject.Inject> implements javax.inject.Inject, InjectShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Inject(jakarta.inject.Inject target) {
            super(target);
        }
    }

    final class Named extends InjectShim.Facade.Annotation<jakarta.inject.Named> implements javax.inject.Named, InjectShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Named(jakarta.inject.Named target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String value() {
            return target.value();
        }
    }

    final class Qualifier extends InjectShim.Facade.Annotation<jakarta.inject.Qualifier> implements javax.inject.Qualifier, InjectShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Qualifier(jakarta.inject.Qualifier target) {
            super(target);
        }
    }

    final class Scope extends InjectShim.Facade.Annotation<jakarta.inject.Scope> implements javax.inject.Scope, InjectShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Scope(jakarta.inject.Scope target) {
            super(target);
        }
    }

    final class Singleton extends InjectShim.Facade.Annotation<jakarta.inject.Singleton> implements javax.inject.Singleton, InjectShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Singleton(jakarta.inject.Singleton target) {
            super(target);
        }
    }

    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class Provider<T> extends InjectShim.Facade<jakarta.inject.Provider<T>> implements javax.inject.Provider<T> {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Provider(jakarta.inject.Provider<T> target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public T get() {
            return target.get();
        }
    }
}
