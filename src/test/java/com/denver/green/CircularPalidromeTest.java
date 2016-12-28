package com.denver.green;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by Lois on 12/26/2016.
 */
public class CircularPalidromeTest {
    @Test
    public void isPalindrome() throws Exception {
        //TimeUnit.SECONDS.sleep(15);
        String s = "aaaaabbbbaaaaa";
        assertTrue(CircularPalidrome.isPalindrome(s));

        s = "kjlgjfmenkgllefleenmfiljjiffikeilkmgeneljhekllfhnlfimnmjljlhlljehmniejehfgknnihmhfenihnghgnjkhnfhifglhgenggknnmmjnnnfjmgehlkjkkemiekmlhgggingnjhfgkiejhhfkimenfjkhgfngkniigknlmnifnkiknnjmghmjfneemiikemllgemgmejfkgjinnlfkkjhekmejlleeliinmfeemigkfhlehglegjngelkeeeinhjgkkkllnmmkleekfkfemmeheklffhgimhfmhffnekgkfehkgelielljnkfijghmiimhjelmkgegjehfekfgkjlmekhkfkgfjjkekmjgikjhefgkjmkflhnfflfmjnjelngmgehhmhlgelkljfhhhjnheemfhekemhlkeejmhgljnimgjglfhkkgjkihiinfjmkngmijklhmejljgfglffnfjjjfmlnemhjjllneeihlijljnnlfmiilekeijginjjmjikfmnilmlhmnemijkfnfnjffekfmnnfggfffkfmfjljeknhjgnllhgneilfelekknfimnkhkhkigigjngffffkfeelmilkhjhfhjknfflgfjnkfkifjeifkgjnlgfefghgimfgjkhnnjfijkfgjmflnmihgkjlnljfjeigmjkemfhigekkkgliiemjjfgkhmjhjnniiglelkljmmihiinfkjjnnelfljlehnhehgfkhnmkelhlnjgiii";
        assertFalse(CircularPalidrome.isPalindrome(s));
    }

    @Test
    public void rotate() throws Exception {
        //TimeUnit.SECONDS.sleep(15);
        //String s = "aaaaabbbbaaaa";
        String s = "kjlgjfmenkgllefleenmfiljjiffikeilkmgeneljhekllfhnlfimnmjljlhlljehmniejehfgknnihmhfenihnghgnjkhnfhifglhgenggknnmmjnnnfjmgehlkjkkemiekmlhgggingnjhfgkiejhhfkimenfjkhgfngkniigknlmnifnkiknnjmghmjfneemiikemllgemgmejfkgjinnlfkkjhekmejlleeliinmfeemigkfhlehglegjngelkeeeinhjgkkkllnmmkleekfkfemmeheklffhgimhfmhffnekgkfehkgelielljnkfijghmiimhjelmkgegjehfekfgkjlmekhkfkgfjjkekmjgikjhefgkjmkflhnfflfmjnjelngmgehhmhlgelkljfhhhjnheemfhekemhlkeejmhgljnimgjglfhkkgjkihiinfjmkngmijklhmejljgfglffnfjjjfmlnemhjjllneeihlijljnnlfmiilekeijginjjmjikfmnilmlhmnemijkfnfnjffekfmnnfggfffkfmfjljeknhjgnllhgneilfelekknfimnkhkhkigigjngffffkfeelmilkhjhfhjknfflgfjnkfkifjeifkgjnlgfefghgimfgjkhnnjfijkfgjmflnmihgkjlnljfjeigmjkemfhigekkkgliiemjjfgkhmjhjnniiglelkljmmihiinfkjjnnelfljlehnhehgfkhnmkelhlnjgiii";
        String actual = CircularPalidrome.rotate(s, 0);
        assertEquals(s, actual);

        actual = CircularPalidrome.rotate(s, 1);
        assertEquals("jlgjfmenkgllefleenmfiljjiffikeilkmgeneljhekllfhnlfimnmjljlhlljehmniejehfgknnihmhfenihnghgnjkhnfhifglhgenggknnmmjnnnfjmgehlkjkkemiekmlhgggingnjhfgkiejhhfkimenfjkhgfngkniigknlmnifnkiknnjmghmjfneemiikemllgemgmejfkgjinnlfkkjhekmejlleeliinmfeemigkfhlehglegjngelkeeeinhjgkkkllnmmkleekfkfemmeheklffhgimhfmhffnekgkfehkgelielljnkfijghmiimhjelmkgegjehfekfgkjlmekhkfkgfjjkekmjgikjhefgkjmkflhnfflfmjnjelngmgehhmhlgelkljfhhhjnheemfhekemhlkeejmhgljnimgjglfhkkgjkihiinfjmkngmijklhmejljgfglffnfjjjfmlnemhjjllneeihlijljnnlfmiilekeijginjjmjikfmnilmlhmnemijkfnfnjffekfmnnfggfffkfmfjljeknhjgnllhgneilfelekknfimnkhkhkigigjngffffkfeelmilkhjhfhjknfflgfjnkfkifjeifkgjnlgfefghgimfgjkhnnjfijkfgjmflnmihgkjlnljfjeigmjkemfhigekkkgliiemjjfgkhmjhjnniiglelkljmmihiinfkjjnnelfljlehnhehgfkhnmkelhlnjgiiik", actual);

        actual = CircularPalidrome.rotate(s, 2);
        assertEquals("lgjfmenkgllefleenmfiljjiffikeilkmgeneljhekllfhnlfimnmjljlhlljehmniejehfgknnihmhfenihnghgnjkhnfhifglhgenggknnmmjnnnfjmgehlkjkkemiekmlhgggingnjhfgkiejhhfkimenfjkhgfngkniigknlmnifnkiknnjmghmjfneemiikemllgemgmejfkgjinnlfkkjhekmejlleeliinmfeemigkfhlehglegjngelkeeeinhjgkkkllnmmkleekfkfemmeheklffhgimhfmhffnekgkfehkgelielljnkfijghmiimhjelmkgegjehfekfgkjlmekhkfkgfjjkekmjgikjhefgkjmkflhnfflfmjnjelngmgehhmhlgelkljfhhhjnheemfhekemhlkeejmhgljnimgjglfhkkgjkihiinfjmkngmijklhmejljgfglffnfjjjfmlnemhjjllneeihlijljnnlfmiilekeijginjjmjikfmnilmlhmnemijkfnfnjffekfmnnfggfffkfmfjljeknhjgnllhgneilfelekknfimnkhkhkigigjngffffkfeelmilkhjhfhjknfflgfjnkfkifjeifkgjnlgfefghgimfgjkhnnjfijkfgjmflnmihgkjlnljfjeigmjkemfhigekkkgliiemjjfgkhmjhjnniiglelkljmmihiinfkjjnnelfljlehnhehgfkhnmkelhlnjgiiikj", actual);

        actual = CircularPalidrome.rotate(s, s.length());
        assertEquals(s, actual);
    }

    @Test
    public void maxPalindromeLen() throws Exception {
        //TimeUnit.SECONDS.sleep(15);
        StringBuilder s = new StringBuilder("kjlgjfmenkgllefleenmfiljjiffikeilkmgeneljhekllfhnlfimnmjljlhlljehmniejehfgknnihmhfenihnghgnjkhnfhifglhgenggknnmmjnnnfjmgehlkjkkemiekmlhgggingnjhfgkiejhhfkimenfjkhgfngkniigknlmnifnkiknnjmghmjfneemiikemllgemgmejfkgjinnlfkkjhekmejlleeliinmfeemigkfhlehglegjngelkeeeinhjgkkkllnmmkleekfkfemmeheklffhgimhfmhffnekgkfehkgelielljnkfijghmiimhjelmkgegjehfekfgkjlmekhkfkgfjjkekmjgikjhefgkjmkflhnfflfmjnjelngmgehhmhlgelkljfhhhjnheemfhekemhlkeejmhgljnimgjglfhkkgjkihiinfjmkngmijklhmejljgfglffnfjjjfmlnemhjjllneeihlijljnnlfmiilekeijginjjmjikfmnilmlhmnemijkfnfnjffekfmnnfggfffkfmfjljeknhjgnllhgneilfelekknfimnkhkhkigigjngffffkfeelmilkhjhfhjknfflgfjnkfkifjeifkgjnlgfefghgimfgjkhnnjfijkfgjmflnmihgkjlnljfjeigmjkemfhigekkkgliiemjjfgkhmjhjnniiglelkljmmihiinfkjjnnelfljlehnhehgfkhnmkelhlnjgiii");
        int max = CircularPalidrome.maxPalindromeLen(s);
        assertEquals(6, max);

        max = CircularPalidrome.maxPalindromeLen(new StringBuilder(CircularPalidrome.rotate(s.toString(), 3)));
        assertEquals(6, max);

    }

}