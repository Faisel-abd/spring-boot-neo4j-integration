package com.trainig.neo4jboot.integration.common;

public final class  Constants {

    private Constants(){
    }

    public static final String ERROR_DATA_ACCESS_GET="Error occured on {} while getting {}.";
    public static final String ERROR_DATA_ACCESS_SAVE="Error occured on {} while saving {}.";
    public static final String ERROR_DATA_ACCESS_UPDATE="Error occured on {} while updating {}.";
    public static final String DATA_VALIDATION_NOT_NULL="Field '{name}' is required, please provide a value.";
    public static final String DATA_VALIDATION_SIZE_MIN_MAX="Field '{name}'length must be between {min} and {max} characters.";
    public static  final String ERROR_GLOBAL_MESSAGE="Some unidentified error happened, please contact your admin.";
}
