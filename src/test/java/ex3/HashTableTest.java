package ex3;

import ex3.HashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void putOneElementOnEmptyTableNoCol() {
        HashTable h = new HashTable();
        //elemento introducido
        h.put("1", "prueba1");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, prueba1]", h.toString());
    }

    @Test
    void putOneElementOnUnemptyTableNoCol(){
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        //elemento introducido
        h.put("2", "prueba2");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, prueba1]\n" +
                " bucket[2] = [2, prueba2]", h.toString());
    }

    @Test
    void putOneElementOnUnemptyTableCol(){
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        //elemento introducido
        h.put("01", "prueba1");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, prueba1] -> [01, prueba1]", h.toString());
    }

    @Test
    void putOneElementOnUnemptyTableCol3(){
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba1");
        //elemento introducido
        h.put("12", "prueba1");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, prueba1] -> [01, prueba1] -> [12, prueba1]", h.toString());
    }

    @Test
    void updateOneElementOnEmptyTableNoCol() {
        HashTable h = new HashTable();
        //elemento introducido
        h.put("1", "prueba1");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, prueba1]", h.toString());
    }

    @Test
    void updateOneElementOnUnemptyTableNoCol() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        //elemento introducido
        h.put("1", "prueba2");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, prueba2]", h.toString());
    }

    @Test
    void updateOneElementOnUnemptyTableCol() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba1");
        //elemento introducido
        h.put("01", "prueba2");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, prueba1] -> [01, prueba2]", h.toString());
    }

    @Test
    void updateOneElementOnUnemptyTableCol3() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba1");
        h.put("12", "prueba1");
        //elemento introducido
        h.put("12", "prueba2");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, prueba1] -> [01, prueba1] -> [12, prueba2]", h.toString());
    }

    @Test
    void getElementFromEmptyTable() {
        HashTable h = new HashTable();
        Assertions.assertEquals(null, h.get("1"));
    }

    @Test
    void getElementFromUnemptyTableNCol() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba2");
        Assertions.assertEquals("prueba1", h.get("1"));
    }

    @Test
    void getElementFromUnemptyTableNCol2() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba2");
        Assertions.assertEquals("prueba2", h.get("01"));
    }

    @Test
    void getElementFromUnemptyTableNCol3() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba2");
        h.put("12", "prueba3");
        Assertions.assertEquals("prueba3", h.get("12"));
    }

    @Test
    void getUnexistentElementFromUnemptyTable() {
        HashTable h = new HashTable();
        h.put("2", "prueba1");
        Assertions.assertEquals(null, h.get("1"));
    }

    @Test
    void getUnexistentElementFromUnemptyTableWhereItsPosIsUsedNoCol() {
        HashTable h = new HashTable();
        h.put("01", "prueba1");
        Assertions.assertEquals(null, h.get("1"));
    }

    @Test
    void getUnexistentElementFromUnemptyTableWhereItsPosIsUsedCol3() {
        HashTable h = new HashTable();
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        Assertions.assertEquals(null, h.get("1"));
    }

    @Test
    void dropElementNoCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("2");
        Assertions.assertEquals("\n" +
                " bucket[1] = [01, prueba1] -> [12, prueba2] -> [23, prueba3]", h.toString());
    }

    @Test
    void dropElementCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("01");
        Assertions.assertEquals("\n" +
                " bucket[1] = [12, prueba2] -> [23, prueba3]\n" +
                " bucket[2] = [2, prueba]", h.toString());
    }

    @Test
    void dropElementCol2() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("12");
        Assertions.assertEquals("\n" +
                " bucket[1] = [01, prueba1] -> [23, prueba3]\n" +
                " bucket[2] = [2, prueba]", h.toString());
    }

    @Test
    void dropElementCol3() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("23");
        Assertions.assertEquals("\n" +
                " bucket[1] = [01, prueba1] -> [12, prueba2]\n" +
                " bucket[2] = [2, prueba]", h.toString());
    }

    @Test
    void dropUnexistentElement() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("3");
        Assertions.assertEquals("\n" +
                " bucket[1] = [01, prueba1] -> [12, prueba2] -> [23, prueba3]\n" +
                " bucket[2] = [2, prueba]", h.toString());
    }

    @Test
    void dropUnexistentElementWhichItsPositionIsTakenNoCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("13");
        Assertions.assertEquals("\n" +
                " bucket[1] = [01, prueba1] -> [12, prueba2] -> [23, prueba3]\n" +
                " bucket[2] = [2, prueba]", h.toString());
    }

    @Test
    void dropUnexistentElementWhichItsPositionIsTakenCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("1");
        Assertions.assertEquals("\n" +
                " bucket[1] = [01, prueba1] -> [12, prueba2] -> [23, prueba3]\n" +
                " bucket[2] = [2, prueba]", h.toString());
    }

    @Test
    void countPutOneElementOnEmptyTableNoCol() {
        HashTable h = new HashTable();
        //elemento introducido
        h.put("1", "prueba1");
        Assertions.assertEquals(1, h.count());
    }

    @Test
    void countPutOneElementOnUnemptyTableNoCol(){
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        //elemento introducido
        h.put("2", "prueba2");
        Assertions.assertEquals(2, h.count());
    }

    @Test
    void countPutOneElementOnUnemptyTableCol(){
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        //elemento introducido
        h.put("01", "prueba1");
        Assertions.assertEquals(2, h.count());
    }

    @Test
    void countPutOneElementOnUnemptyTableCol3(){
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba1");
        //elemento introducido
        h.put("12", "prueba1");
        Assertions.assertEquals(3, h.count());
    }

    @Test
    void countUpdateOneElementOnEmptyTableNoCol() {
        HashTable h = new HashTable();
        //elemento introducido
        h.put("1", "prueba1");
        Assertions.assertEquals(1, h.count());
    }

    @Test
    void countUpdateOneElementOnUnemptyTableNoCol() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        //elemento introducido
        h.put("1", "prueba2");
        Assertions.assertEquals(1, h.count());
    }

    @Test
    void countUpdateOneElementOnUnemptyTableCol() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba1");
        //elemento introducido
        h.put("01", "prueba2");
        Assertions.assertEquals(2, h.count());
    }

    @Test
    void countUpdateOneElementOnUnemptyTableCol3() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba1");
        h.put("12", "prueba1");
        //elemento introducido
        h.put("12", "prueba2");
        Assertions.assertEquals(3, h.count());
    }

    @Test
    void countDropElementNoCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("2");
        Assertions.assertEquals(3, h.count());
    }

    @Test
    void countDropElementCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("01");
        Assertions.assertEquals(3, h.count());
    }

    @Test
    void countDropElementCol2() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("12");
        Assertions.assertEquals(3, h.count());
    }

    @Test
    void countDropElementCol3() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("23");
        Assertions.assertEquals(3, h.count());
    }

    @Test
    void countDropUnexistentElement() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("3");
        Assertions.assertEquals(4, h.count());
    }

    @Test
    void countDropUnexistentElementWhichItsPositionIsTakenNoCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("13");
        Assertions.assertEquals(4, h.count());
    }

    @Test
    void countDropUnexistentElementWhichItsPositionIsTakenCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("1");
        Assertions.assertEquals(4, h.count());
    }

    @Test
    void sizePutOneElementOnEmptyTableNoCol() {
        HashTable h = new HashTable();
        //elemento introducido
        h.put("1", "prueba1");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizePutOneElementOnUnemptyTableNoCol(){
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        //elemento introducido
        h.put("2", "prueba2");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizePutOneElementOnUnemptyTableCol(){
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        //elemento introducido
        h.put("01", "prueba1");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizePutOneElementOnUnemptyTableCol3(){
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba1");
        //elemento introducido
        h.put("12", "prueba1");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeUpdateOneElementOnEmptyTableNoCol() {
        HashTable h = new HashTable();
        //elemento introducido
        h.put("1", "prueba1");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeUpdateOneElementOnUnemptyTableNoCol() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        //elemento introducido
        h.put("1", "prueba2");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeUpdateOneElementOnUnemptyTableCol() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba1");
        //elemento introducido
        h.put("01", "prueba2");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeUpdateOneElementOnUnemptyTableCol3() {
        HashTable h = new HashTable();
        h.put("1", "prueba1");
        h.put("01", "prueba1");
        h.put("12", "prueba1");
        //elemento introducido
        h.put("12", "prueba2");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeDropElementNoCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("2");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeDropElementCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("01");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeDropElementCol2() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("12");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeDropElementCol3() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("23");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeDropUnexistentElement() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("3");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeDropUnexistentElementWhichItsPositionIsTakenNoCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("13");
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void sizeDropUnexistentElementWhichItsPositionIsTakenCol() {
        HashTable h = new HashTable();
        h.put("2", "prueba");
        h.put("01", "prueba1");
        h.put("12", "prueba2");
        h.put("23", "prueba3");
        h.drop("1");
        Assertions.assertEquals(16, h.size());
    }

}