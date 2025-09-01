package javax.xml.bind;

import java.security.BasicPermission;
import java.security.Permission;
import java.security.PermissionCollection;

/**
 * @deprecated Use {@link jakarta.xml.bind.JAXBPermission} instead.
 * @apiNote This class cannot extend {@link jakarta.xml.bind.JAXBPermission} due to class hierarchy divergence.
 */
@Deprecated(since = "jakarta.xml.bind.JAXBPermission")
public class JAXBPermission extends BasicPermission implements JAXBShim {
    private static final long serialVersionUID = javax.shim.ShimSupport.getSerialVersionUID();

    private final jakarta.xml.bind.JAXBPermission target;

    //==================================================================================================================
    // Constructors
    //==================================================================================================================

    /**
     * @see jakarta.xml.bind.JAXBPermission#JAXBPermission(String)
     */
    public JAXBPermission(String name) {
        super(name);
        target = new jakarta.xml.bind.JAXBPermission(name);
    }

    //==================================================================================================================
    // Delegated Methods
    //==================================================================================================================

    @Override
    public boolean implies(Permission p) {
        return target.implies(p);
    }

    @Override
    public String getActions() {
        return target.getActions();
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        return target.newPermissionCollection();
    }

    @Override
    public void checkGuard(Object object) throws SecurityException {
        target.checkGuard(object);
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object obj) {
        return target.equals(obj);
    }

    @Override
    public int hashCode() {
        return target.hashCode();
    }

    @Override
    public String toString() {
        return target.toString();
    }

    //==================================================================================================================
    // Static Initialization
    //==================================================================================================================

    static {
        JAXBShim.initialize();
    }
}
