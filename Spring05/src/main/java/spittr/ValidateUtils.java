package spittr;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/**
 * 描述：参数校验
 *
 * @author Terry
 * @date 2018/4/24
 */
public class ValidateUtils {

    /**
     * 对javaBean进行校验
     *
     * @param t   校验对象
     * @param <T> 校验对象
     */
    public static <T> String validate(T t) {
        String errorMsg = null;
        ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = vFactory.getValidator();
        Set<ConstraintViolation<T>> set = validator.validate(t);
        if (set.size() > 0) {
            StringBuilder validateError = new StringBuilder();
            for (ConstraintViolation<T> val : set) {
                validateError.append(val.getMessage()).append(",");
            }
            errorMsg = validateError.toString();
        }
        return errorMsg;
    }


    /**
     * 对javaBean进行校验
     *
     * @param tList   校验对象
     * @param <T> 校验对象
     */
    public static <T> String validateList(List<T> tList) {
        String errorMsg = null;
        ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = vFactory.getValidator();
        StringBuilder validateError = new StringBuilder();
        for (T t : tList) {
            Set<ConstraintViolation<T>> set = validator.validate(t);
            if (set.size() > 0) {
                for (ConstraintViolation<T> val : set) {
                    validateError.append(val.getMessage()).append(",");
                }
                errorMsg = validateError.toString();
            }
        }

        return errorMsg;
    }

    /**
     * 分组校验
     *
     * @param t   校验对象
     * @param <T> 校验对象
     */
    public static <T> String validate(T t, Class groupName) {
        String errorMsg = null;
        ValidatorFactory vFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = vFactory.getValidator();
        Set<ConstraintViolation<T>> set = validator.validate(t, groupName);
        if (set.size() > 0) {
            StringBuilder validateError = new StringBuilder();
            for (ConstraintViolation<T> val : set) {
                validateError.append(val.getMessage()).append(",");
            }
            errorMsg = validateError.toString();
        }
        return errorMsg;
    }
}
