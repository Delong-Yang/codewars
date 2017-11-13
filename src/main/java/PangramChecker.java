// https://www.codewars.com/kata/545cedaa9943f7fe7b000048
public class PangramChecker {
    public boolean check(String sentence){
        return 26 == sentence.toLowerCase().chars().mapToObj(ch -> (char) ch).filter(Character::isLowerCase).distinct().count();
    }
}