package recursivetree;

import student.TestCase;

/**
 * The test class for the BinaryTree class that ensures all methods
 * operate as expected.
 * 
 * @author Bengi Sevil
 * @version 06.19.2018
 */
public class BinaryTreeTest extends TestCase {
    private BinaryTree<String> tree1;
    private BinaryTree<String> tree2;
    private BinaryTree<String> tree3;
    private BinaryTree<String> tree4;


    /**
     * This method creates new BinaryTree objects.
     */
    public void setUp() {
        tree1 = new BinaryTree<String>("D");
        tree2 = new BinaryTree<String>("C");
        tree3 = new BinaryTree<String>("B", tree1, tree2);
        tree4 = new BinaryTree<String>("A", tree3, tree2);
    }


    /**
     * Tests the getElement method for accurate results.
     */
    public void testGetElement() {
        assertEquals("D", tree1.getElement());
    }


    /**
     * Tests the setElement method.
     */
    public void testSetElement() {
        tree1.setElement("X");
        assertEquals("X", tree1.getElement());
    }


    /**
     * Tests getLeft method.
     */
    public void testGetLeft() {
        assertEquals(null, tree1.getLeft());
        assertEquals(tree1, tree3.getLeft());
    }


    /**
     * Tests the getRight method.
     */
    public void testGetRight() {
        assertEquals(null, tree1.getRight());
        assertEquals(tree2, tree3.getRight());
    }


    /**
     * Tests setLeft.
     */
    public void testSetLeft() {
        tree1.setLeft(tree2);
        assertEquals(tree2, tree1.getLeft());
    }


    /**
     * Tests setLeft.
     */
    public void testSetRight() {
        tree1.setRight(tree2);
        assertEquals(tree2, tree1.getRight());
    }


    /**
     * Tests the size method.
     */
    public void testSize() {
        BinaryTree<String> tree = new BinaryTree<String>(null);
        assertEquals(0, tree.size());

        assertEquals(1, tree1.size());
        assertEquals(3, tree3.size());
        assertEquals(5, tree4.size());
    }


    /**
     * Tests the height method.
     */
    public void testHeight() {
        BinaryTree<String> tree = new BinaryTree<String>(null);
        assertEquals(0, tree.height());
        assertEquals(1, tree1.height());
        assertEquals(2, tree3.height());
        assertEquals(3, tree4.height());
    }


    /**
     * Tests the toPreOrderString method.
     */
    public void testToPreOrderString() {
        BinaryTree<String> temp = new BinaryTree(null);
        assertEquals("", temp.toPreOrderString());
        assertEquals("(D)", tree1.toPreOrderString());
        assertEquals("(B(D)(C))", tree3.toPreOrderString());
        assertEquals("(A(B(D)(C))(C))", tree4.toPreOrderString());
    }
    
    /**
     * Test the toInOrderString method
     */
    public void testToInOrderString() {
        BinaryTree<String> temp = new BinaryTree(null);
        assertEquals("", temp.toInOrderString());
        assertEquals("(D)", tree1.toInOrderString());
        assertEquals("((D)B(C))", tree3.toInOrderString());
        assertEquals("(((D)B(C))A(C))", tree4.toInOrderString());
    }
    
    /**
     * Test the toPostOrderString method
     */
    public void testToPostOrderString() {
        BinaryTree<String> temp = new BinaryTree(null);
        assertEquals("", temp.toPostOrderString());
        assertEquals("(D)", tree1.toPostOrderString());
        assertEquals("((D)(C)B)", tree3.toPostOrderString());
        assertEquals("(((D)(C)B)(C)A)", tree4.toPostOrderString());
    }
}
