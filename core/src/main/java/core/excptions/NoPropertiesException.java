package core.excptions;

public class NoPropertiesException extends  ReflectiveOperationException {
    public NoPropertiesException(){}
    public NoPropertiesException(String message){super(message);}
}
