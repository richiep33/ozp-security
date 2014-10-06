package ozp.security

/**
 * Created by rpuderbaugh on 5/14/14.
 */
class ServiceException extends Exception {
    ServiceException(String message) {
        super(message)
    }

    ServiceException(Throwable cause) {
        super(cause)
    }

    ServiceException(String message, Throwable cause) {
        super(message, cause)
    }
}
