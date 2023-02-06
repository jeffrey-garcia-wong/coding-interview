package io.jeffrey.fundingcircle;

/**
 * <h1>Run Length Encoding</h1>
 *
 * At FundingCircle we hold most of our data on Kafka topics (think of these
 * as big lists of messages). For performance reasons we try to keep each message
 * under a certain size (currently 1MB). However, recently we've added a new data
 * source that has a message size that breaks this limit. This means we need to
 * implement some form of data compression.<p/>
 *
 * After a bit of googling we've come across something we think might work:
 * Run length encoding. Your task is to implement the run-length encoding and
 * decoding functions defined below.<p/>
 *
 * <b>Some details about Run-length encoding:</b><br/>
 * Run-length encoding (RLE) is a simple form of data compression, where runs
 * (consecutive data elements) are replaced by just one data value and count.<p/>
 *
 * For example we can represent the original 53 characters with only 13.<br/>
 * <pre>
 * {@code
 * "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"  ->  "12WB12W3B24WB"
 * }
 * </pre>
 *
 * RLE allows the original data to be perfectly reconstructed from the compressed
 * data, which makes it a lossless data compression.<br/>
 * <pre>
 * {@code
 * "AABCCCDEEEE"  ->  "2AB3CD4E"  ->  "AABCCCDEEEE"
 * }
 * </pre>
 *
 * For simplicity, you can assume that the unencoded string will only contain the
 * letters A through Z (either lower or upper case) and whitespace. This way data
 * to be encoded will never contain any numbers and numbers inside data to be decoded
 * always represent the count for the following character.")<p/>
 **/
public class RunLengthCoding {

    public static String encode(String s) {
        if (s.length() <= 0) return "";

        StringBuilder output = new StringBuilder();
        char[] input = s.toCharArray();

        char prev = 0;
        int count = 0;
        for (int i=0; i<input.length; i++) {
            char c = input[i];
            if (i == 0) {
                prev = input[i];
                count += 1;
            } else {
                if (c == prev) {
                    count += 1;
                } else {
                    if (count <= 1)
                        output.append(prev);
                    else
                        output.append(count).append(prev);
                    count = 1;
                }
                prev = c;
            }

        }
        if (count <= 1)
            output.append(prev);
        else
            output.append(count).append(prev);

        return output.toString();
    }

    public static String decode(String string) {
        StringBuilder output = new StringBuilder();

        char[] input = string.toCharArray();
        StringBuilder count = new StringBuilder();
        for (char c : input) {
            int ascii = (int) c;
            if (ascii >= 48 && ascii <= 57) {
                count.append(ascii - 48);
            } else {
                if (count.toString().equals("")) {
                    output.append(c);
                } else {
                    int countInt = Integer.parseInt(count.toString());
                    for (int j = 0; j < countInt; j++) {
                        output.append(c);
                    }
                    count = new StringBuilder();
                }
            }
        }

        return output.toString();
    }

}
