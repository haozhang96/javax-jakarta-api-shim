package javax.xml.bind;

/**
 * @deprecated Use {@link jakarta.xml.bind.UnmarshallerHandler} instead.
 */
@Deprecated(since = "jakarta.xml.bind.UnmarshallerHandler")
public interface UnmarshallerHandler extends jakarta.xml.bind.UnmarshallerHandler, JAXBShim {
    //==================================================================================================================
    // UnmarshallerHandler Implementation Methods
    //==================================================================================================================

    @Override
    Object getResult() throws JAXBException, IllegalStateException;
}
