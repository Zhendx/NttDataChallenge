package com.nttdata.bank.account.error;

public class ConstantError {
    public static final ErrorApp errorApp = new ErrorApp("CI000","Account does not exist or account type is incorrect");
    public static final ErrorApp errorApp1 = new ErrorApp("CI001","Balance not available");
}
