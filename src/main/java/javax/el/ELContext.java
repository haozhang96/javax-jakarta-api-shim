package javax.el;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @deprecated Use {@link jakarta.el.ELContext} instead.
 */
@Deprecated(since = "jakarta.el.ELContext")
public abstract class ELContext extends jakarta.el.ELContext implements ELShim {
    //==================================================================================================================
    // Shim Methods
    //==================================================================================================================

    /**
     * @see jakarta.el.ELContext#addEvaluationListener(jakarta.el.EvaluationListener)
     */
    public void addEvaluationListener(EvaluationListener listener) {
        super.addEvaluationListener(listener);
    }

    //==================================================================================================================
    // ELContext Implementation Methods
    //==================================================================================================================

    @Override
    public ImportHandler getImportHandler() {
        return ELShim.of(super.getImportHandler());
    }

    @Override
    public void addEvaluationListener(jakarta.el.EvaluationListener listener) {
        addEvaluationListener(ELShim.of(listener));
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List getEvaluationListeners() {
        return ELShim
            .<javax.el.EvaluationListener>of(super.getEvaluationListeners())
            .collect(Collectors.toList());
    }

    @Override
    public abstract ELResolver getELResolver();

    @Override
    public abstract FunctionMapper getFunctionMapper();

    @Override
    public abstract VariableMapper getVariableMapper();

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        ELShim.initialize();
    }
}
