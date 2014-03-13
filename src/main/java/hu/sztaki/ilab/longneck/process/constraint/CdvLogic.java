package hu.sztaki.ilab.longneck.process.constraint;

public class CdvLogic {
    private int[] coeffs;
    private int mod;
    private String cfStr;

    public void setMod(int mod) {
        this.mod = mod;
    }

    public void setCoeffs(String cfStr) {
        this.cfStr = cfStr;
        String[] strCoeffs = cfStr.split(" ");
        this.coeffs = new int[strCoeffs.length];
        for (int i = 0; i < strCoeffs.length; ++i) {
            this.coeffs[i] = Integer.parseInt(strCoeffs[i]);
        }
    }

    public boolean check(String value) {
        if (value == null)
            return false;
        if (value.length() != coeffs.length)
            return false;
        int checkSum = 0;
        for (int i = 0; i < coeffs.length; ++i) {
            int digit = (int) value.charAt(i) - 48;
            if (digit < 0 || digit > 9)
                return false;
            checkSum += digit * coeffs[i];
        }
        checkSum %= mod;
        return (checkSum == 0) ? true : false;
    }

    @Override
    public String toString() {
        return "coeffs=" + cfStr + " mod=" + mod;
    }
}
