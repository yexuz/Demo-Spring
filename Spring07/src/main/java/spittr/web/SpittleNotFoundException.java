package spittr.web;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {

}
