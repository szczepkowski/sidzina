package pl.goreit.sidzina.domain;

public class DomainException extends Exception {

    public DomainException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
    }
}
