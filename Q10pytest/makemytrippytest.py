import time
import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


# fixture to initialise the browser driver
@pytest.fixture
def driver():
    driver = webdriver.Chrome()
    yield driver
    driver.quit()

 # method to open browser
def test_makemytrip_flight_search(driver):
    driver.get("https://www.makemytrip.com/")

    time.sleep(2)
    WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//a[contains(@data-cy, 'LoginFlowPopup_97')]"))).click()
    time.sleep(2)
    driver.back()
    time.sleep(2)

    
    WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.LINK_TEXT, "Flights"))).click()

    time.sleep(3)

    #to Select ROUND TROP
    
    WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//li[text()='Round Trip']"))).click()

    time.sleep(3)

    # to Enter FROM Location as HYD
    driver.find_element(By.ID, "fromCity").send_keys("HYD")
    WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//p[text()='Hyderabad, India']"))).click()

    time.sleep(3)

    # to Enter TO Location as MAA
    driver.find_element(By.ID, "toCity").send_keys("MAA")
    WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//p[text()='Chennai, India']"))).click()

    time.sleep(3)

    #to  Select DEPARTURE Date (27 August 2023)
    driver.find_element(By.XPATH, "//span[text()='Departure']").click()
    WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//div[contains(@aria-label, 'Sun Aug 27 2023')]"))).click()

    time.sleep(3)

    #to Select RETURN Date (31 August 2023)
    driver.find_element(By.XPATH, "//span[text()='Return']").click()
    WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//div[contains(@aria-label, 'Thu Aug 31 2023')]"))).click()

    time.sleep(3)

    # to Click on Search Button
    driver.find_element(By.XPATH, "//a[text()='Search']").click()

    time.sleep(15)

    WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.XPATH, "//button[text()= 'OKAY, GOT IT!']"))).click()

    time.sleep(2)

    # to Validate the presence of flight details on the search results page
    flight_details = driver.find_elements(By.XPATH, "//div[@class='listingCardWrap']")
    assert len(flight_details) > 0, "flight details found on the search results page."
    print("flight details found on the search results page.")
    time.sleep(5)
