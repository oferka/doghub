package org.hk.doghub.automation.e2e.selenium.mapping.provider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestCasesElementLocatorProvider {

    public By getTestCasesHeader() {
        return By.xpath("//h2[@class='title text-center']/child::b");
    }

    public By getTestCaseLinks() {
        return By.xpath(TEST_CASE_ROOT + TEST_CASE_HEADER);
    }

    public By getTestCaseLink(int testCaseIndex) {
        return By.xpath(format(TEST_CASE_ROOT + "[%s]" + TEST_CASE_HEADER, testCaseIndex));
    }

    public By getTestCaseStepListItems(int testCaseIndex) {
        return By.xpath(format(TEST_CASE_ROOT + "[%s]/div[@class='panel panel-default']/div[contains(@id, 'collapse')]/ul/li", testCaseIndex));
    }

    private static final String TEST_CASE_ROOT = "//section[@id='form']/div[@class='container']/div[@class='panel-group']";

    private static final String TEST_CASE_HEADER = "/div[@class='panel panel-default']/div[@class='panel-heading']/h4[@class='panel-title']/a[@data-toggle='collapse' and contains(@href,'collapse')]";
}
