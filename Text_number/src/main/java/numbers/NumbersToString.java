package numbers;

import reader.FileReader;

import java.util.ArrayList;

/**
 * class for translation of numbers into a string
 */
public class NumbersToString extends AbstractNumbers {
    private static final int GROUP_SIZE = 3;
    private FileReader fileReader = new FileReader();
    private ArrayList<String> EDINICHI = new ArrayList<>();
    private ArrayList<String> DESYAT = new ArrayList<>();
    private ArrayList<String> DESYATKI = new ArrayList<>();
    private ArrayList<String> SOTNI = new ArrayList<>();
    private ArrayList<String> LIONS = new ArrayList<>();

    /**
     * set fields from txt file
     */
    private void setFields() { //TODO: "Delete copy-paste code!"
        String s1 = fileReader.read().get(0);
        String s2 = fileReader.read().get(1);
        String s3 = fileReader.read().get(2);
        String s4 = fileReader.read().get(3);
        String s5 = fileReader.read().get(4);
        int i = 0;
        for (int j = 0; j < s1.length(); j++) {
            if (s1.charAt(j) == ',') {
                if (j > i) {
                    EDINICHI.add(s1.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s1.length()) {
            EDINICHI.add(s1.substring(i));
        }

        for (int j = 0; j < s2.length(); j++) {
            if (s2.charAt(j) == ',') {
                if (j > i) {
                    DESYAT.add(s2.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s2.length()) {
            DESYAT.add(s2.substring(i));
        }

        for (int j = 0; j < s3.length(); j++) {
            if (s3.charAt(j) == ',') {
                if (j > i) {
                    DESYATKI.add(s3.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s3.length()) {
            DESYATKI.add(s3.substring(i));
        }
        for (int j = 0; j < s4.length(); j++) {
            if (s4.charAt(j) == ',') {
                if (j > i) {
                    SOTNI.add(s4.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s4.length()) {
            SOTNI.add(s4.substring(i));
        }
        for (int j = 0; j < s5.length(); j++) {
            if (s5.charAt(j) == ',') {
                if (j > i) {
                    LIONS.add(s5.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s5.length()) {
            LIONS.add(s5.substring(i));
        }
    }

    @Override
    public String format(Number number) {
        checkSupported(number);
        setFields();
        return formatImpl(number.toString());
    }


    private String formatImpl(String text) {
        if ("0".equals(text)) {
            return EDINICHI.get(0);
        }
        StringBuilder sb = new StringBuilder();
        if (text.startsWith("-")) {
            sb.append("минус ");
            text = text.substring(1);
        }
        byte n[][] = MakeGroups.groups(text, GROUP_SIZE);


        for (int i = 0; i < n.length; ++i) {
            int k = n.length - i - 1;

            int h = n[i][0];
            int t = n[i][1];
            int u = n[i][2];
            if (h == 0 && t == 0 && u == 0) {
                continue;
            }
            if (h > 0) {
                String sotni = SOTNI.get(h);
                sb.append(sotni);
                sb.append(" ");
            }
            if (t == 0) {
                //
                if (u > 0) {
                    String txt = EDINICHI.get(u);
                    if (k == 1) {
                        switch (u) {
                            case 1:
                                txt = "одна";
                                break;
                            case 2:
                                txt = "две";
                                break;
                        }
                    }
                    sb.append(txt);
                    sb.append(" ");
                }
                //
            } else if (t == 1) {
                sb.append(DESYAT.get(u));
                sb.append(" ");
            } else if (t > 1) {
                sb.append(DESYATKI.get(t));
                if (u > 0) {
                    sb.append(" ");
                    String ed = EDINICHI.get(u);
                    if (k == 1) {
                        switch (u) {
                            case 1:
                                ed = "одна";
                                break;
                            case 2:
                                ed = "две";
                                break;
                            default:
                        }
                    }
                    sb.append(ed);
                }
                sb.append(" ");
            }
            if (k > 0 && (h + t + u > 0)) {
                if (k == 1) {
                    sb.append(tisyachi(h, t, u));
                } else {
                    sb.append(lions(h, t, u, k));
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    private String lions(int h, int t, int u, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(LIONS.get(k));

        if (t == 0 || t > 1) {
            switch (u) {
                case 1:
                    break;

                case 2:
                case 3:
                case 4:
                    sb.append("а");
                    break;

                default:
                    sb.append("ов");
                    break;
            }
        } else {
            sb.append("ов");
        }
        return sb.toString();
    }

    private String tisyachi(int h, int t, int u) {
        String result = "тысяч";
        if (t == 0 || t > 1) {
            switch (u) {
                case 1:
                    result = "тысяча";
                    break;
                case 2:
                case 3:
                case 4:
                    result = "тысячи";
                    break;
            }
        }
        return result;
    }
}
