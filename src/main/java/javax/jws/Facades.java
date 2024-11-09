package javax.jws;

import javax.Shim;

/**
 * This interface contains {@link jakarta.jws}-to-{@link javax.jws} facades used for wrapping Jakarta Web Services
 *   Metadata objects into their Java Web Services Metadata counterparts.
 *
 * @deprecated Use {@link jakarta.jws} instead.
 */
@Deprecated(since = "jakarta.jws")
@SuppressWarnings("all")
interface Facades {
    //==================================================================================================================
    // Annotations
    //==================================================================================================================

    final class HandlerChain extends Shim.Facade.Annotation<jakarta.jws.HandlerChain> implements javax.jws.HandlerChain, JWSShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        HandlerChain(jakarta.jws.HandlerChain target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String file() {
            return target.file();
        }

        @Override
        public String name() {
            return target.name();
        }
    }

    final class InitParam extends Shim.Facade.Annotation<jakarta.jws.soap.InitParam> implements javax.jws.soap.InitParam, JWSShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        InitParam(jakarta.jws.soap.InitParam target) {
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
        public String value() {
            return target.value();
        }
    }

    final class Oneway extends Shim.Facade.Annotation<jakarta.jws.Oneway> implements javax.jws.Oneway, JWSShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        Oneway(jakarta.jws.Oneway target) {
            super(target);
        }
    }

    final class SOAPBinding extends Shim.Facade.Annotation<jakarta.jws.soap.SOAPBinding> implements javax.jws.soap.SOAPBinding, JWSShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        SOAPBinding(jakarta.jws.soap.SOAPBinding target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public Style style() {
            return JWSShim.of(target.style());
        }

        @Override
        public Use use() {
            return JWSShim.of(target.use());
        }

        @Override
        public ParameterStyle parameterStyle() {
            return JWSShim.of(target.parameterStyle());
        }
    }

    final class SOAPMessageHandler extends Shim.Facade.Annotation<jakarta.jws.soap.SOAPMessageHandler> implements javax.jws.soap.SOAPMessageHandler, JWSShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        SOAPMessageHandler(jakarta.jws.soap.SOAPMessageHandler target) {
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
        public javax.jws.soap.InitParam[] initParams() {
            return JWSShim
                .<javax.jws.soap.InitParam>of(target.initParams())
                .toArray(javax.jws.soap.InitParam[]::new);
        }

        @Override
        public String[] roles() {
            return target.roles();
        }

        @Override
        public String[] headers() {
            return target.headers();
        }
    }

    final class SOAPMessageHandlers extends Shim.Facade.Annotation<jakarta.jws.soap.SOAPMessageHandlers> implements javax.jws.soap.SOAPMessageHandlers, JWSShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        SOAPMessageHandlers(jakarta.jws.soap.SOAPMessageHandlers target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================


        @Override
        public javax.jws.soap.SOAPMessageHandler[] value() {
            return JWSShim
                .<javax.jws.soap.SOAPMessageHandler>of(target.value())
                .toArray(javax.jws.soap.SOAPMessageHandler[]::new);
        }
    }


    final class WebMethod extends Shim.Facade.Annotation<jakarta.jws.WebMethod> implements javax.jws.WebMethod, JWSShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WebMethod(jakarta.jws.WebMethod target) {
            super(target);
        }

        //==============================================================================================================
        // Delegated Methods
        //==============================================================================================================

        @Override
        public String operationName() {
            return target.operationName();
        }

        @Override
        public String action() {
            return target.action();
        }

        @Override
        public boolean exclude() {
            return target.exclude();
        }
    }

    final class WebParam extends Shim.Facade.Annotation<jakarta.jws.WebParam> implements javax.jws.WebParam, JWSShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WebParam(jakarta.jws.WebParam target) {
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
        public String partName() {
            return target.partName();
        }

        @Override
        public String targetNamespace() {
            return target.targetNamespace();
        }

        @Override
        public Mode mode() {
            return JWSShim.of(target.mode());
        }

        @Override
        public boolean header() {
            return target.header();
        }
    }

    final class WebResult extends Shim.Facade.Annotation<jakarta.jws.WebResult> implements javax.jws.WebResult, JWSShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WebResult(jakarta.jws.WebResult target) {
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
        public String partName() {
            return target.partName();
        }

        @Override
        public String targetNamespace() {
            return target.targetNamespace();
        }

        @Override
        public boolean header() {
            return target.header();
        }
    }

    final class WebService extends Shim.Facade.Annotation<jakarta.jws.WebService> implements javax.jws.WebService, JWSShim {
        //==============================================================================================================
        // Constructors
        //==============================================================================================================

        WebService(jakarta.jws.WebService target) {
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
        public String targetNamespace() {
            return target.targetNamespace();
        }

        @Override
        public String serviceName() {
            return target.serviceName();
        }

        @Override
        public String portName() {
            return target.portName();
        }

        @Override
        public String wsdlLocation() {
            return target.wsdlLocation();
        }

        @Override
        public String endpointInterface() {
            return target.endpointInterface();
        }
    }
}
