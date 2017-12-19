package numbers;

/**
 * class for divide number to groups,[1.0.3][2.0.1] (103201)
 */
class MakeGroups {

    static byte[][] groups(String txt, int groupSize) {

        int length = txt.length();
        int groupCount = length / groupSize;
        int remainder = length % groupSize;

        int j = 0, k = 0;
        if (remainder > 0) {
            groupCount++;
            k = groupSize - remainder;
        }
        byte nn[][] = new byte[groupCount][groupSize];
        for (int i = 0; i < txt.length(); ++i) {
            byte x = (byte) (txt.charAt(i) - '0');
            if (x < 0 || x > 9) {
                throw new IllegalArgumentException("Wrong string:" + txt);
            }
            nn[j][k] = x;
            if (k == groupSize - 1) {
                k = 0;
                j++;
            } else {
                k++;
            }
        }
        return nn;
    }
}
