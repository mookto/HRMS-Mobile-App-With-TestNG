# HRMS-Mobile-App-With-TestNG

[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/) 
[![Gradle](https://img.shields.io/badge/Gradle-7.x-brightgreen.svg)](https://gradle.org/) 
[![TestNG](https://img.shields.io/badge/TestNG-7.x-orange.svg)](https://testng.org/) 
[![Appium](https://img.shields.io/badge/Appium-2.x-red.svg)](https://appium.io/) 
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

> A robust mobile automation framework for Android applications using Appium, TestNG, and HTMLReports.

---

## 🚀 Framework Highlights

- **AndroidDriver initialization** using Appium and UiAutomator2  
- **Reusable utilities** for:  
  - Scrolling and gestures  
  - Capturing screenshots  
  - Base64 screenshot encoding  
- **TestNG integration** for structured test management and parallel execution   
- **Automatic teardown and device unlock** after test execution  

---

## 🛠 Technology Stack

- **Java 17**  
- **Gradle** for build and dependency management  
- **Appium 2.x**  
- **TestNG**  
- **Selenium / Appium Java Client**  


---

## 📝Setup Instructions

1. Clone the repository:
   git clone https://github.com/mookto/HRMS-Mobile-App-With-TestNG.git

2. Install dependencies and build the project:
   gradle clean build

3. Start Appium Server:
   - Recommended: Appium 2.x
   - Default URL: http://127.0.0.1:4723/

4. Connect your device:
   adb devices

5. Update device and app capabilities in Setup.java:
   - deviceName & udid
   - platformVersion
   - appPackage & appActivity
  
---

## ▶️ Running Tests

- Run all tests via Gradle:
   gradle clean test

- Run a specific TestNG suite:
   gradle test -DtestngSuiteFile=testng.xml

- Run individual tests from IDE (IntelliJ/Eclipse)
---
## 📊 Reports & Screenshots =============================

- Generate detailed HTML reports including logs, screenshots, and pass/fail status.
- Screenshots stored in: src/test/resources/screenshots/
- Failed tests automatically capture screenshots in Base64 format for embedding in reports.
---
## 🤝 Contributing =============================

- Fork the repository
- Create a feature/bugfix branch
- Commit your changes with descriptive messages
- Submit a Pull Request for review
---
## 📄 License =============================

This project is licensed under the MIT License – see the LICENSE file for details.

Author: Md. Mahedi Hasan
Project Status: Active & Maintained



