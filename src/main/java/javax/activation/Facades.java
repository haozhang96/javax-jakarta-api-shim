package javax.activation;

import javax.shim.ShimSupport;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * This interface contains {@link jakarta.activation}-to-{@link javax.activation} facades used for wrapping Jakarta
 *   Activation objects into their Java Activation counterparts.
 *
 * @deprecated Use {@link jakarta.activation} instead.
 */
@Deprecated(since = "jakarta.activation")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Classes
    //==================================================================================================================

    final class ActivationDataFlavor extends javax.activation.ActivationDataFlavor {
        private final jakarta.activation.ActivationDataFlavor target;

        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        ActivationDataFlavor(jakarta.activation.ActivationDataFlavor target) {
            super(target.getRepresentationClass(), target.getMimeType(), target.getHumanPresentableName());
            this.target = target;
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Class<?> getRepresentationClass() {
            return target.getRepresentationClass();
        }

        @Override
        public String getMimeType() {
            return target.getMimeType();
        }

        @Override
        public String getHumanPresentableName() {
            return target.getHumanPresentableName();
        }

        @Override
        public void setHumanPresentableName(String humanPresentableName) {
            target.setHumanPresentableName(humanPresentableName);
        }

        @Override
        public boolean isMimeTypeEqual(String mimeType) {
            return target.isMimeTypeEqual(mimeType);
        }

        @Override
        public boolean equals(String mimeType) {
            return target.equals(mimeType);
        }

        @Override
        public boolean equals(javax.activation.ActivationDataFlavor dataFlavor) {
            return target.equals(dataFlavor);
        }

        @Override
        public boolean equals(jakarta.activation.ActivationDataFlavor dataFlavor) {
            return target.equals(dataFlavor);
        }

        @Override
        public boolean equals(Object other) {
            return target.equals(other);
        }

        @Override
        public int hashCode() {
            return target.hashCode();
        }

        @Override
        protected String normalizeMimeType(String mimeType) {
            return ShimSupport.Reflect.call(MethodHandles.lookup(), ShimSupport.Class.toJakarta(), (lookup, clazz) ->
                (String)
                    lookup
                       .bind(target, "normalizeMimeType", MethodType.methodType(String.class, String.class))
                       .invokeExact(mimeType)
            );
        }

        @Override
        protected String normalizeMimeTypeParameter(String parameterName, String parameterValue) {
            return ShimSupport.Reflect.call(MethodHandles.lookup(), ShimSupport.Class.toJakarta(), (lookup, clazz) ->
                (String)
                    lookup
                        .bind(target, "normalizeMimeTypeParameter", MethodType.methodType(String.class, String.class, String.class))
                        .invokeExact(parameterName, parameterValue)
            );
        }
    }

    final class MailcapRegistryProvider extends ActivationShim.Facade<jakarta.activation.spi.MailcapRegistryProvider> implements javax.activation.spi.MailcapRegistryProvider {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MailcapRegistryProvider(jakarta.activation.spi.MailcapRegistryProvider target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.activation.MailcapRegistry getByFileName(String fileName) throws IOException {
            return ActivationShim.of(target.getByFileName(fileName));
        }

        @Override
        public javax.activation.MailcapRegistry getByInputStream(InputStream inputStream) throws IOException {
            return ActivationShim.of(target.getByInputStream(inputStream));
        }

        @Override
        public javax.activation.MailcapRegistry getInMemory() {
            return ActivationShim.of(target.getInMemory());
        }
    }

    final class MimeTypeRegistryProvider extends ActivationShim.Facade<jakarta.activation.spi.MimeTypeRegistryProvider> implements javax.activation.spi.MimeTypeRegistryProvider {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        MimeTypeRegistryProvider(jakarta.activation.spi.MimeTypeRegistryProvider target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public javax.activation.MimeTypeRegistry getByFileName(String fileName) throws IOException {
            return ActivationShim.of(target.getByFileName(fileName));
        }

        @Override
        public javax.activation.MimeTypeRegistry getByInputStream(InputStream inputStream) throws IOException {
            return ActivationShim.of(target.getByInputStream(inputStream));
        }

        @Override
        public javax.activation.MimeTypeRegistry getInMemory() {
            return ActivationShim.of(target.getInMemory());
        }
    }
}
