# 🧪 Automation Test Suite – AutomationTestStore

This repository contains a Selenium-based automated test suite for validating core features of the [Automation Test Store](https://www.automationteststore.com/). The tests are written in **Java**, powered by **Selenium WebDriver**, and orchestrated using **TestNG**.

---

## 📦 Project Overview

This suite demonstrates:

- Dynamic user account creation (randomized input)
- Conditional item interaction based on inventory availability
- Page navigation and validation
- Data-driven execution using random generators

---

## ⚙️ Tech Stack

| Tool             | Description                            |
|------------------|----------------------------------------|
| Java             | Main programming language              |
| Selenium WebDriver | UI automation framework              |
| TestNG           | Test management & assertions           |
| ChromeDriver     | Chrome browser driver for Selenium     |

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java JDK 8 or higher
- Maven
- Chrome browser installed
- ChromeDriver in system path

### 🔧 Setup

Clone the repo and import into your preferred IDE.

Install dependencies via Maven:

```bash
mvn clean install
```

To run all tests:

```bash
mvn test
```

---

## 📋 Test Structure

The test suite is defined in a single Java class: `AotumationTestScors.java`.

Each test method has a defined `@Test(priority = X)` annotation and is self-contained.

---

## 🔍 Test Case Descriptions

### 1. `SignUp()` – 🧾 New Account Registration

**Status:** ✅ Enabled  
**Priority:** 1  
**Description:**  
Simulates user signup by:

- Visiting the Login/Register page
- Filling in user details with randomized names & email
- Selecting country & region via `<select>` elements
- Creating a secure password
- Submitting the form

**Highlights:**

```java
String RandomFirstName = firstnames[randomIndex];
Email.sendKeys(username + "@gmail.com");
Select mySelect = new Select(driver.findElement(By.id("AccountFrm_country_id")));
mySelect.selectByVisibleText("Jordan");
```

---

### 2. `LoginTest()` – 🔐 Login Existing User

**Status:** ❌ Disabled  
**Priority:** 2  
**Description:**  
Logs in using the credentials generated during the signup process.

> **Note:** Currently disabled via `enabled = false`.

```java
username.sendKeys(PublicUserName);
password.sendKeys("P@ssw0rd");
driver.findElement(By.xpath("//button[@title='Login']")).click();
```

---

### 3. `AddOneRandomItem()` – 🎲 Random Product View

**Status:** ✅ Enabled  
**Priority:** 3  
**Description:**  
Navigates to the **Men’s Products** section and clicks on a **randomly selected item** to test product accessibility and rendering.

```java
List<WebElement> Items = driver.findElements(By.cssSelector(".col-md-2.col-sm-2.col-xs-6.align_center"));
Items.get(rand.nextInt(Items.size())).click();
```

> Does **not** add the product to cart yet.

---

### 4. `AddRandomItems()` – 🛒 Conditional Add to Cart

**Status:** ✅ Enabled  
**Priority:** 4  
**Description:**

- Opens homepage product list
- Selects the first product
- Checks if item is **in stock**
- If available, clicks the cart icon to add item

```java
if (!ItemMassage.contains("Out")) {
  driver.findElements(By.cssSelector(".fa.fa-cart-plus.fa-fw")).get(rand.nextInt(1)).click();
}
```

Handles **“Out of Stock”** conditions gracefully using a fallback navigation.

---

## 📂 Folder Structure (suggested)

```
src
└── test
    └── java
        └── com
            └── example
                └── tests
                    └── AotumationTestScors.java
```

---

## 📌 Best Practices & Notes

- Use `WebDriverWait` instead of `Thread.sleep()` for stability
- Sensitive data (e.g. passwords) should be externalized in config
- Consider separating **page locators** into a Page Object Model (POM)
- Add `@AfterTest` or `@AfterClass` to close the driver using `driver.quit()`

---

## 🔚 Future Improvements

- Add assertions to validate page titles or messages
- Export logs and test reports via TestNG or Allure
- Parameterize input data (e.g. names, email) via a `.csv` or `.json`

---

## 🤝 Author

**Mousa AbuKhaled**  
QA Engineer & Automation Developer  
_Contact for collaboration or contributions._

---
