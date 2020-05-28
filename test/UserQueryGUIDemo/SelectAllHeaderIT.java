/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserQueryGUIDemo;

import otherUtility.SelectAllHeader;
import java.awt.Component;
import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author soyebahmed
 */
public class SelectAllHeaderIT {
    
    public SelectAllHeaderIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTableCellRendererComponent method, of class SelectAllHeader.
     */
    @Test
    public void testGetTableCellRendererComponent() {
        System.out.println("getTableCellRendererComponent");
        JTable table = null;
        Object value = null;
        boolean isSelected = false;
        boolean hasFocus = false;
        int row = 0;
        int column = 0;
        SelectAllHeader instance = null;
        Component expResult = null;
        Component result = instance.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUI method, of class SelectAllHeader.
     */
    @Test
    public void testUpdateUI() {
        System.out.println("updateUI");
        SelectAllHeader instance = null;
        instance.updateUI();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
