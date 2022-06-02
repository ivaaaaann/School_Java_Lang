package kr.hs.dgsw.java.dept1.FTP.common;

import java.io.File;

public class CommonFuntions {

    public boolean fileExistCheck (String address) {
        return  new File(address).exists();
    }

    public boolean fileResponseExistCheck (String res) {
        return res.equals("exist");
    }
}
