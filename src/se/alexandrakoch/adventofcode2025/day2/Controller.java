package se.alexandrakoch.adventofcode2025.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class Controller {
    private class IDRange {
        public long start;
        public long end;
        public IDRange(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    private LongStream concatenatedStream;
    AtomicLong accumulatedIDs = new AtomicLong();
    public Controller(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String inputString = reader.readLine();
        String[] rangesString = inputString.split(",");
        for (String range : rangesString) {
            String[] rangeStringArr = range.split("-");
            IDRange idRange = new IDRange(Long.parseLong(rangeStringArr[0]), Long.parseLong(rangeStringArr[1]));
            if (concatenatedStream == null) {
                concatenatedStream = LongStream.rangeClosed(idRange.start, idRange.end);
            } else {
                concatenatedStream = LongStream.concat(concatenatedStream, LongStream.rangeClosed(idRange.start, idRange.end));
            }
        }
    }
    public long getAnswer() {
        concatenatedStream.parallel().forEach(number ->
                {
                    String numberString = Long.toString(number);
                    int numberLength = numberString.length();
                    String lower = numberString.substring(0, (numberLength / 2));
                    String upper = numberString.substring(numberLength / 2);
                    if(lower.equals(upper)) {
                        accumulatedIDs.addAndGet(number);
                    }
                }
                );
        return accumulatedIDs.get();
    }


}
