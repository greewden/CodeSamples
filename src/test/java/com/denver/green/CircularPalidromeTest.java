package com.denver.green;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by Lois on 12/26/2016.
 */
public class CircularPalidromeTest {
    @Test
    public void expandAroundCenter() throws Exception {
        //TimeUnit.SECONDS.sleep(15);
        String s = "aaaaabbbbaaaaa";
        assertEquals(14, CircularPalidrome.expandAroundCenter(s, 6, 7));

        s = "kjlgjfmenkgllefleenmfiljjiffikeilkmgeneljhekllfhnlfimnmjljlhlljehmniejehfgknnihmhfenihnghgnjkhnfhifglhgenggknnmmjnnnfjmgehlkjkkemiekmlhgggingnjhfgkiejhhfkimenfjkhgfngkniigknlmnifnkiknnjmghmjfneemiikemllgemgmejfkgjinnlfkkjhekmejlleeliinmfeemigkfhlehglegjngelkeeeinhjgkkkllnmmkleekfkfemmeheklffhgimhfmhffnekgkfehkgelielljnkfijghmiimhjelmkgegjehfekfgkjlmekhkfkgfjjkekmjgikjhefgkjmkflhnfflfmjnjelngmgehhmhlgelkljfhhhjnheemfhekemhlkeejmhgljnimgjglfhkkgjkihiinfjmkngmijklhmejljgfglffnfjjjfmlnemhjjllneeihlijljnnlfmiilekeijginjjmjikfmnilmlhmnemijkfnfnjffekfmnnfggfffkfmfjljeknhjgnllhgneilfelekknfimnkhkhkigigjngffffkfeelmilkhjhfhjknfflgfjnkfkifjeifkgjnlgfefghgimfgjkhnnjfijkfgjmflnmihgkjlnljfjeigmjkemfhigekkkgliiemjjfgkhmjhjnniiglelkljmmihiinfkjjnnelfljlehnhehgfkhnmkelhlnjgiii";
        assertEquals(2, CircularPalidrome.expandAroundCenter(s, 0, 0));
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
    public void longestPalindrom() throws Exception {
        String s = "kjlgjfmenkgllefleenmfiljjiffikeilkmgeneljhekllfhnlfimnmjljlhlljehmniejehfgknnihmhfenihnghgnjkhnfhifglhgenggknnmmjnnnfjmgehlkjkkemiekmlhgggingnjhfgkiejhhfkimenfjkhgfngkniigknlmnifnkiknnjmghmjfneemiikemllgemgmejfkgjinnlfkkjhekmejlleeliinmfeemigkfhlehglegjngelkeeeinhjgkkkllnmmkleekfkfemmeheklffhgimhfmhffnekgkfehkgelielljnkfijghmiimhjelmkgegjehfekfgkjlmekhkfkgfjjkekmjgikjhefgkjmkflhnfflfmjnjelngmgehhmhlgelkljfhhhjnheemfhekemhlkeejmhgljnimgjglfhkkgjkihiinfjmkngmijklhmejljgfglffnfjjjfmlnemhjjllneeihlijljnnlfmiilekeijginjjmjikfmnilmlhmnemijkfnfnjffekfmnnfggfffkfmfjljeknhjgnllhgneilfelekknfimnkhkhkigigjngffffkfeelmilkhjhfhjknfflgfjnkfkifjeifkgjnlgfefghgimfgjkhnnjfijkfgjmflnmihgkjlnljfjeigmjkemfhigekkkgliiemjjfgkhmjhjnniiglelkljmmihiinfkjjnnelfljlehnhehgfkhnmkelhlnjgiii";
        int max = CircularPalidrome.longestPalindrome(s);
        assertEquals(6, max);

        max = CircularPalidrome.longestPalindrome(CircularPalidrome.rotate(s, 3));
        assertEquals(6, max);

    }

}