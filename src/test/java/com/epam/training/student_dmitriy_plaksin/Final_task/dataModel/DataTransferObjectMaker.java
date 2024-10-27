package com.epam.training.student_dmitriy_plaksin.Final_task.dataModel;

import com.epam.training.student_dmitriy_plaksin.Final_task.util.ResourceBundleReader;

public class DataTransferObjectMaker {

    public static final String TESTDATA_LOGIN_USERNAME = "username";
    public static final String TESTDATA_LOGIN_PASSWORD = "password";
    public static final String TESTDATA_LOGIN_TITLE = "title";
    public static final String TESTDATA_LOGIN_ERROR = "error";


    public static DataTransferObject_model getTestData(int number) {
        DataTransferObject_model dataTransferObjectModel = new DataTransferObject_model();

        if  ( (1<=number) && (number<=3)  ){
            dataTransferObjectModel.setLogin_username(ResourceBundleReader.readFromRecourceBundle(TESTDATA_LOGIN_USERNAME + number));
            dataTransferObjectModel.setLogin_password(ResourceBundleReader.readFromRecourceBundle(TESTDATA_LOGIN_PASSWORD + number));
            dataTransferObjectModel.setMessage_text(ResourceBundleReader.readFromRecourceBundle(TESTDATA_LOGIN_ERROR + number));
            dataTransferObjectModel.setPage_title(ResourceBundleReader.readFromRecourceBundle(TESTDATA_LOGIN_TITLE + number));
        } else throw new IllegalArgumentException();

        return dataTransferObjectModel;
    }


}