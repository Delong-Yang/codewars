
// https://www.codewars.com/kata/5531abe4855bcc8d1f00004c

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BowlingScore {
    public static int bowling_score(String frames) {
        String[] frameArray = frames.split(" ");
        IntStream.range(0, 9)
                .filter(i -> frameArray[i].matches("X|[0-9]/"))
                .forEach(i -> frameArray[i] = Arrays.stream(frameArray, i, 10)
                        .collect(Collectors.joining())
                        .substring(0, 3));

        return Stream.of(frameArray).map(s->s.replaceAll("[0-9]/", "X")).mapToInt(BowlingScore::score).sum();
    }

    public static int score(String frame) {
        return frame.chars().map(ch -> ch == 'X' ? 10 : Character.digit(ch, 10)).sum();
    }

//    public static int bowling_score(String frames) {
//        int score = 0;
//        String[] frameArray = frames.split(" ");
//
//        for (int i = 0; i < frameArray.length; i++) {
//            score += scoreOfFrame(frameArray[i]);
//            if (isStrike(frameArray[i])) {
//                char firstBall, secondBall;
//                if (i+1<frameArray.length) {
//                    firstBall = frameArray[i+1].charAt(0);
//                } else {
//                    firstBall = frameArray[frameArray.length-1].charAt(1);
//                }
//
//                if ('X'==firstBall) {
//                    if (i+2<frameArray.length) {
//                        secondBall = frameArray[i+2].charAt(0);
//                    } else {
//                        secondBall = frameArray[frameArray.length-1].charAt(2);
//                    }
//                } else {
//                    if (i+1<frameArray.length) {
//                        secondBall = frameArray[i+1].charAt(1);
//                    } else {
//                        secondBall = frameArray[frameArray.length-1].charAt(2);
//                    }
//                }
//
//                if (secondBall == '/') {
//                    score+=10;
//                } else {
//                    score += scoreOfBall(firstBall);
//                    score += scoreOfBall(secondBall);
//                }
//            } else if (isSpare(frameArray[i])) {
//                char firstBall;
//                if (i+1<frameArray.length) {
//                    firstBall = frameArray[i+1].charAt(0);
//                } else if(i==frameArray.length-1){
//                    firstBall = frameArray[frameArray.length-1].charAt(2);
//                } else {
//                    firstBall = frameArray[frameArray.length-1].charAt(0);
//                }
//                score += scoreOfBall(firstBall);
//            }
//        }
//
//        return score;
//    }
//
//    private static int scoreOfBall(char ball) {
//        return 'X' == ball ? 10 : Character.digit(ball, 10);
//    }
//
//    private static int scoreOfFrame(String frame) {
//        return isStrike(frame) || isSpare(frame) ? 10 : scoreOfMiss(frame);
//    }
//
//    private static int scoreOfMiss(String s) {
//        return Character.digit(s.charAt(0), 10) + Character.digit(s.charAt(1), 10);
//    }
//
//    public static boolean isStrike(String frame) {
//        return frame.charAt(0) == 'X';
//    }
//
//    public static boolean isSpare(String frame) {
//        return frame.charAt(1) == '/';
//    }

    public static void main(String[] args) {
        System.out.println(bowling_score("5/ 4/ 3/ 2/ 1/ 0/ X 9/ 4/ 8/8"));
    }
}
