package asiainfo.util;

import org.springframework.ui.ModelMap;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;

public class ValidatorUtil {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    public static  <T> ModelMap validate(T obj,ModelMap modelMap){
        if(obj == null) {
            modelMap.put("code",503);
            modelMap.put("msg","参数错误！");
            return modelMap;
        };
        Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);
        if(set != null && set.size() > 0){
            for(ConstraintViolation<T> cv :set){
                String message = cv.getMessage();
                modelMap.put("msg",message);
                modelMap.put("code",501);
                return modelMap;
            }
        }
        return null;
    }
    public static <T> Boolean isValidate(T obj){
        if(obj == null) return false;
        Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);
        if(set != null && set.size() > 0){
            return false;
        }
        return true;
    }

}
