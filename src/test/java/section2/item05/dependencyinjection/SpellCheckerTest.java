package section2.item05.dependencyinjection;

import section2.item05.DefaultDictionary;
import org.junit.jupiter.api.Test;
import section2.item05.dependencyinjection.SpellChecker;

class SpellCheckerTest {

    @Test
    void isValid(){
        //SpellChecker spellChecker = new SpellChecker(new DefaultDictionary()); // 기본 생성자로 전달받는 인젝션 방식
        SpellChecker spellChecker = new SpellChecker(DefaultDictionary::new); // 메서드 레퍼런스로 Supllier로 제공받음
        spellChecker.isValid("true");
    }

}