package javax.el;

import javax.shim.ShimSupport;
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
        ShimSupport.reflect(MethodHandles.lookup(), ShimSupport.toJakarta(), (lookup, clazz) -> {
            final var manager = lookup.findVarHandle(clazz, "elManager", jakarta.el.ELManager.class);
            final var factory = lookup.findVarHandle(clazz, "factory", jakarta.el.ExpressionFactory.class);
            manager.set(this, ELShim.<ELManager>of(manager.get(this)));
            factory.set(this, ELShim.<ExpressionFactory>of(factory.get(this)));
            return null;
        });
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
