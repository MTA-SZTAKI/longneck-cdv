package hu.sztaki.ilab.longneck.process.constraint;

public class CvdLogic {
    private int[] applyTo;
    private int[] coeffs;
    private int mod;

    private void init(String applyToStr, String coeffStr, String modStr) {
        mod = Integer.parseInt(modStr);
        applyTo = new int[applyToStr.length()];
        for (int i = 0; i < applyToStr.length(); ++i) {
            applyTo[i] = (int) applyToStr.charAt(i) - 48;
        }
        String[] cf = coeffStr.split(";");
        coeffs = new int[cf.length];
        for (int i = 0; i < cf.length; ++i) {
            coeffs[i] = Integer.parseInt(cf[i]);
        }
    }

    public boolean check(String applyToStr, String coeffStr, String modStr) {
        init(applyToStr, coeffStr, modStr);
        if (applyTo.length != coeffs.length)
            return false;
        int checkSum = 0;
        for (int i = 0; i < coeffs.length; ++i)
            checkSum += applyTo[i] * coeffs[i];
        checkSum %= mod;
        return (checkSum == 0) ? true : false;
    }
}
