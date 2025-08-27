package javax.annotation;

/**
 * This interface contains {@link jakarta.annotation}-to-{@link javax.annotation} facades used for wrapping Jakarta
 *   Annotations objects into their Java Annotations counterparts.
 *
 * @deprecated Use {@link jakarta.annotation} instead.
 */
@Deprecated(since = "jakarta.annotation")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Annotations
    //==================================================================================================================

    final class DataSourceDefinition extends AnnotationShim.Facade.Annotation<jakarta.annotation.sql.DataSourceDefinition> implements javax.annotation.sql.DataSourceDefinition, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        DataSourceDefinition(jakarta.annotation.sql.DataSourceDefinition target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String className() {
            return target.className();
        }

        @Override
        public String description() {
            return target.description();
        }

        @Override
        public String url() {
            return target.url();
        }

        @Override
        public String user() {
            return target.user();
        }

        @Override
        public String password() {
            return target.password();
        }

        @Override
        public String databaseName() {
            return target.databaseName();
        }

        @Override
        public int portNumber() {
            return target.portNumber();
        }

        @Override
        public String serverName() {
            return target.serverName();
        }

        @Override
        public int isolationLevel() {
            return target.isolationLevel();
        }

        @Override
        public boolean transactional() {
            return target.transactional();
        }

        @Override
        public int initialPoolSize() {
            return target.initialPoolSize();
        }

        @Override
        public int maxPoolSize() {
            return target.maxPoolSize();
        }

        @Override
        public int minPoolSize() {
            return target.minPoolSize();
        }

        @Override
        public int maxIdleTime() {
            return target.maxIdleTime();
        }

        @Override
        public int maxStatements() {
            return target.maxStatements();
        }

        @Override
        public String[] properties() {
            return target.properties();
        }

        @Override
        public int loginTimeout() {
            return target.loginTimeout();
        }
    }

    final class DataSourceDefinitions extends AnnotationShim.Facade.Annotation<jakarta.annotation.sql.DataSourceDefinitions> implements javax.annotation.sql.DataSourceDefinitions, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        DataSourceDefinitions(jakarta.annotation.sql.DataSourceDefinitions target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.annotation.sql.DataSourceDefinition[] value() {
            return AnnotationShim
                .of(target.value())
                .toArray(javax.annotation.sql.DataSourceDefinition[]::new);
        }
    }

    final class DeclareRoles extends AnnotationShim.Facade.Annotation<jakarta.annotation.security.DeclareRoles> implements javax.annotation.security.DeclareRoles, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        DeclareRoles(jakarta.annotation.security.DeclareRoles target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String[] value() {
            return target.value();
        }
    }

    final class DenyAll extends AnnotationShim.Facade.Annotation<jakarta.annotation.security.DenyAll> implements javax.annotation.security.DenyAll, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        DenyAll(jakarta.annotation.security.DenyAll target) {
            super(target);
        }
    }

    final class ManagedBean extends AnnotationShim.Facade.Annotation<jakarta.annotation.ManagedBean> implements javax.annotation.ManagedBean, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ManagedBean(jakarta.annotation.ManagedBean target) {
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

    final class PermitAll extends AnnotationShim.Facade.Annotation<jakarta.annotation.security.PermitAll> implements javax.annotation.security.PermitAll, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PermitAll(jakarta.annotation.security.PermitAll target) {
            super(target);
        }
    }

    final class PostConstruct extends AnnotationShim.Facade.Annotation<jakarta.annotation.PostConstruct> implements javax.annotation.PostConstruct, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PostConstruct(jakarta.annotation.PostConstruct target) {
            super(target);
        }
    }

    final class PreDestroy extends AnnotationShim.Facade.Annotation<jakarta.annotation.PreDestroy> implements javax.annotation.PreDestroy, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        PreDestroy(jakarta.annotation.PreDestroy target) {
            super(target);
        }
    }

    final class Priority extends AnnotationShim.Facade.Annotation<jakarta.annotation.Priority> implements javax.annotation.Priority, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Priority(jakarta.annotation.Priority target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public int value() {
            return target.value();
        }
    }

    final class Resource extends AnnotationShim.Facade.Annotation<jakarta.annotation.Resource> implements javax.annotation.Resource, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Resource(jakarta.annotation.Resource target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String name() {
            return target.name();
        }

        @Override
        public String lookup() {
            return target.lookup();
        }

        @Override
        public Class<?> type() {
            return target.type();
        }

        @Override
        public AuthenticationType authenticationType() {
            return AnnotationShim.of(target.authenticationType());
        }

        @Override
        public boolean shareable() {
            return target.shareable();
        }

        @Override
        public String mappedName() {
            return target.mappedName();
        }

        @Override
        public String description() {
            return target.description();
        }
    }

    final class Resources extends AnnotationShim.Facade.Annotation<jakarta.annotation.Resources> implements javax.annotation.Resources, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Resources(jakarta.annotation.Resources target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.annotation.Resource[] value() {
            return AnnotationShim
                .of(target.value())
                .toArray(javax.annotation.Resource[]::new);
        }
    }

    final class RolesAllowed extends AnnotationShim.Facade.Annotation<jakarta.annotation.security.RolesAllowed> implements javax.annotation.security.RolesAllowed, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        RolesAllowed(jakarta.annotation.security.RolesAllowed target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String[] value() {
            return target.value();
        }
    }

    final class RunAs extends AnnotationShim.Facade.Annotation<jakarta.annotation.security.RunAs> implements javax.annotation.security.RunAs, AnnotationShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        RunAs(jakarta.annotation.security.RunAs target) {
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
}
