package com.deere.global;

import com.deere.test_suites.EquipmentTestSuite;
import com.deere.test_suites.HomeTestSuite;
import com.deere.test_suites.ManagementTestSuite;
import org.testng.annotations.Test;

public class SmokeTestSuite extends ExecutionConfiguration implements CommonTestSuite {

    @Override @Test
    public void TC13716() {
        HomeTestSuite.test_TC13716();
    }

    @Override @Test
    public void TC14110(){ HomeTestSuite.test_TC14110();}

    @Override @Test
    public void TC13791() {ManagementTestSuite.test_TC13791();}

    @Override @Test
    public void TC13801() {
        EquipmentTestSuite.test_TC13801();
    }
}