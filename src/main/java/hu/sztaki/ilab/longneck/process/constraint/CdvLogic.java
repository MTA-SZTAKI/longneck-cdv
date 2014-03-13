package hu.sztaki.ilab.longneck.process.constraint;

import java.util.List;

public class CdvLogic {
    private int[] coeffs;
    private int mod;

    public void setMod(int mod) {
        this.mod = mod;
    }

    public void setCoeffs(List<Integer> coeffs) {
        this.coeffs = new int[coeffs.size()];
        for (int i = 0; i < coeffs.size(); ++i) {
            this.coeffs[i] = coeffs.get(i);
        }
    }

    public boolean check(String value) {
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
}
