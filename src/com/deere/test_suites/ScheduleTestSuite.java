package com.deere.test_suites;

import com.deere.global.ApplicationLogin;
import com.deere.global.BrowserConfiguration;
import com.deere.global.CommonConstants;
import com.deere.global.CommonFunctions;
import com.deere.page_actions.ManagementPageActions;
import com.deere.page_actions.SchedulePageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ScheduleTestSuite {
    public static void test_TC13758() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.clickOnCheckBox1();
        schedulePage.assignApplicator();
    }

    public static void test_TC13758_A() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13758_A");
        schedulePage.clickOnAdvancedFilterButton(inputTestDetails);
        Assert.assertEquals(schedulePage.getAdvancedCustomerName(), "Customer Name >> Customer_DO Not Delete-1214223873   Farm Name >> Johnson   Field Name >> Johnsons");
    }

    public static void test_TC13758_B() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String[] inputTestDetails = CommonFunctions.getTestData(CommonConstants.REGRESSION_SUITE, "TC13758_B");
        schedulePage.enterSearchField(inputTestDetails[0]);
        Assert.assertEquals(schedulePage.assertSearchText(), "Customer_DO Not Delete-1214223873");
        schedulePage.clickPopUpAdvancedFilterButton(inputTestDetails);
        Assert.assertEquals(schedulePage.getAdvancedCustomerName(), "Customer Name >> Customer_DO Not Delete-1214223873");
        schedulePage.clickOnResetFilter();
    }

    public static void test_TC13758_C() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.clickApplicatorTabAndSelectOrder();
        schedulePage.clickOnChangeAssignmentButton();
        assignOrderToApplicatorAndVerify(schedulePage);
    }

    public static void test_TC13758_D() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.clickOnApplicatorTab();
        schedulePage.enableGetDirectionButton();
        schedulePage.clickGetDirectionButton();
        Assert.assertEquals(schedulePage.assertPopUp(), "Get Directions will open in a new window provided by Google Maps™");
        Assert.assertEquals(schedulePage.assertAddButton(), "Add >>");
        Assert.assertEquals(schedulePage.assertRemoveButton(), "<< Remove");
        Assert.assertFalse(schedulePage.assertLandMark().size() == 0);
    }

    public static void test_TC13758_E() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.clickApplicatorTabAndSelectOrder();
        schedulePage.clickAssignTenderButton();
    }

    public static void test_TC13772() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.verifyOrdersFunctionality();
    }

    public static void test_TC13773() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ManagementPageActions managementPage = PageFactory.initElements(BrowserConfiguration.driver, ManagementPageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        Assert.assertTrue(schedulePage.assertTodayDate());
        Assert.assertFalse(schedulePage.assertOrderRolloverPrevious());
        schedulePage.assertOrderRolloverNext();
        schedulePage.orderRolloverOption();
        managementPage.navigateToSchedulePageOptionsPage();
        schedulePage.managementTabAdjustTime();
        managementPage.clickOnSaveButton();
    }

    public static void test_TC13819() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.clickOnApplicatorTab();
        schedulePage.expandAllApplicators();
        schedulePage.checkChangeAssignmentBtnStatus("Applicator");
        String uniqueOrder = schedulePage.findUniqueOrder("appList");
        String selectedApplicator = schedulePage.selectUniqueOrderEntity("appList", uniqueOrder);
        schedulePage.verifyAndClickChangeAssignmentBtn("Applicator");
        String selectedApplicatorFromPopup = schedulePage.assignToApplicator(selectedApplicator);
        schedulePage.verifyReassignedOrderApplicator(uniqueOrder, selectedApplicatorFromPopup);
    }

    public static void test_TC13820() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        String noTenderOrder = schedulePage.findNoTenderOrder();
        schedulePage.clickOnTendersTab();
        Assert.assertFalse(CommonFunctions.isElementPresent
                (By.xpath("//div[@id='tenderFragment']//a[contains(@id,'show')][text()='" + noTenderOrder + "']")));
    }

    public static void test_TC13838() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.searchTextBoxFieldOrdersSubTab();
        schedulePage.searchTextBoxFieldApplicatorsSubTab();
        schedulePage.searchTextBoxFieldTendersSubTab();
        schedulePage.searchOrder();
        schedulePage.searchCustomer();
        schedulePage.searchFarm();
        schedulePage.searchField();
    }

    public static void test_TC13847() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.clickOnApplicatorTab();
        Assert.assertFalse(schedulePage.assertOrderImagesIcon());
    }

    public static void test_TC13862() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.linkingCustomerFarmField();
    }

    public static void test_TC15938() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.clickApplicatorTabAndSelectOrder();
        schedulePage.clickProductTotalButton();
        Assert.assertTrue(schedulePage.assertTotalWorkHourSelected() != null);
        Assert.assertTrue(schedulePage.assertOrderID());
        schedulePage.clickPrintButton();
    }

    public static void test_TC21247() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.clickOnMultipleOrderCheckBoxes();
        schedulePage.clickOnAssignButton("right");
        assignOrderToApplicatorAndVerify(schedulePage);
    }

    public static void test_TC21248() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.clickOnMultipleOrderCheckBoxes();
        schedulePage.clickOnAssignButton("left");
        assignOrderToApplicatorAndVerify(schedulePage);
    }

    public static void test_TC21315() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.clickOnTendersTab();
        schedulePage.checkChangeAssignmentBtnStatus("Tenders");
        String uniqueOrder = schedulePage.findUniqueOrder("tenderList");
        String selectedTender = schedulePage.selectUniqueOrderEntity("tenderList", uniqueOrder);
        schedulePage.verifyAndClickChangeAssignmentBtn("Tenders");
        String selectedApplicatorFromPopup = schedulePage.assignToTender(selectedTender);
        schedulePage.verifyReassignedOrderTender(uniqueOrder, selectedApplicatorFromPopup);
    }

    public static void test_TC21316() {
        SchedulePageActions schedulePage = PageFactory.initElements(BrowserConfiguration.driver, SchedulePageActions.class);
        ApplicationLogin.LoginToAgLogicWeb();
        schedulePage.assertAssignOrdersToApplicator(schedulePage.assertOrderTabAssign());
    }

    private static void assignOrderToApplicatorAndVerify(SchedulePageActions schedulePage) {
        String applicatorName = schedulePage.getSecondApplicatorName();
        List<String> orderNumbers = schedulePage.getOrderNumbers();
        schedulePage.assignOrderToApplicator();
        schedulePage.verifyAssignedOrderWithApplicator(applicatorName, orderNumbers);
    }
}