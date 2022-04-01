package org.tartea.convert;

import org.mapstruct.Named;
import org.tartea.entity.SchoolType;

import java.util.Objects;

@Named("TypeConversionWorker")
public class TypeConversionWorker {

    @Named("convertToInteger")
    public SchoolType convertToInteger(String str) {
       if(Objects.isNull(str)){
           return null;
       }
        return new SchoolType(str);
    }
}
