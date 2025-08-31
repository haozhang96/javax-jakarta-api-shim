package javax.el;

import java.lang.invoke.MethodHandles;

/**
 * @deprecated Use {@link jakarta.el.ELProcessor} instead.
 */
@Deprecated(since = "jakarta.el.ELProcessor")
public class ELProcessor extends jakarta.el.ELProcessor implements ELShim {
    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    public ELProcessor() {
        try {
            final var lookup = MethodHandles.privateLookupIn(jakarta.el.ELProcessor.class, MethodHandles.lookup());
            final var manager = lookup.findVarHandle(getClass(), "elManager", jakarta.el.ELManager.class);
            final var factory = lookup.findVarHandle(getClass(), "factory", jakarta.el.ExpressionFactory.class);
            manager.set(this, ELShim.<ELManager>of(manager.get(this)));
            factory.set(this, ELShim.<ExpressionFactory>of(factory.get(this)));
        } catch (Exception exception) {
            throw new IllegalStateException("Failed to shim private members", exception);
        }
    }

    //==================================================================================================================
    // ELProcessor Implementation Methods
    //==================================================================================================================

    @Override
    public ELManager getELManager() {
        return ELShim.of(super.getELManager());
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
