package numbers;

import reader.FileReader;

import java.util.ArrayList;

/**
 * class for translation of numbers into a string
 */
public class NumbersToString extends AbstractNumbers {
    private static final int GROUP_SIZE = 3;
    private FileReader fileReader = new FileReader();
    private ArrayList<String> units = new ArrayList<>();
    private ArrayList<String> ten = new ArrayList<>();
    private ArrayList<String> decades = new ArrayList<>();
    private ArrayList<String> hundreds = new ArrayList<>();
    private ArrayList<String> zeros = new ArrayList<>();

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
                    units.add(s1.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s1.length()) {
            units.add(s1.substring(i));
        }

        for (int j = 0; j < s2.length(); j++) {
            if (s2.charAt(j) == ',') {
                if (j > i) {
                    ten.add(s2.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s2.length()) {
            ten.add(s2.substring(i));
        }

        for (int j = 0; j < s3.length(); j++) {
            if (s3.charAt(j) == ',') {
                if (j > i) {
                    decades.add(s3.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s3.length()) {
            decades.add(s3.substring(i));
        }
        for (int j = 0; j < s4.length(); j++) {
            if (s4.charAt(j) == ',') {
                if (j > i) {
                    hundreds.add(s4.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s4.length()) {
            hundreds.add(s4.substring(i));
        }
        for (int j = 0; j < s5.length(); j++) {
            if (s5.charAt(j) == ',') {
                if (j > i) {
                    zeros.add(s5.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s5.length()) {
            zeros.add(s5.substring(i));
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
            return units.get(0);
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
                String hundreds = this.hundreds.get(h);
                sb.append(hundreds);
                sb.append(" ");
            }
            if (t == 0) {
                //
                if (u > 0) {
                    String txt = units.get(u);
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
                sb.append(ten.get(u));
                sb.append(" ");
            } else if (t > 1) {
                sb.append(decades.get(t));
                if (u > 0) {
                    sb.append(" ");
                    String units = this.units.get(u);
                    if (k == 1) {
                        switch (u) {
                            case 1:
                                units = "одна";
                                break;
                            case 2:
                                units = "две";
                                break;
                            default:
                        }
                    }
                    sb.append(units);
                }
                sb.append(" ");
            }
            if (k > 0 && (h + t + u > 0)) {
                if (k == 1) {
                    sb.append(thousands(t, u));
                } else {
                    sb.append(zeros(t, u, k));
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    private String zeros(int t, int u, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(zeros.get(k));

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

    private String thousands(int t, int u) {
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
